package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

public interface ISquareMatrixTransformation<T, R> {

    ISquareMatrix<R> map(ISquareMatrix<T> squareMatrix);

}
