package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragments;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.artifacts.IArtifact;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;

public interface IFragmentKBFactory {
    IFragmentKB newFragmentKB(ITree<ITextSource> parseTree);
    IFragmentKB newFragmentKB(IArtifact iArtifact);
}
