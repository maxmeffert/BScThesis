package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.common.base.Strings;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.trees.ITree;
import org.softlang.maxmeffert.bscthesis.trees.ITreeFactory;

import java.util.Collections;

public class SimpleParseTreeNormalizer implements ISimpleParseTreeNormalizer {

    private final ITreeFactory treeFactory;

    public SimpleParseTreeNormalizer(ITreeFactory treeFactory) {
        this.treeFactory = treeFactory;
    }

    @Override
    public ISimpleParseTree normalize(ISimpleParseTree simpleParseTree) {
        return new SimpleParseTree(normalizeTextSourceTree(simpleParseTree));
    }

    private ITree<ITextSource> normalizeTextSourceTree(ITree<ITextSource> tree) {
        ITree<ITextSource> normalizedTree = treeFactory.newTree(tree.getValue());
        addNormalizedChildren(tree, normalizedTree);
        return normalizedTree;
    }

    private void addNormalizedChildren(ITree<ITextSource> simpleParseTree, ITree<ITextSource> normalizedTree) {
        for(ITree<ITextSource> child : simpleParseTree.getChildren()) {
            ITree<ITextSource> normalizedChild = normalizeTextSourceTree(child);
            if (hasText(normalizedChild)) {
                normalizedTree.addChildren(getAddableChildren(simpleParseTree, normalizedChild));
            }
        }
    }

    private Iterable<ITree<ITextSource>> getAddableChildren(ITree<ITextSource> parent, ITree<ITextSource> child) {
        if (hasAddableGrandChildren(parent, child)) {
            return child.getChildren();
        }
        return Collections.singleton(child);
    }

    private boolean hasAddableGrandChildren(ITree<ITextSource> parent, ITree<ITextSource> child) {
        return hasText(parent) && hasText(child) && haveSameText(parent, child);
    }

    private boolean hasText(ITree<ITextSource> tree) {
        return !Strings.isNullOrEmpty(tree.getValue().getText());
    }

    private boolean haveSameText(ITree<ITextSource> tree1, ITree<ITextSource> tree2) {
        String text1 = tree1.getValue().getText().trim();
        String text2 = tree2.getValue().getText().trim();
        return text1.equals(text2);
    }


}
