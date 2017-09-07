package org.softlang.maxmeffert.bscthesis.fragmentrecovery.relations;

public interface ISquareMatrixTransformation<T, R> {

    ISquareMatrix<R> map(ISquareMatrix<T> squareMatrix);

}
