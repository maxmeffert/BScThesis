package org.softlang.megal.plugins.api.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

/**
 * 
 * @author maxmeffert
 *
 * @param <P>
 * @param <L>
 */
public interface ANTLRBackedPlugin<P extends Parser, L extends Lexer> {
	
	/**
	 * Gets a new parser factory
	 * @return
	 */
	public ANTLRParserFactory<P, L> getParserFactory ();

}
