package org.softlang.megal.language.scoping

import com.google.inject.Inject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.softlang.megal.MegalFile
import org.softlang.megal.MegalNamed
import org.softlang.megal.QueryParam
import org.softlang.megal.Selection

import static org.eclipse.xtext.scoping.IScope.NULLSCOPE
import static org.eclipse.xtext.scoping.Scopes.*

/**
 * This scope provider uses declarative mechanisms to determine local scopes for MegaL objects
 */
class MegalScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject IQualifiedNameProvider qualifiedNameProvider

	private def Iterable<MegalFile> allImports(MegalFile m) {
		m.imports + m.imports.map[allImports].flatten
	}

	private def IScope elementScope(MegalFile file, EReference reference) {
		// Declaration scope only for items that are declarations
		if (!MegalNamed.isAssignableFrom(reference.EType.instanceClass))
			return delegateGetScope(file, reference)

		// 'Cast' the instance class to match
		val type = reference.EType.instanceClass.asSubclass(MegalNamed)

		return elementScopeWith(file, type, NULLSCOPE)

	}

	private def IScope elementScopeWith(MegalFile file, Class<? extends MegalNamed> type, IScope parent) {
		var visible = parent
		for (i : file.imports)
			visible = elementScopeWith(i, type, visible)

		return scopeFor(file.declarations.filter(type), qualifiedNameProvider, visible)
	}

	def static <T extends MegalNamed> T resolve(MegalFile file, Class<T> type, String name) {
		// Return the first of type with the given name
		for (d : file.declarations.filter(type).filter[d|d.name == name])
			return d

		// Check all imports from the lowestmost first
		for (i : file.imports.reverseView) {
			val p = resolve(i, type, name)
			if (p != null)
				return p
		}

		return null
	}

	def scope_MegalEntity(MegalFile m, EReference r) {
		return elementScope(m, r)
	}

	def scope_MegalEntityType(MegalFile m, EReference r) {
		return elementScope(m, r)
	}

	def scope_MegalRelationshipType(MegalFile m, EReference r) {
		return elementScope(m, r)
	}

	def scope_QueryReference(Selection s, EReference r) {
		return scopeFor(s.select.filter(QueryParam))
	}
}
