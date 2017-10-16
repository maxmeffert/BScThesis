package org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences;

import com.google.inject.Inject;
import org.antlr.v4.runtime.TokenStream;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.texts.intervals.ITextInterval;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.utils.collections.ICollectionFactory;

import java.util.List;

public class TokenSequenceFactory implements ITokenSequenceFactory {

    private final ICollectionFactory collectionFactory;

    @Inject
    public TokenSequenceFactory(ICollectionFactory collectionFactory) {
        this.collectionFactory = collectionFactory;
    }

    private List<String> toStringList(TokenStream tokenStream, ITextInterval textInterval) {
        List<String> list = collectionFactory.newList();
        if (textInterval.getStartPosition() == textInterval.getEndPosition()) {
            list.add(tokenStream.get(textInterval.getStartPosition()).getText());
        }
        else if (0 <= textInterval.getStartPosition() && textInterval.getEndPosition() <= tokenStream.size()) {
            for(int i=textInterval.getStartPosition(); i<=textInterval.getEndPosition(); i++) {
                list.add(tokenStream.get(i).getText());
            }
        }
        return list;
    }

    @Override
    public ITokenSequence newTokenSequence(TokenStream tokenStream, ITextInterval textInterval) {
        return new TokenSequence(toStringList(tokenStream, textInterval));
    }
}
