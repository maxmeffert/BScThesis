package org.softlang.megal.language.ui.highlighting

import org.eclipse.swt.SWT
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor
import org.eclipse.swt.graphics.RGB

class MegalHighlightingConfiguration extends DefaultHighlightingConfiguration {
	public static val ENTITY_ID = "entity";
	public static val RELATIONSHIP_ID = "relationship";
	public static val ENTITY_TYPE_ID = "entity_type";
	public static val RELATIONSHIP_TYPE_ID = "relationship_type";

	override configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor)

		// Initialize styles
		acceptor.acceptDefaultHighlighting(ENTITY_ID, "Entity", entityTextStyle)
		acceptor.acceptDefaultHighlighting(ENTITY_TYPE_ID, "Entity type", entityTypeTextStyle)
		acceptor.acceptDefaultHighlighting(RELATIONSHIP_ID, "Relationship", relationshipTextStyle)
		acceptor.acceptDefaultHighlighting(RELATIONSHIP_TYPE_ID, "Relationship type", relationshipTypeTextStyle)
	}

	def entityTextStyle() {
		defaultTextStyle.copy => []
	}

	def relationshipTextStyle() {
		defaultTextStyle.copy => [
			style = SWT.ITALIC
		]
	}

	def entityTypeTextStyle() {
		defaultTextStyle.copy => []
	}

	def relationshipTypeTextStyle() {
		defaultTextStyle.copy => [
			style = SWT.ITALIC
		]
	}
}
