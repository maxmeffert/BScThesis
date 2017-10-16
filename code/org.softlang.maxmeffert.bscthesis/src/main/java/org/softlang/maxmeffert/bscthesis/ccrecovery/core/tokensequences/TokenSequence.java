package org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences;

import java.util.List;
import java.util.Optional;

public class TokenSequence implements ITokenSequence {

    private final List<String> tokens;

    public TokenSequence(List<String> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    @Override
    public int size() {
        return tokens.size();
    }

    @Override
    public String get(int index) {
        return tokens.get(index);
    }

    @Override
    public Optional<String> tryGet(int index) {
        if (isEmpty() || index < 0 || size() <= index) {
            return Optional.empty();
        }
        return Optional.of(get(index));
    }

    @Override
    public Optional<String> tryGet(Optional<Integer> index) {
        if (index.isPresent()) {
            return tryGet(index.get());
        }
        return Optional.empty();
    }

    @Override
    public int getFirstIndexOf(String token) {
        return tokens.indexOf(token);
    }

    @Override
    public Optional<Integer> tryGetFirstIndexOf(String token) {
        int index = getFirstIndexOf(token);
        if (index == -1) {
            return Optional.empty();
        }
        return Optional.of(index);
    }

    @Override
    public int getLastIndexOf(String token) {
        return tokens.lastIndexOf(token);
    }

    @Override
    public boolean matches(String... patterns) {
        for(int i=0; i < size()-patterns.length; i++) {
            boolean match = true;
            for (int j=0; j < patterns.length; j++) {
                match &= get(i+j).matches(patterns[j]);

//                System.out.println(get(i+j));
//                System.out.println(match);
                if (!match) {
                    return false;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] toArray() {
        return tokens.toArray(new String[]{});
    }
}
