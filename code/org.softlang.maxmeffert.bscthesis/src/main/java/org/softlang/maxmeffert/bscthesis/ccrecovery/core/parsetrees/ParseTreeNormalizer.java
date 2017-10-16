package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.strings.IStringUtils;

public class ParseTreeNormalizer implements IParseTreeNormalizer {

    private final IParseTreeFactory parseTreeFactory;
    private final ICollectionFactory collectionFactory;
    private final IStringUtils stringUtils;

    public ParseTreeNormalizer(IParseTreeFactory parseTreeFactory, ICollectionFactory collectionFactory, IStringUtils stringUtils) {
        this.parseTreeFactory = parseTreeFactory;
        this.collectionFactory = collectionFactory;
        this.stringUtils = stringUtils;
    }

    private IParseTree newParseTree(IParseTree parseTree) {
        return parseTreeFactory.newParseTree(parseTree.getName(), parseTree.getAntlrType(), parseTree.getTextSource());
    }

    @Override
    public IParseTree normalize(IParseTree parseTree) {
        IParseTree normalizedTree = newParseTree(parseTree);
        addNormalizedChildren(parseTree, normalizedTree);
        return normalizedTree;
    }

    private void addNormalizedChildren(IParseTree parseTree, IParseTree normalizedTree) {
        for(IParseTree child : parseTree.getChildren()) {
            IParseTree normalizedChild = normalize(child);
            if (hasText(normalizedChild)) {
                normalizedTree.addChildren(getAddableChildren(parseTree, normalizedChild));
            }
        }
    }

    private Iterable<IParseTree> getAddableChildren(IParseTree parent, IParseTree child) {
        if (hasAddableGrandChildren(parent, child)) {
            return child.getChildren();
        }
        return collectionFactory.newSingleton(child);
    }

    private boolean hasAddableGrandChildren(IParseTree parent, IParseTree child) {
        return hasText(parent) && hasText(child) && haveSameText(parent, child);
    }

    private boolean hasText(IParseTree tree) {
        return !stringUtils.isNullOrEmpty(tree.getTextSource().getText());
    }

    private boolean haveSameText(IParseTree tree1, IParseTree tree2) {
        String text1 = tree1.getTextSource().getText().trim();
        String text2 = tree2.getTextSource().getText().trim();
        return text1.equals(text2);
    }


}
