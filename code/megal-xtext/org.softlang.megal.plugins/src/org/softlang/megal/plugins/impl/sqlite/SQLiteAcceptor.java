package org.softlang.megal.plugins.impl.sqlite;

import org.softlang.megal.plugins.api.antlr.ANTLRAcceptorPlugin;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteLexer;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteParser;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteParserFactory;

public class SQLiteAcceptor extends ANTLRAcceptorPlugin<SQLiteParser, SQLiteLexer> {

	@Override
	public ANTLRParserFactory<SQLiteParser, SQLiteLexer> getParserFactory() {
		return new SQLiteParserFactory();
	}

	

}
