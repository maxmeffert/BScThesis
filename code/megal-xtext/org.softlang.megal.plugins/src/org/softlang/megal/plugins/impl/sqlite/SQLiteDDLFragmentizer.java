package org.softlang.megal.plugins.impl.sqlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.antlr.v4.runtime.ParserRuleContext;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.antlr.ANTLRFragmentizerPlugin;
import org.softlang.megal.plugins.api.antlr.ANTLRParserFactory;
import org.softlang.megal.plugins.api.antlr.ANTLRUtils;
import org.softlang.megal.plugins.api.fragmentation.Fragments;
import org.softlang.megal.plugins.api.fragmentation.Fragments.Fragment;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteLexer;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteParser;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteParser.Create_table_stmtContext;
import org.softlang.megal.plugins.impl.sqlite.antlr.SQLiteParserFactory;

public class SQLiteDDLFragmentizer extends ANTLRFragmentizerPlugin<SQLiteParser, SQLiteLexer> {

	static private class CreateTableStmtRule extends FragmentationRule<Create_table_stmtContext> {

		@Override
		protected Class<Create_table_stmtContext> contextType() {
			return Create_table_stmtContext.class;
		}

		@Override
		protected boolean isAtom(Create_table_stmtContext context) {
			return true;
		}

		@Override
		protected boolean test(Create_table_stmtContext context) {
			return true;
		}

		@Override
		protected Collection<Fragment> createFragment(Entity entity, Artifact artifact,
				Create_table_stmtContext context) {
			
			Fragment f = Fragments.create(
					context.table_name().getText(),
					"SQLCreateTableFragment", 
					ANTLRUtils.originalText(context), 
					entity, 
					artifact
					);
			
			return Collections.singletonList(f);
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public Collection<FragmentationRule<? extends ParserRuleContext>> getRules() {
		
		Collection<FragmentationRule<? extends ParserRuleContext>> rules = new ArrayList<FragmentationRule<? extends ParserRuleContext>>();
		
		rules.add(new CreateTableStmtRule());
		
		return rules;
		
	}
	
	/**
	 * 
	 */
	@Override
	public ANTLRParserFactory<SQLiteParser, SQLiteLexer> getParserFactory() {
		return new SQLiteParserFactory();
	}

}
