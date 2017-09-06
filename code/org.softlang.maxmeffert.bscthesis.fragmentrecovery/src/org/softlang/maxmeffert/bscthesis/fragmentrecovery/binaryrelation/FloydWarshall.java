package org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation;

import org.softlang.maxmeffert.bscthesis.fragmentrecovery.graph.IAdjacencyMatrix;

public class FloydWarshall implements ISquareMatrixTransformation<Boolean, Boolean> {


    private ISquareMatrix<Boolean> reflexiveClosureMatrix(ISquareMatrix<Boolean> squareMatrix) {
        for (int i=0; i<squareMatrix.size(); i++) {
            squareMatrix.set(i,i, true);
        }
        return squareMatrix;
    }

    private IAdjacencyMatrix reflexiveClosureMatrix(IAdjacencyMatrix squareMatrix) {
        for (int i=0; i<squareMatrix.size(); i++) {
            squareMatrix = squareMatrix.set(i,i, true);
        }
        return squareMatrix;
    }

    // implements Floyd-Warshall http://www-i2.informatik.rwth-aachen.de/i2/fileadmin/user_upload/documents/DASAL10/lec18_handout.pdf
    private ISquareMatrix<Boolean> reflexiveTransitiveClosureMatrix(ISquareMatrix<Boolean> squareMatrix) {
        ISquareMatrix<Boolean> result = reflexiveClosureMatrix(squareMatrix);
        for (int k=0; k<result.size(); k++) {
            for (int i=0; i<result.size(); i++) {
                for (int j=0; j<result.size(); j++) {
                    result.set(i,j, result.get(i,j) || (result.get(i,k) && result.get(k,j)));
                }
            }
        }
        return result;
    }

    private IAdjacencyMatrix reflexiveTransitiveClosureMatrix(IAdjacencyMatrix squareMatrix) {
        IAdjacencyMatrix result = reflexiveClosureMatrix(squareMatrix);
        for (int k=0; k<result.size(); k++) {
            for (int i=0; i<result.size(); i++) {
                for (int j=0; j<result.size(); j++) {
                    result = result.set(i,j, result.get(i,j) || (result.get(i,k) && result.get(k,j)));
                }
            }
        }
        return result;
    }

    @Override
    public ISquareMatrix<Boolean> map(ISquareMatrix<Boolean> squareMatrix) {
        return reflexiveTransitiveClosureMatrix(squareMatrix);
    }

    public IAdjacencyMatrix map(IAdjacencyMatrix squareMatrix) {
        return reflexiveTransitiveClosureMatrix(squareMatrix);
    }

}
