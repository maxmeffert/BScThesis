package org.softlang.megal.plugins.api.antlr;

import java.io.IOException;
import java.io.Reader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.megal.mi2.api.Artifact;

import com.google.common.io.CharSource;

/**
 * Abstract factory class for ANTLR4 generated parsers and lexers
 * 
 * @author maxmeffert
 *
 * @param <P> An ANTLR4 generated Parser class
 * @param <L> An ANTLR4 generated Lexer class
 */
public abstract class ANTLRParserFactory<P extends Parser, L extends Lexer> {

	//===================================================================
	// The interface to implement
	
	/**
	 * Gets a new lexer for the given char stream
	 * @param chars
	 * @return
	 */
	abstract public L getLexer (CharStream chars);
	
	/**
	 * Gets a new parser for the given token stream
	 * @param tokens
	 * @return
	 */
	abstract public P getParser (TokenStream tokens);
	
	/**
	 * Gets the initial parse tree form the given parser
	 * @param parser
	 * @return
	 */
	abstract public ParseTree getParseTree (P parser);
	
	//===================================================================
	// Pre-implemented utility overloads
	
	/**
	 * Gets a new lexer for the given reader
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	final public L getLexer (Reader reader) throws IOException {
		return getLexer(new ANTLRInputStream(reader));
	}
	
	/**
	 * Gets a new lexer for the given char source
	 * @param chars
	 * @return
	 * @throws IOException
	 */
	final public L getLexer (CharSource chars) throws IOException {
		return getLexer(chars.openStream());
	}
	
	/**
	 * Gets a new lexer for the given artifact
	 * @param artifact
	 * @return
	 * @throws IOException
	 */
	final public L getLexer (Artifact artifact) throws IOException {
		return getLexer(artifact.getChars());
	}
	
	/**
	 * Gets a new parser for the given lexer
	 * @param lexer
	 * @return
	 */
	final public P getParser (L lexer) {
		return getParser(new CommonTokenStream(lexer));
	}
	
	/**
	 * Gets a new parser for the given reader
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	final public P getParser (Reader reader) throws IOException {
		return getParser(getLexer(reader));
	}
	
	/**
	 * Gets a new parser for the given char source
	 * @param chars
	 * @return
	 * @throws IOException
	 */
	final public P getParser (CharSource chars) throws IOException {
		return getParser(getLexer(chars));
	}
	
	/**
	 * Gets a new parser for the given artifact
	 * @param artifact
	 * @return
	 * @throws IOException
	 */
	final public P getParser (Artifact artifact) throws IOException {
		return getParser(getLexer(artifact));
	}
	
	/**
	 * Gets the initial parse tree form the given reader
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	final public ParseTree getParseTree (Reader reader) throws IOException {
		return getParseTree(getParser(reader));
	}
	
	/**
	 * Gets the initial parse tree form the given char source
	 * @param chars
	 * @return
	 * @throws IOException
	 */
	final public ParseTree getParseTree (CharSource chars) throws IOException {
		return getParseTree(getParser(chars));
	}
	
	/**
	 * Gets the initial parse tree form the given artifact
	 * @param artifact
	 * @return
	 * @throws IOException
	 */
	final public ParseTree getParseTree (Artifact artifact) throws IOException {
		return getParseTree(getParser(artifact));
	}
	
	
}
