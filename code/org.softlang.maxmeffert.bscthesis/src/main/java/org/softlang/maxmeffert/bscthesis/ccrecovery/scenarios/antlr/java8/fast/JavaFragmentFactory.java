package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.antlr.java8.fast;

import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fast.IFragmentAST;

import java.util.LinkedList;
import java.util.List;

public class JavaFragmentFactory {
    public static JavaMethodFragment MethodFragment(String identifier) {
        return new JavaMethodFragment(identifier, new LinkedList<>());
    }

    public static JavaClassFragment ClassFragment(String identifier, List<IFragmentAST> methods) {
        return new JavaClassFragment(identifier, methods);
    }
}
