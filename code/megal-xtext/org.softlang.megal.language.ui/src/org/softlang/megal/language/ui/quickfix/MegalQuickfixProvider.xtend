/*
* generated by Xtext
*/
package org.softlang.megal.language.ui.quickfix

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
class MegalQuickfixProvider extends DefaultQuickfixProvider {

//	@Fix(MegalValidator::NO_APPLICABLE_INSTANCE)
//	def createApplicableInstance(Issue issue, IssueResolutionAcceptor acceptor) {
//		val label = 'Create applicable instance'
//		val text = 'Creates an instance matching the required types.'
//		val image = null
//		val ISemanticModification fixByCreation = [ e, c |
//			// Obtain a matching factory
//			val extension fac = e.eClass.EPackage.EFactoryInstance as MegalFactory
//			// Cast as relationship
//			val r = e as Relationship
//			// Create a matching type
//			val q = createRelationshipType => [
//				left = copy(r.left.type)
//				name = r?.type?.name ?: c.xtextDocument.get(issue.offset, issue.length)
//				right = copy(r.right.type)
//			]
//			r.megamodel.declarations.add(r.megamodel.declarations.indexOf(r) + 1, q)
//			r.type = q
//		]
//		acceptor.accept(issue, label, text, image, fixByCreation)
//	}

//	def getMegamodel(Relationship relationship) {
//		return relationship.eContainer as Megamodel
//	}

}