package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

import java.util.LinkedList;
import java.util.List;

public class JavaClassFragment extends ModifiedJavaFragment {

    private String declaredPackage = "";
    private String fullName = "";
    private List<JavaFieldFragment> javaFieldFragments = new LinkedList<>();
    private List<JavaMethodFragment> javaMethodFragments = new LinkedList<>();

    public String getDeclaredPackage() {
        return declaredPackage;
    }

    public void setDeclaredPackage(String declaredPackage) {
        this.declaredPackage = declaredPackage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<JavaFieldFragment> getJavaFieldFragments() {
        return javaFieldFragments;
    }

    public void addJavaFieldFragment(JavaFieldFragment java8FieldFragment) {
        javaFieldFragments.add(java8FieldFragment);
        addChild(java8FieldFragment);
    }

    public List<JavaMethodFragment> getJavaMethodFragments() {
        return javaMethodFragments;
    }

    public void addJavaMethodFragment(JavaMethodFragment java8MethodFragment) {
        javaMethodFragments.add(java8MethodFragment);
        addChild(java8MethodFragment);
    }
}
