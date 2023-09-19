package cz.educanet.matrices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void Should_Succeed_When_CountOfColumnsOfFirstMatrixEqualsCountOfRowsOfSecondMatrix() {
        double[][] matrix2x2V1 = {
                {1, 2},
                {3, 4}
        };

        double[][] matrix2x2V2 = {
                {4, 3},
                {2, 1}
        };

        double[][] finalMatrix = {
                {8, 5},
                {20, 13}
        };

        Matrix a =  (Matrix) new Matrix(matrix2x2V1).times((Matrix) new Matrix(matrix2x2V2));

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                Assertions.assertEquals(finalMatrix[i][j], a.get(i, j));
            }
        }

    }

    @Test
    void Should_Succeed_When_GivenMatrix() {
        double[][] matrix2x2 = {
                {1, 2},
                {3, 4}
        };

        Matrix a =  (Matrix) new Matrix(matrix2x2).times(3);
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                Assertions.assertEquals(a.get(i, j), matrix2x2[i][j] * 3);
            }
        }
    }

    @Test
    void Should_Succeed_When_TwoMatrixGiven() {
        double[][] matrix2x2V1 = {
                {1, 2},
                {3, 4}
        };

        double[][] matrix2x2V2 = {
                {4, 3},
                {2, 1}
        };

        Matrix matrix1 =  new Matrix(matrix2x2V1);
        Matrix matrix2 =  new Matrix(matrix2x2V2);
        Matrix a = (Matrix) matrix1.add(matrix2);
        for (int i = 0; i < matrix1.getRows(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                Assertions.assertEquals(a.get(i, j), matrix2x2V1[i][j] + matrix2x2V2[i][j]);
            }
        }

    }

    @Test
    void Should_Succeed_When_MatrixGiven() {
        double[][] matrix2x2 = {
                {1, 2},
                {3, 4}
        };
        Matrix a = (Matrix) new Matrix(matrix2x2).transpose();
        for (int i = 0; i < a.getColumns(); i++) {
            for (int j = 0; j < a.getRows(); j++) {
                Assertions.assertEquals(matrix2x2[j][i], a.get(i, j));
            }
        }
    }

    @Test
    void Should_Succeed_When_SquaredMatrixGiven() {
        double[][] matrix4x4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };


        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        double a = new Matrix(matrix3x3).determinant();
        double b = new Matrix(matrix4x4).determinant();
        Assertions.assertEquals(0, a);
        Assertions.assertEquals(0, b);
    }


    @Test
    void Should_Succeed_When_SquaredMatrixGivenAndCountCorrectDeterminant() {
        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        double[][] matrix4x3= {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {7, 8, 9}};

        Matrix a = new Matrix(matrix3x3);
        Matrix b = new Matrix(matrix4x3);

        Assertions.assertEquals(true, a.isSquare());
        Assertions.assertEquals(false, b.isSquare());
    }

    @Test
    void Should_Succeed_When_SquareMatrixGiven() {
        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        double[][] matrix4x4 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};

        Matrix a = new Matrix(matrix3x3);
        Matrix b = new Matrix(matrix4x4);

        Assertions.assertEquals(false, a.isDiagonal());
        Assertions.assertEquals(true, b.isDiagonal());
    }

    @Test
    void Should_Succeed_When_SquaredMatrixGivenAndGiveSumOfDiagonal() {
        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        double sum = 15;
        Matrix a = new Matrix(matrix3x3);

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                Assertions.assertEquals(sum , a.getTrace());
            }
        }
    }

    @Test
    void Should_Succeed_When_MatrixGivenV2() {
        double[][] matrix4x4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };


        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        Matrix a = new Matrix(matrix3x3);
        Matrix b = new Matrix(matrix4x4);
        Assertions.assertEquals(3, a.getRows());
        Assertions.assertEquals(4, b.getRows());
    }

    @Test
    void Should_Succeed_When_MatrixGivenV3() {
        double[][] matrix4x4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };


        double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        Matrix a = new Matrix(matrix3x3);
        Matrix b = new Matrix(matrix4x4);
        Assertions.assertEquals(3, a.getColumns());
        Assertions.assertEquals(4, b.getColumns());
    }

    @Test
    void Should_Succeed_When_MatrixGivenV4() {
        double[][] matrix2x2V2 = {
                {4, 3},
                {2, 1}
        };
        Matrix a = new Matrix(matrix2x2V2);
        for (int i = 0; i < matrix2x2V2.length; i++) {
            for (int j = 0; j < matrix2x2V2[i].length; j++) {
                Assertions.assertEquals(matrix2x2V2[i][j], a.get(i, j));
            }
        }
    }
}