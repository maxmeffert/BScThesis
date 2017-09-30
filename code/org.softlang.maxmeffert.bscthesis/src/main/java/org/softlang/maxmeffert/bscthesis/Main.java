package org.softlang.maxmeffert.bscthesis;

public class Main {

	public static void main(String[] args) {
		CCAnalyzer analyzer = CCAnalyzer.create();
		analyzer.findCorrespondences("class A {class A {}}","");
	}

}
