package org.softlang.megal.plugins.api.antlr;

import java.io.IOException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.AcceptorPlugin;
import com.google.common.base.Optional;
import com.google.common.base.Throwables;

public abstract class ANTLRAcceptorPlugin<P extends Parser, L extends Lexer> extends AcceptorPlugin implements ANTLRBackedPlugin<P,L> {

	static private class ParserException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 490177542839182761L;
		
	}
	
	static private class ErrorThrowingListener extends BaseErrorListener {
		
		@Override
		public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
				RecognitionException arg5) {
			
			throw new ParserException();
			
		}
		
	}
		
	@Override
	final public Optional<String> accept(Artifact artifact) {
		
		ANTLRParserFactory<P, L> parserFactory = getParserFactory();
		
		try {
			
			P parser = parserFactory.getParser(artifact);
			parser.removeErrorListeners();
			parser.addErrorListener(new ErrorThrowingListener());
			
			parserFactory.getParseTree(parser);
			
		} catch (ParserException e) {
			return Optional.of(Throwables.getStackTraceAsString(e));
		} catch (IOException e) {
			return Optional.of(Throwables.getStackTraceAsString(e));
		}
		
		return Optional.absent();
		
	}
	
}
