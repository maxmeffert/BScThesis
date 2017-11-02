package org.softlang.megal.language.validation;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.softlang.megal.MegalPackage.Literals.MEGAL_NAMED__NAME;
import static org.softlang.megal.MegalPackage.Literals.MEGAL_PAIR__FIRST;
import static org.softlang.megal.MegalPackage.Literals.MEGAL_PAIR__SECOND;
import static org.softlang.megal.MegalPackage.Literals.MEGAL_PAIR__SET;
import static org.softlang.megal.MegalPackage.Literals.MEGAL_RELATIONSHIP__TYPE;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;
import org.softlang.megal.MegalElement;
import org.softlang.megal.MegalEntity;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalPair;
import org.softlang.megal.MegalRelationship;
import org.softlang.megal.language.MegalReasoning;
import org.softlang.megal.mi2.Element;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.Result;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class ModelExecutingValidation extends AbstractMegalValidator {
	private static final String IS_INVALID = "IsInvalid";

	@Check
	public void validateModel(final MegalFile megamodel) {
		// Perform the evaluation
		final Result result = MegalReasoning.getLocalResult(megamodel);

		// Marker class with scope
		class Marking {

			Multimap<MegalElement, EStructuralFeature> getLocations(Element element) {
				// Make a builder initializing the locations
				ImmutableMultimap.Builder<MegalElement, EStructuralFeature> builder = ImmutableMultimap.builder();

				if (element instanceof Entity) {
					// If the element is an entity
					Entity entity = (Entity) element;

					// Get the direct and the generated pair entities
					MegalEntity direct = MegamodelKB.resolve(false, megamodel, entity);
					MegalPair pair = MegamodelKB.resolvePair(false, megamodel, entity);

					// If direct exists, add
					if (direct != null)
						builder.put(direct, MEGAL_NAMED__NAME);

					// If generated pair exists, add
					if (pair != null) {
						builder.put(pair, MEGAL_PAIR__FIRST);
						builder.put(pair, MEGAL_PAIR__SECOND);
					}

				} else if (element instanceof Relationship) {
					Relationship relationship = (Relationship) element;

					// Get the direct and all generated relationships
					MegalRelationship direct = MegamodelKB.resolve(false, megamodel, relationship);
					MegalPair firstOf = MegamodelKB.resolveFirst(false, megamodel, relationship);
					MegalPair secondOf = MegamodelKB.resolveSecond(false, megamodel, relationship);
					MegalPair elementOf = MegamodelKB.resolveElement(false, megamodel, relationship);

					// If direct exists, add
					if (direct != null)
						builder.put(direct, MEGAL_RELATIONSHIP__TYPE);

					// If first of exists, add
					if (firstOf != null)
						builder.put(firstOf, MEGAL_PAIR__FIRST);

					// If second of exists, add
					if (secondOf != null)
						builder.put(secondOf, MEGAL_PAIR__SECOND);

					// If element of exists, add
					if (elementOf != null)
						builder.put(elementOf, MEGAL_PAIR__SET);
				}

				// Build the result
				return builder.build();
			}

			List<Element> firstOrderDelegate(Element element) {
				if (element instanceof EntityType) {
					EntityType entityType = (EntityType) element;
					if (entityType.getSupertype() != null)
						singletonList(entityType.getSupertype());
					else
						return emptyList();
				}

				if (element instanceof Entity)
					return singletonList(((Entity) element).getType());

				// TODO specialized relationship type
				if (element instanceof RelationshipType)
					return emptyList();

				if (element instanceof Relationship)
					return singletonList(((Relationship) element).getType());

				return emptyList();
			}

			boolean shouldOutput(Element element, boolean isNotConsidered) {
				// TODO Better rules for this

				// Local or top level
				if (element.hasAnnotation("Suppress"))
					return false;
				if (element.getKB().hasAnnotation("Suppress"))
					return false;

				if (isNotConsidered) {
					// Local or top level untyped not considered
					if (element.hasAnnotation("Suppress", "notConsidered"))
						return false;
					if (element.getKB().hasAnnotation("Suppress", "notConsidered"))
						return false;

					// Top level typed not considered
					if (element instanceof EntityType
							&& element.getKB().hasAnnotation("Suppress", "entityTypeNotConsidered"))
						return false;
					else if (element instanceof RelationshipType
							&& element.getKB().hasAnnotation("Suppress", "relationshipTypeNotConsidered"))
						return false;
					else if (element instanceof Entity
							&& element.getKB().hasAnnotation("Suppress", "entityNotConsidered"))
						return false;
					else if (element instanceof Relationship
							&& element.getKB().hasAnnotation("Suppress", "relationshipNotConsidered"))
						return false;
				}

				for (Element delegate : firstOrderDelegate(element))
					if (!shouldOutput(delegate, isNotConsidered))
						return false;

				return true;
			}

			void infoOnLocations(Element element, String text) {
				if (shouldOutput(element, false))
					for (Entry<MegalElement, EStructuralFeature> location : getLocations(element).entries())
						info(text, location.getKey(), location.getValue());
			}

			void warningOnLocations(Element element, String text) {
				if (shouldOutput(element, false))
					for (Entry<MegalElement, EStructuralFeature> location : getLocations(element).entries())
						warning(text, location.getKey(), location.getValue());
			}

			void errorOnLocations(Element element, String text) {
				if (shouldOutput(element, false))
					for (Entry<MegalElement, EStructuralFeature> location : getLocations(element).entries())
						error(text, location.getKey(), location.getValue());
			}

			void notConsideredOnLocations(Element element, String text) {
				if (shouldOutput(element, true))
					for (Entry<MegalElement, EStructuralFeature> location : getLocations(element).entries())
						warning(text, location.getKey(), location.getValue());
			}

			void execute() {
				// Mark errors for valid items that are supposed to be invalid
				for (Element element : result.getValid())
					if (element.hasAnnotation(IS_INVALID))
						errorOnLocations(element, createExpectedInvalidText(element));

				// Annotate all infos
				for (Entry<Element, String> message : result.getInfos().entries())
					infoOnLocations(message.getKey(), message.getValue());

				// Annotate all warnings
				for (Entry<Element, String> message : result.getWarnings(false).entries())
					// If expected invalid, output an information, else create warning
					if (message.getKey().hasAnnotation(IS_INVALID))
						infoOnLocations(message.getKey(), createAsExpectedWarning(message.getValue()));
					else
						warningOnLocations(message.getKey(), message.getValue());

				// Annotate all errors
				for (Entry<Element, String> message : result.getErrors(false).entries())
					// If expected invalid, output an information, else create error
					if (message.getKey().hasAnnotation(IS_INVALID))
						infoOnLocations(message.getKey(), createAsExpectedError(message.getValue()));
					else
						errorOnLocations(message.getKey(), message.getValue());

				// Annotate all the items that are not considered by evaluation
				for (Element notConsidered : result.notVisited())
					notConsideredOnLocations(notConsidered, createNotConsidered(notConsidered));
			}

		}

		new Marking().execute();
	}

	protected String createNotConsidered(Element notConsidered) {
		return "Element \"" + notConsidered + "\" was not considered";
	}

	protected String createAsExpectedError(String message) {
		return "Failed as expected with error \"" + message + "\"";
	}

	protected String createAsExpectedWarning(String message) {
		return "Failed as expected with warning \"" + message + "\"";
	}

	protected String createExpectedInvalidText(Element element) {
		return "The element \"" + element + "\" is valid, although it was expected to be invalid.";
	}
}
