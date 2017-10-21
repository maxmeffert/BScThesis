package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragmentast;

public class JavaModifierFragmentAST extends JavaFragmentAST {

    private String name;
    private JavaAnnotationFragmentAST javaAnnotationFragment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAnnotation() {
        return javaAnnotationFragment != null;
    }

    public JavaAnnotationFragmentAST getJavaAnnotationFragment() {
        return javaAnnotationFragment;
    }

    public void setJavaAnnotationFragment(JavaAnnotationFragmentAST javaAnnotationFragment) {
        this.javaAnnotationFragment = javaAnnotationFragment;
    }
}
