package org.softlang.megal.sirius;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.xtend.lib.macro.declaration.Declaration;
import org.softlang.megal.Annotations;
import org.softlang.megal.MegalAnnotation;
import org.softlang.megal.MegalDeclaration;
import org.softlang.megal.MegalEntity;
import org.softlang.megal.MegalEntityType;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalNamed;
import org.softlang.megal.MegalPair;
import org.softlang.megal.MegalRelationship;
import org.softlang.megal.MegalRelationshipType;
import org.softlang.megal.language.scoping.MegalScopeProvider;
import org.softlang.megal.mi2.RelationshipType;

import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

public class MegalServices {

	public static final String SEPARATOR = "\r\n";

	public final static MegalServices INSTANCE = new MegalServices();

	private static final String COLOR = "Color";

	private static final Integer COLOR_RED_DEFAULT = 255;
	private static final Integer COLOR_GREEN_DEFAULT = 255;
	private static final Integer COLOR_BLUE_DEFAULT = 255;

	/**
	 * Returns all reflexive, transitive file imports imported in this megal
	 * file.
	 */
	public List<MegalFile> megalFiles(MegalFile file) {
		ImmutableList.Builder<MegalFile> builder = ImmutableList.builder();

		builder.add(file);
		builder.addAll(megalFilesImported(file));

		return builder.build();
	}

	/**
	 * Returns all transitive imported files.
	 */
	public List<MegalFile> megalFilesImported(MegalFile file) {
		LinkedHashSet<MegalFile> files = new LinkedHashSet<>();

		for (MegalFile importedMegalFile : file.getImports())
			files.addAll(megalFiles(importedMegalFile));

		return ImmutableList.copyOf(files);
	}

	/**
	 * Return all declaration of the given class in the megal file.
	 */
	public <T extends MegalDeclaration> List<T> declarations(MegalFile file, Class<T> cls) {
		List<T> declarations = new ArrayList<>();

		for (MegalFile megalFile : megalFiles(file))
			declarations.addAll(FluentIterable.from(megalFile.getDeclarations()).filter(cls).toList());

		return ImmutableList.copyOf(declarations);
	}

	/**
	 * Return all local definition of the give class.
	 */
	public <T extends MegalDeclaration> List<T> declarationsLocal(MegalFile node, Class<T> cls) {
		return FluentIterable.from(node.getDeclarations()).filter(cls).toList();
	}

	/**
	 * Returns all imported declarations of the of the given class.
	 */
	public <T extends MegalDeclaration> List<T> declarationsImport(MegalFile node, Class<T> cls) {
		List<T> declarations = new ArrayList<>();

		for (MegalFile megalFile : megalFilesImported(node))
			declarations.addAll(FluentIterable.from(megalFile.getDeclarations()).filter(cls).toList());

		return declarations;
	}

	public MegalFile megalFile(MegalDeclaration declaration) {
		return (MegalFile) declaration.eContainer();
	}

	public List<MegalEntity> entities(MegalFile node) {
		return declarations(node, MegalEntity.class);
	}

	public List<MegalEntity> entitiesLocal(MegalFile node) {
		return declarationsLocal(node, MegalEntity.class);
	}

	public List<MegalEntity> entitiesImport(MegalFile node) {
		return declarationsImport(node, MegalEntity.class);
	}

	public List<MegalEntityType> entityTypes(MegalFile node) {
		return declarations(node, MegalEntityType.class);
	}

	public List<MegalEntityType> entityTypesLocal(MegalFile node) {
		return declarationsLocal(node, MegalEntityType.class);
	}

	public List<MegalEntityType> entityTypesImport(MegalFile node) {
		return declarationsImport(node, MegalEntityType.class);
	}

	public List<MegalRelationship> relations(MegalFile node) {
		return declarations(node, MegalRelationship.class);
	}

	public List<MegalRelationship> relationsLocal(MegalFile node) {
		return declarationsLocal(node, MegalRelationship.class);
	}

	public List<MegalRelationship> relationsImport(MegalFile node) {
		return declarationsImport(node, MegalRelationship.class);
	}

	public List<MegalRelationshipType> relationshipTypes(MegalFile node) {
		return declarations(node, MegalRelationshipType.class);
	}

	public List<MegalRelationshipType> relationshipTypesLocal(MegalFile node) {
		return declarationsLocal(node, MegalRelationshipType.class);
	}

	public List<MegalRelationshipType> relationshipTypesImport(MegalFile node) {
		return declarationsImport(node, MegalRelationshipType.class);
	}

	public List<MegalPair> pairs(MegalFile node) {
		return declarations(node, MegalPair.class);
	}

	public List<MegalPair> pairsLocal(MegalFile node) {
		return declarationsLocal(node, MegalPair.class);
	}

	public List<MegalPair> pairsImport(MegalFile node) {
		return declarationsImport(node, MegalPair.class);
	}

	/**
	 * Returns the first Relationionshiptypes in this megal file that connects a
	 * pair of Entitytypes.
	 */
	public List<MegalRelationshipType> firstRelationshipTypesLocal(MegalFile node) {
		// TODO: Maybe switch to ordered implementation.
		Table<MegalEntityType, MegalEntityType, MegalRelationshipType> firstRelationshipTypesLocal = HashBasedTable
				.create();

		for (MegalRelationshipType mrt : relationshipTypesLocal(node))
			if (!firstRelationshipTypesLocal.contains(mrt.getLeft(), mrt.getRight()))
				firstRelationshipTypesLocal.put(mrt.getLeft(), mrt.getRight(), mrt);

		return ImmutableList.copyOf(firstRelationshipTypesLocal.values());
	}

	public List<MegalRelationshipType> merged(MegalRelationshipType relationshipType) {
		List<MegalRelationshipType> merged = new ArrayList<>();
		for (MegalRelationshipType current : FluentIterable.from(megalFile(relationshipType).getDeclarations())
				.filter(MegalRelationshipType.class))
			if (relationshipType.getLeft() == current.getLeft() && relationshipType.getRight() == current.getRight())
				merged.add(current);

		return merged;
	}

	public String lable(MegalEntity entity) {
		String name = entity.getName();
		if (entity.getType() != null && entity.getType() != null)
			name = name + ":" + entity.getType().getName();
		if (entity.isMany())
			name = name + "+";

		return name;
	}

	public String lable(MegalRelationship relationship) {
		MegalRelationshipType type = relationship.getType();
		if (type == null)
			return "UNDEFINED";

		return type.getName();
	}

	public String lable(MegalPair pair) {
		MegalEntity entity = pair.getSet();
		if (entity == null)
			return "UNDEFINED";

		return entity.getName();
	}

	public String lable(MegalEntityType entityType) {
		return entityType.getName();
	}

	public String lable(MegalRelationshipType relationshipType) {
		return Joiner.on(SEPARATOR).join(FluentIterable.from(merged(relationshipType)).transform(x -> x.getName()));
	}

	public Boolean isEntity(MegalEntityType entitiyType) {
		return "Entity".equals(entitiyType.getName());
	}

	/**
	 * Associated elements serve as additional source for the graphical mapping.
	 * Changes on associated elements lead to updated projection.
	 */
	public Collection<EObject> associatedElements(MegalEntity entity) {
		return ImmutableList.of(entity, entity.getType());
	}

	public Collection<EObject> associatedElements(MegalRelationship relationship) {
		return ImmutableList.of(relationship, relationship.getType(), relationship.getLeft(),
				relationship.getLeft().getType(), relationship.getRight(), relationship.getRight().getType());
	}

	public String error(MegalDeclaration declaration) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(declaration);
		if (diagnostic.getSeverity() == Diagnostic.ERROR)
			return diagnostic.getMessage();

		return null;
	}

	public String warning(MegalDeclaration declaration) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(declaration);
		if (diagnostic.getSeverity() == Diagnostic.WARNING)
			return diagnostic.getMessage();

		return null;
	}

	public MegalEntity resolveEntity(MegalFile node, String name) {
		return resolve(node, MegalEntity.class, name);
	}

	public MegalEntityType resolveEntityType(MegalFile node, String name) {
		return resolve(node, MegalEntityType.class, name);
	}

	public MegalRelationshipType resolveRelationshipType(MegalFile node, String name) {
		return resolve(node, MegalRelationshipType.class, name);
	}

	public <T extends MegalNamed> T resolve(MegalFile node, Class<T> cls, String name) {
		return MegalScopeProvider.resolve(node, cls, name);
	}

	/**
	 * Returns an unused name in the current scope for the given class.
	 */
	public <T extends MegalNamed> String unused(MegalFile megamodel, Class<T> cls) {
		int prefix = 1;
		while (true) {
			String name = cls.getSimpleName() + String.valueOf(prefix);
			if (resolveEntity(megamodel, name) == null)
				return name;
			prefix++;
		}
	}

	public String unusedEntityName(MegalFile megamodel) {
		return unused(megamodel, MegalEntity.class);
	}

	public String unusedEntityTypeName(MegalFile megamodel) {
		return unused(megamodel, MegalEntityType.class);
	}

	public String unusedRelationshipTypeName(MegalFile megamodel) {
		return unused(megamodel, MegalRelationshipType.class);
	}

	public EObject megalFileOverView(MegalDeclaration declaration, DNode dnode) {
		return ((DSemanticDecorator) dnode.eContainer()).getTarget();
	}

	public EObject megalFileOverView(MegalDeclaration declaration, DEdge dedge) {
		return ((DSemanticDecorator) dedge.eContainer()).getTarget();
	}

	public MegalAnnotation getAnnotation(MegalDeclaration entity, String name) {
		return entity.getAnnotations().stream().filter(x -> name.equals(x.getKey())).findAny().orElse(null);
	}

	private Integer get(MegalDeclaration declaration, int position) {

		MegalAnnotation annotation = getAnnotation(declaration, COLOR);

		if (annotation == null)
			return null;

		List<String> colorStrings = Annotations.getStrings(annotation);

		if (colorStrings.size() != 3)
			return null;

		String colorString = colorStrings.get(position);

		try {
			Integer color = Integer.valueOf(colorString);

			return color;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public Integer red(MegalEntity entity) {

		Integer color = get(entity, 0);

		if (color == null && entity.getType() != null)
			color = get(entity.getType(), 0);

		if (color == null)
			color = COLOR_RED_DEFAULT;

		return color;
	}

	public int green(MegalEntity entity) {
		Integer color = get(entity, 1);

		if (color == null && entity.getType() != null)
			color = get(entity.getType(), 1);

		if (color == null)
			color = COLOR_GREEN_DEFAULT;

		return color;
	}

	public int blue(MegalEntity entity) {
		Integer color = get(entity, 2);

		if (color == null && entity.getType() != null)
			color = get(entity.getType(), 2);

		if (color == null)
			color = COLOR_BLUE_DEFAULT;

		return color;
	}

	public Integer red(MegalEntityType entityType) {

		Integer color = get(entityType, 0);

		if (color == null)
			color = COLOR_RED_DEFAULT;

		return color;
	}

	public int green(MegalEntityType entityType) {
		Integer color = get(entityType, 1);

		if (color == null)
			color = COLOR_GREEN_DEFAULT;

		return color;
	}

	public int blue(MegalEntityType entityType) {
		Integer color = get(entityType, 2);

		if (color == null)
			color = COLOR_BLUE_DEFAULT;

		return color;
	}

	public boolean canRemove(MegalEntity entity) {
		for (MegalRelationship relationship : relationsLocal(megalFile(entity)))
			if (relationship.getLeft().equals(entity) || relationship.getRight().equals(entity))
				return false;

		for (MegalPair pairs : pairsLocal((megalFile(entity))))
			if (pairs.getSet().equals(entity))
				return false;

		return true;
	}

	public boolean canRemove(MegalEntityType entityType) {
		for (MegalRelationshipType relationshipType : relationshipTypes(megalFile(entityType)))
			if (relationshipType.getLeft().equals(entityType) || relationshipType.getRight().equals(entityType))
				return false;

		return true;
	}

	public int getLineRed(MegalDeclaration declaration) {
		if (error(declaration) != null)
			return 255;

		if (warning(declaration) != null)
			return 255;

		return 0;
	}

	public int getLineGreen(MegalDeclaration declaration) {
		if (warning(declaration) != null)
			return 255;

		return 0;
	}

	public int getLineBlue(MegalDeclaration declaration) {
		return 0;
	}
}
