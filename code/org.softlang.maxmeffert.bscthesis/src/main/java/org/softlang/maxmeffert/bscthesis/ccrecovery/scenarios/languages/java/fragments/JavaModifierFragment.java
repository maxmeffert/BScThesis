package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.languages.java.fragments;

public class JavaModifierFragment extends JavaFragment {

    private String name;
    private JavaAnnotationFragment javaAnnotationFragment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAnnotation() {
        return javaAnnotationFragment != null;
    }

    public JavaAnnotationFragment getJavaAnnotationFragment() {
        return javaAnnotationFragment;
    }

    public void setJavaAnnotationFragment(JavaAnnotationFragment javaAnnotationFragment) {
        this.javaAnnotationFragment = javaAnnotationFragment;
    }
}
