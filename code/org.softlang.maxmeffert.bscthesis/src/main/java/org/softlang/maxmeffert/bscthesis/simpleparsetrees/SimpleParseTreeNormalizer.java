package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

import com.google.common.base.Strings;
import org.softlang.maxmeffert.bscthesis.texts.sources.ITextSource;
import org.softlang.maxmeffert.bscthesis.graphs.oldtrees.ITree;
import org.softlang.maxmeffert.bscthesis.graphs.oldtrees.Tree;

import java.util.Collection;
import java.util.Collections;

public class SimpleParseTreeNormalizer implements ISimpleParseTreeNormalizer {

    @Override
    public ITree<ITextSource> normalize(ITree<ITextSource> tree) {
        ITree<ITextSource> normalizedTree = new Tree<>();
        normalizedTree.setValue(tree.getValue());

        addNormalizedChildren(tree, normalizedTree);

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

    private Collection<ITree<ITextSource>> getAddableChildren(ITree<ITextSource> parent, ITree<ITextSource> child) {
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
