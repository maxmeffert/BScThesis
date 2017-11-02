package org.softlang.megal.language.ui.highlighting

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.softlang.megal.MegalEntity
import org.softlang.megal.MegalEntityType
import org.softlang.megal.MegalPackage
import org.softlang.megal.MegalRelationship
import org.softlang.megal.MegalRelationshipType
import org.softlang.megal.MegalLink

class MegalSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {

	override protected highlightElement(EObject object, IHighlightedPositionAcceptor acceptor) {

		// Calculate a mapping from feature to highlight style
		switch p : stylesFor(object) {
			// If no mapping, use supertypes method
			case null: {
				return super.highlightElement(object, acceptor)
			}
			// If mappings exist, apply and prune
			default: {
				for (k : p)
					acceptor.highlightFeature(object, k.key, k.value)
				return true
			}
		}
	}

	/**
	 * Calculates the style mapping for an EObject or null if no style mapping
	 */
	def dispatch stylesFor(EObject object) {
		null
	}

	def dispatch stylesFor(MegalEntity object) {
		#[MegalPackage.Literals.MEGAL_NAMED__NAME -> MegalHighlightingConfiguration.ENTITY_ID]
	}

	def dispatch stylesFor(MegalEntityType object) {
		#[MegalPackage.Literals.MEGAL_NAMED__NAME -> MegalHighlightingConfiguration.ENTITY_TYPE_ID]
	}

	def dispatch stylesFor(MegalRelationship object) {
		#[MegalPackage.Literals.MEGAL_RELATIONSHIP__TYPE -> MegalHighlightingConfiguration.RELATIONSHIP_ID]
	}

	def dispatch stylesFor(MegalRelationshipType object) {
		#[MegalPackage.Literals.MEGAL_NAMED__NAME -> MegalHighlightingConfiguration.RELATIONSHIP_TYPE_ID]
	}

}
