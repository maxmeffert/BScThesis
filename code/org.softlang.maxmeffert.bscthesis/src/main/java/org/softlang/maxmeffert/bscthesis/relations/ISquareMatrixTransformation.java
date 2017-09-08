package org.softlang.maxmeffert.bscthesis.relations;

public interface ISquareMatrixTransformation<T, R> {

    ISquareMatrix<R> map(ISquareMatrix<T> squareMatrix);

}
