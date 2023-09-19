package cz.educanet;

import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;

public class Main {
    public static void main(String[] args) {
        double[][] matrix2x2V2 = {
                {4, 3},
                {2, 1}
        };
        Matrix matrix = new Matrix(matrix2x2V2);
        System.out.println(matrix.determinant());

        /*
        double[][] subMatrix = matrix.getSubMatrix( 1);
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println();
        }
         */

         /*

         `double[][] matrix4x4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
	};


double[][] matrix3x3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };`

double[][] matrix2x2V1 = {
                {1, 2},
                {3, 4}
        };

double[][] matrix2x2V2 = {
                {4, 3},
                {2, 1}
        };
          */
    }
}