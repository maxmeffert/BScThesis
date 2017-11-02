package org.softlang.megal.plugins.impl.sqlite.antlr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;

public class SQLiteParserFactory extends ANTLRParserFactory<SQLiteParser, SQLiteLexer> {

	@Override
	public SQLiteLexer getLexer(CharStream chars) {
		return new SQLiteLexer(chars);
	}

	@Override
	public SQLiteParser getParser(TokenStream tokens) {
		return new SQLiteParser(tokens);
	}

	@Override
	public ParseTree getParseTree(SQLiteParser parser) {
		return parser.sql_stmt_list();
	}

}
