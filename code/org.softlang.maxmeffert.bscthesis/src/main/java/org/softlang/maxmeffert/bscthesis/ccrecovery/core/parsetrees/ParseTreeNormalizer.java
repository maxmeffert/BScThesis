package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.strings.IStringUtils;

public class ParseTreeNormalizer implements IParseTreeNormalizer {

    private final ITreeFactory treeFactory;
    private final IParseTreeFactory parseTreeFactory;
    private final ICollectionFactory collectionFactory;
    private final IStringUtils stringUtils;

    public ParseTreeNormalizer(ITreeFactory treeFactory, IParseTreeFactory parseTreeFactory, ICollectionFactory collectionFactory, IStringUtils stringUtils) {
        this.treeFactory = treeFactory;
        this.parseTreeFactory = parseTreeFactory;
        this.collectionFactory = collectionFactory;
        this.stringUtils = stringUtils;
    }

    @Override
    public IParseTree normalize(IParseTree iTextSourceITree) {
        IParseTree normalizedTree = parseTreeFactory.newParseTree(iTextSourceITree.getName(), iTextSourceITree.getTextSource());
        addNormalizedChildren(iTextSourceITree, normalizedTree);
        return normalizedTree;
    }

    private void addNormalizedChildren(IParseTree simpleParseTree, IParseTree normalizedTree) {
        for(IParseTree child : simpleParseTree.getChildren()) {
            IParseTree normalizedChild = normalize(child);
            if (hasText(normalizedChild)) {
                normalizedTree.addChildren(getAddableChildren(simpleParseTree, normalizedChild));
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
