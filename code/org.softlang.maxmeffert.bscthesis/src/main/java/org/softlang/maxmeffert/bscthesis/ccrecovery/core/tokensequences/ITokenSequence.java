package org.softlang.maxmeffert.bscthesis.ccrecovery.core.tokensequences;

import java.util.Optional;

public interface ITokenSequence {
    boolean isEmpty();
    int size();
    String get(int index);
    Optional<String> tryGet(int index);
    Optional<String> tryGet(Optional<Integer> index);
    int getFirstIndexOf(String token);
    Optional<Integer> tryGetFirstIndexOf(String token);
    int getLastIndexOf(String token);
    boolean matches(String... patterns);
    String[] toArray();
}
