package org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentkbs;

import com.google.inject.Inject;
import org.softlang.maxmeffert.bscthesis.ccrecovery.core.fragmentasts.IFragmentAST;

public class FragmentKBFactory implements IFragmentKBFactory {

    private final IFragmentKBBuilderFactory fragmentKBBuilderFactory;

    @Inject
    public FragmentKBFactory(IFragmentKBBuilderFactory fragmentKBBuilderFactory) {
        this.fragmentKBBuilderFactory = fragmentKBBuilderFactory;
    }

    private IFragmentKBBuilder newFragmentKB(IFragmentKBBuilder fragmentKBBuilder, IFragmentAST fragment) {
        for (IFragmentAST child : fragment.getChildren()) {
//            System.out.println(child);
            fragmentKBBuilder = newFragmentKB(fragmentKBBuilder.fragmentOf(child, fragment), child);
        }
        return fragmentKBBuilder;
    }

    @Override
    public IFragmentKB newFragmentKB(IFragmentAST fragment) {
        return newFragmentKB(fragmentKBBuilderFactory.newFragmentKBBuilder(), fragment).build();
    }

}
