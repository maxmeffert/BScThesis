package org.softlang.maxmeffert.bscthesis.ccrecovery.core.antlr;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.List;

public interface IAntlrParseTreeErrorNodeListener extends ParseTreeListener {
    List<ErrorNode> getErrorNodes();
}
