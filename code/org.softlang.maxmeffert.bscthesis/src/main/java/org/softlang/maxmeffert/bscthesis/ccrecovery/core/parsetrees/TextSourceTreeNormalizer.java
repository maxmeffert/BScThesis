package org.softlang.maxmeffert.bscthesis.ccrecovery.core.parsetrees;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITree;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.trees.ITreeFactory;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.strings.IStringUtils;

public class TextSourceTreeNormalizer implements ITextSourceTreeNormalizer {

    private final ITreeFactory treeFactory;
    private final ICollectionFactory collectionFactory;
    private final IStringUtils stringUtils;

    public TextSourceTreeNormalizer(ITreeFactory treeFactory, ICollectionFactory collectionFactory, IStringUtils stringUtils) {
        this.treeFactory = treeFactory;
        this.collectionFactory = collectionFactory;
        this.stringUtils = stringUtils;
    }

    @Override
    public ITree<ITextSource> normalize(ITree<ITextSource> iTextSourceITree) {
        ITree<ITextSource> normalizedTree = treeFactory.newTree(iTextSourceITree.getValue());
        addNormalizedChildren(iTextSourceITree, normalizedTree);
        return normalizedTree;
    }

    private void addNormalizedChildren(ITree<ITextSource> simpleParseTree, ITree<ITextSource> normalizedTree) {
        for(ITree<ITextSource> child : simpleParseTree.getChildren()) {
            ITree<ITextSource> normalizedChild = normalize(child);
            if (hasText(normalizedChild)) {
                normalizedTree.addChildren(getAddableChildren(simpleParseTree, normalizedChild));
            }
        }
    }

    private Iterable<ITree<ITextSource>> getAddableChildren(ITree<ITextSource> parent, ITree<ITextSource> child) {
        if (hasAddableGrandChildren(parent, child)) {
            return child.getChildren();
        }
        return collectionFactory.newSingleton(child);
    }

    private boolean hasAddableGrandChildren(ITree<ITextSource> parent, ITree<ITextSource> child) {
        return hasText(parent) && hasText(child) && haveSameText(parent, child);
    }

    private boolean hasText(ITree<ITextSource> tree) {
        return !stringUtils.isNullOrEmpty(tree.getValue().getText());
    }

    private boolean haveSameText(ITree<ITextSource> tree1, ITree<ITextSource> tree2) {
        String text1 = tree1.getValue().getText().trim();
        String text2 = tree2.getValue().getText().trim();
        return text1.equals(text2);
    }


}
