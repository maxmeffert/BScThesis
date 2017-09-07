package org.softlang.maxmeffert.bscthesis.fragmentrecovery.mereologies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.ISquareMatrix;
import org.softlang.maxmeffert.bscthesis.fragmentrecovery.binaryrelation.SquareMatrix;

import static org.junit.jupiter.api.Assertions.*;

public class SquareMatrixTests {

    private static final int EXPECTED_SIZE = 5;
    private static final Integer INITIAL_VALUE = 42;
    private static final Integer SOME_VALUE = 666;

    protected SquareMatrix<Integer> cut;

    @BeforeEach
    void setUp() {
        cut = new SquareMatrix<>(EXPECTED_SIZE);
    }

    protected <T> void assertAllPositionsAreEqual(SquareMatrix<T> squareMatrix, T expectedValue) {
        for (int i=0; i<squareMatrix.size(); i++) {
            for(int j=0; j<squareMatrix.size(); j++) {
                assertEquals(expectedValue, squareMatrix.get(i,j));
            }
        }
    }

    protected <T> void assertSquareMatrixEquals(ISquareMatrix<T> expectedSquareMatrix, ISquareMatrix squareMatrix) {
        assertEquals(expectedSquareMatrix.size(), squareMatrix.size());
        for (int i=0; i<expectedSquareMatrix.size(); i++) {
            for(int j=0; j<expectedSquareMatrix.size(); j++) {
                assertEquals(expectedSquareMatrix.get(i,j), squareMatrix.get(i,j));
            }
        }
    }

    protected <T> void assertAllPositionsAreNull(SquareMatrix<T> squareMatrix) {
        for (int i=0; i<squareMatrix.size(); i++) {
            for(int j=0; j<squareMatrix.size(); j++) {
                assertNull(squareMatrix.get(i,j));
            }
        }
    }



    public static class ConstructorWithInitialValue extends SquareMatrixTests {

        @Override
        @BeforeEach
        void setUp() {
            cut = new SquareMatrix<>(EXPECTED_SIZE, INITIAL_VALUE);
        }

        @Test
        void initializesAllPositionsWithInitialValue() {
            assertAllPositionsAreEqual(cut, INITIAL_VALUE);
        }

    }

    public static class Size extends SquareMatrixTests {

        @Test
        void returnsExpectedSize() {
            assertEquals(EXPECTED_SIZE, cut.size());
        }

    }

    public static class SetAll extends SquareMatrixTests {

        @Test
        void setsAllPositions() {
            cut.setAll(SOME_VALUE);
            assertAllPositionsAreEqual(cut, SOME_VALUE);
        }

    }

    public static class Get extends SquareMatrixTests {

        @Test
        void returnsNullForAllPositions() {
            assertAllPositionsAreNull(cut);
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForRowEqualsSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.get(cut.size(), 0);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForColEqualsSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.get(0, cut.size());
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForRowGreaterThanSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.get(cut.size()+1, 0);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForColGreaterThanSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.get(0, cut.size()+1);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForRowLessThanZero() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.get(-1, 0);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForColLessThanZero() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.get(0, -1);
            });
        }

    }

    public static class Set extends SquareMatrixTests {

        @Test
        void setsPositionWithValue() {
            assertNotEquals(SOME_VALUE, cut.get(0,0));
            cut.set(0,0, SOME_VALUE);
            assertEquals(SOME_VALUE, cut.get(0,0));
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForRowEqualsSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.set(cut.size(), 0, SOME_VALUE);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForColEqualsSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.set(0, cut.size(), SOME_VALUE);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForRowGreaterThanSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.set(cut.size()+1, 0, SOME_VALUE);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForColGreaterThanSize() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.set(0, cut.size()+1, SOME_VALUE);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForRowLessThanZero() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.set(-1, 0, SOME_VALUE);
            });
        }

        @Test
        void throwsArrayIndexOutOfBoundsExceptionForColLessThanZero() {
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                cut.set(0, -1, SOME_VALUE);
            });
        }
    }

    public static class Copy extends SquareMatrixTests {

        @Test
        void createsNewInstance() {
            assertNotSame(cut, cut.copy());
        }

        @Test
        void createsNewInstanceOfSameClass() {
            assertSame(cut.getClass(), cut.copy().getClass());
        }

        @Test
        void createsEqualInstance() {
            assertSquareMatrixEquals(cut, cut.copy());
        }

    }



}