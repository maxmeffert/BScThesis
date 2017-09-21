package org.softlang.maxmeffert.bscthesis.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

import java.lang.reflect.InvocationTargetException;

public class AntlrLexerFactory implements IAntlrLexerFactory {
    private final Class<Lexer> lexerClass;

    public AntlrLexerFactory(Class<Lexer> lexerClass) {
        this.lexerClass = lexerClass;
    }


    @Override
    public Lexer newLexer(CharStream charStream) {
        try {
            return lexerClass.getConstructor(CharStream.class).newInstance(charStream);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
