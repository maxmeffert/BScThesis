package org.softlang.megal.mi2.api;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;

import java.util.Map;
import java.util.Set;

import org.softlang.megal.mi2.Element;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.KBs;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.context.ComposedContext;
import org.softlang.megal.mi2.api.context.Context;
import org.softlang.megal.mi2.api.emission.Emission;
import org.softlang.megal.mi2.api.resolution.Resolution;

import com.google.common.base.Throwables;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;

public class ModelExecutor {
	public static final String DEFAULT_PLUGIN_NAME = "Plugin";

	public static final String DEFAULT_PLUGIN_ANNOTATION_NAME = "Plugin";

	public static final String DEFAULT_PART_NAME = "partOf";

	public static final String DEFAULT_REALIZATION_NAME = "realizationOf";

	public static final String DEFAULT_VIRTUAL_ANNOTATION_NAME = "Virtual";

	private final String pluginName;

	private final String pluginAnnotationName;

	private final String partName;

	private final String realizationName;

	private final String virtualAnnotationName;

	public ModelExecutor() {
		this(DEFAULT_PLUGIN_NAME, DEFAULT_PLUGIN_ANNOTATION_NAME, DEFAULT_PART_NAME, DEFAULT_REALIZATION_NAME,
				DEFAULT_VIRTUAL_ANNOTATION_NAME);
	}

	public ModelExecutor(String pluginName, String pluginAnnotationName, String partName, String realizationName,
			String virtualAnnotationName) {
		this.pluginName = pluginName;
		this.pluginAnnotationName = pluginAnnotationName;
		this.partName = partName;
		this.realizationName = realizationName;
		this.virtualAnnotationName = virtualAnnotationName;
	}

	/**
	 * <p>
	 * Evaluates the input with the given resolution
	 * </p>
	 * 
	 * @param resolution
	 *            The resolution to use
	 * @param input
	 *            The input
	 * @return Returns the evaluation result
	 */
	public Result evaluate(final Resolution resolution, final KB input) {
		class Evaluation {
			final Map<Entity, Plugin> plugins;

			final Multimap<EntityType, Plugin> pluginsByEntityType;

			final Multimap<RelationshipType, Plugin> pluginsByRelationshipType;

			final Set<Element> valid;
			final SetMultimap<Element, String> infos;
			final SetMultimap<Element, String> warnings;
			final SetMultimap<Element, String> errors;
			final SetMultimap<Element, Plugin> contextLocked;

			Evaluation() {
				plugins = newHashMap();
				pluginsByEntityType = HashMultimap.create();
				pluginsByRelationshipType = HashMultimap.create();
				valid = newHashSet();
				infos = HashMultimap.create();
				warnings = HashMultimap.create();
				errors = HashMultimap.create();
				contextLocked = HashMultimap.create();
				
				// Get all instances of the plugin type
				EntityType pluginType = input.getEntityType(getPluginName());
				
				if (pluginType != null)
					for (Entity entityOrGroup : pluginType.getInstances())
						for (Entity entity : devirtualize(entityOrGroup)) {
							
							if (!entity.hasBinding())
								continue;
							// Try to load a class
							Class<? extends Plugin> pluginClass = resolution.getClass(entity.getBinding(),
									Plugin.class);
							
							// If class exists, instantiate it
							if (pluginClass != null)
								try {
									
									// Make instance
									Plugin plugin = pluginClass.newInstance();
									plugins.put(entity, plugin);
									// Connect to entity types
									for (EntityType entityType : input.getEntityTypes())
										if (entityType.getAnnotations(getPluginAnnotationName())
												.contains(entityOrGroup.getName())) {
											pluginsByEntityType.put(entityType, plugin);
											for (EntityType spec : entityType.getSpecializations())
												pluginsByEntityType.put(spec, plugin);
										}

									// Connect to relationship types
									for (RelationshipType relationshipType : input.getRelationshipTypes())
										if (relationshipType.getAnnotations(getPluginAnnotationName())
												.contains(entityOrGroup.getName())) {
											pluginsByRelationshipType.put(relationshipType, plugin);
											for (RelationshipType spec : relationshipType.getSpecializations())
												pluginsByRelationshipType.put(spec, plugin);
										}

								} catch (Throwable e) {
									errors.put(entity, Throwables.getStackTraceAsString(e));
								}

							else {
								errors.put(entity, "Plugin class " + entity.getBinding() + "  is not resolvable");
							}
						}

				// Get the partOf relationship type
				RelationshipType partOf = input.getRelationshipType(getPartName(), getPluginName(), getPluginName());
				if (partOf != null)
					// If it exists, iterate all the instances
					for (Relationship relationship : partOf.getInstances()) {
					// Get container and element
					Plugin container = plugins.get(relationship.getRight());
					Plugin item = plugins.get(relationship.getLeft());

					// If both exist, add element as part
					if (container != null && item != null)
					container.getParts().add(item);
					}

				// Get the realizationOf relationship type
				RelationshipType realizationOf = input.getRelationshipType(getRealizationName(), getPluginName(),
						KB.ENTITY);
				if (realizationOf != null)
					// If it exists, iterate all the instances
					for (Relationship relationship : realizationOf.getInstances()) {
					// Get the realizer
					Plugin realizer = plugins.get(relationship.getLeft());

					// If it exists, add entity as realized
					if (realizer != null)
					realizer.getRealization().add(relationship.getRight());
					}
			}

			Result run() {
				// Origin of generated elements for origin tracking of errors
				Map<Element, Element> origin = newHashMap();
				
				// Current knowledge base, initialized on input
				KB current = KBs.mutable();
				KBs.add(current, input);

				for (;;) {
					// Start current expansion base
					KB expansion = KBs.mutable();

					// Evaluate all the elements
					for (Element element : current.getElements()) {

						// Compose a local context
						Context context = createContext(origin, element);
//						System.out.println(pluginsByEntityType.size());
//						System.out.println(Iterables.size(select(ReasonerPlugin.class, element)));
						// Get the appropriate reasoners
						for (ReasonerPlugin plugin : select(ReasonerPlugin.class, element)) {
							
							// Try to get the output KB, catch an exception into
							// the error messages
							try {
								// If the plugin does not exceed element limits,
								// check if the context lock contains it
								// and skip if true
								if (!plugin.isContextBased() && !contextLocked.put(element, plugin))
									continue;

								KB output = Plugins.apply(plugin, context, element);

								// Annotate all the generated elements
								for (Element generated : output.getElements())
									// Entity is always element of the generated
									// KB, skip it
									if (!(generated instanceof EntityType
											&& EntityType.isTheEntityType((EntityType) generated)))
										// Do not overwrite existing origin
										// tracks
										if (!origin.containsKey(generated))
										origin.put(generated, element);

								// Add the output to the reasoner
								KBs.add(expansion, output);
							} catch (RuntimeException t) {
								System.err.println(t.getLocalizedMessage());
								context.warning(Throwables.getStackTraceAsString(t));
							} catch (Throwable t) {
								System.err.println(t.getLocalizedMessage());
								context.error(Throwables.getStackTraceAsString(t));
							}
						}
					}

					if (!KBs.add(current, expansion))
						break;
				}

				for (Element element : current.getElements()) {
					// Compose a local context
					Context context = createContext(origin, element);

					// Get appropriate evaluators
					for (EvaluatorPlugin plugin : select(EvaluatorPlugin.class, element))
						// Try to evaluate, catch an exception into the error
						// messages
						try {
							Plugins.apply(plugin, context, element);
						} catch (RuntimeException t) {
							context.warning(Throwables.getStackTraceAsString(t));
						} catch (Throwable t) {
							context.error(Throwables.getStackTraceAsString(t));
						}
				}

				// Return the result for the given parameters and the evaluator
				// state
				return Result.of(input, current, origin, valid, infos, warnings, errors);
			}

			Iterable<Entity> devirtualize(Entity entity) {
				if (entity.hasAnnotation(getVirtualAnnotationName()))
					return FluentIterable.from(entity.incoming(getPartName()))
							.transformAndConcat(r -> devirtualize(r.getLeft()));
				return singleton(entity);
			}

			/**
			 * <p>
			 * Creates the context with the given origin and the current
			 * element.
			 * </p>
			 * 
			 * @param origin
			 *            The origin tracking map
			 * @param element
			 *            The current element
			 * @return Returns a new context
			 */
			Context createContext(Map<Element, Element> origin, Element element) {
				Context context = new ComposedContext(resolution, new Emission() {
					@Override
					public void valid() {
						valid.add(getOrigin(origin, element));
					}

					@Override
					public void info(String message) {
						infos.put(getOrigin(origin, element), message);
					}

					@Override
					public void warning(String message) {
						warnings.put(getOrigin(origin, element), message);
					}

					@Override
					public void error(String message) {
						errors.put(getOrigin(origin, element), message);
					}

					@Override
					public void valid(Element x, Element... xs) {
						valid.add(getOrigin(origin, x));
						for (Element e : xs)
							valid.add(getOrigin(origin, e));
					}

					@Override
					public void info(String message, Element x, Element... xs) {
						infos.put(getOrigin(origin, x), message);
						for (Element e : xs)
							infos.put(getOrigin(origin, e), message);
					}

					@Override
					public void warning(String message, Element x, Element... xs) {
						warnings.put(getOrigin(origin, x), message);
						for (Element e : xs)
							warnings.put(getOrigin(origin, e), message);
					}

					@Override
					public void error(String message, Element x, Element... xs) {
						errors.put(getOrigin(origin, x), message);
						for (Element e : xs)
							errors.put(getOrigin(origin, e), message);

					}
				});

				return context;
			}

			/**
			 * <p>
			 * Gets the origin of the current element
			 * </p>
			 * 
			 * @param origin
			 *            The origin tracking map
			 * @param element
			 *            The current element
			 * @return Returns the origin
			 */
			Element getOrigin(Map<Element, Element> origin, Element element) {
				Element secondary = origin.get(element);

				return secondary == null ? element : secondary;
			}

			/**
			 * <p>
			 * Selects the desired type of plugin based on the associated
			 * element and the type of plugins.
			 * </p>
			 * 
			 * @param type
			 *            The type of plugins
			 * @param element
			 *            The associated element
			 * @return Returns an iterable of plugins
			 */
			<T extends Plugin> Iterable<T> select(Class<T> type, Element element) {
				// Filter the desired type
				return filter(select(element), type);
			}

			/**
			 * <p>
			 * Selects the plugins based on the associated element.
			 * </p>
			 * 
			 * @param element
			 *            The associated element
			 * @return Returns an iterable of plugins
			 */
			Iterable<Plugin> select(Element element) {
				if (element instanceof Entity) {
					// If entity, get the type
					Entity entity = (Entity) element;
					EntityType entityType = entity.getType();

					// If type exists, return all plugins by entity type
					if (entityType != null)
						return pluginsByEntityType.get(entityType);
					else
						return emptyList();
				} else if (element instanceof Relationship) {
					// If relationship, get the type
					Relationship relationship = (Relationship) element;
					RelationshipType relationshipType = relationship.getType();

					// If type exists, return all plugins by relationship type
					if (relationshipType != null)
						return pluginsByRelationshipType.get(relationshipType);
					else
						return emptyList();
				}

				// Else, no association possible
				return emptyList();
			}
		}

		return new Evaluation().run();
	}

	public String getPartName() {
		return partName;
	}

	public String getPluginAnnotationName() {
		return pluginAnnotationName;
	}

	public String getPluginName() {
		return pluginName;
	}

	public String getRealizationName() {
		return realizationName;
	}

	private String getVirtualAnnotationName() {
		return virtualAnnotationName;
	}
}
