package org.softlang.megal.language.ui.highlighting

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration

class MegalAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {
	static val COMMENT_RULE = "RULE_COMMENT"

	override protected calculateId(String tokenName, int tokenType) {
		switch tokenName {
			case COMMENT_RULE:
				DefaultHighlightingConfiguration.COMMENT_ID
				
			// Map any other by supertypes method
			default:
				super.calculateId(tokenName, tokenType)
		}
	}

}
