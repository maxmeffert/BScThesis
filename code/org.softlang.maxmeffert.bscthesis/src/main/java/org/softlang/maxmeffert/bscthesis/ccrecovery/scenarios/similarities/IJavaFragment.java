package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.similarities;

public interface IJavaFragment {
    boolean isClass();
    boolean isMethod();
    boolean isConstructor();
    String getIdentifier();
    String getMethodReturnType();
}
