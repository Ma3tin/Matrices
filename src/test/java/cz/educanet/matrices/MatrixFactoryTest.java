package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixFactoryTest {
    @Test
    public void should_Succeed_When_sizeNumbersPositive() {
        double[][] matrix1 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        double[][] matrix2 = {{3, 2, 1}, {3, 2, 1}, {3, 2, 1}};

        Matrix realMatrix1 = new Matrix(matrix1);
        Matrix realMatrix2 = new Matrix(matrix2);

        matrixAssertEquals(realMatrix1, (Matrix) MatrixFactory.instance.create(matrix1));
        matrixAssertEquals(realMatrix2, (Matrix) MatrixFactory.instance.create(matrix2));
    }


    private void matrixAssertEquals(Matrix expected, Matrix actual) {
        for (int i = 0; i < actual.getRows(); i++) {
            for (int j = 0; j < actual.getColumns(); j++) {
                Assertions.assertEquals(expected.get(i, j), actual.get(i, j));
            }
        }
    }


    @Test
    public void should_Succeed_When_Numbers() {
        double[] diagonal = {5, 6, 2};
        Matrix matrix = (Matrix) MatrixFactory.instance.createDiagonal(diagonal);
        double[][] matrix1 = {{5, 0, 0}, {0, 6, 0}, {0, 0, 2}};
        Matrix realMatrix = new Matrix(matrix1);

        matrixDiagonalAssertEquals(realMatrix, matrix);
    }

    @Test
    public void should_Succeed_When_Number_GreaterThanZero() {

        Matrix matrix = (Matrix) MatrixFactory.instance.createIdentity(3);
        double[][] matrix1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        Matrix realMatrix = new Matrix(matrix1);

        matrixDiagonalAssertEquals(realMatrix, matrix);
    }

    private void matrixDiagonalAssertEquals(Matrix expected, Matrix actual) {
        for (int i = 0; i < actual.getRows(); i++) {
            for (int j = 0; j < actual.getColumns(); j++) {
                Assertions.assertEquals(expected.get(i, j), actual.get(i, j));
                i++;
            }
        }
    }
}