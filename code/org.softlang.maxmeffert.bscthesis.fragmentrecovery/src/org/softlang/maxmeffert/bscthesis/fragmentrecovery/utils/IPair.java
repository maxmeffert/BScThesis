package org.softlang.maxmeffert.bscthesis.fragmentrecovery.utils;

public interface IPair<A extends Comparable<A>,B extends Comparable<B>> extends Comparable<IPair<A,B>>{
    A getFirst();
    B getSecond();
}
