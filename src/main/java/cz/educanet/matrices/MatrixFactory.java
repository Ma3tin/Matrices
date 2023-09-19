package cz.educanet.matrices;

public class MatrixFactory implements IMatrixFactory {

    public static final IMatrixFactory instance = new MatrixFactory();

    private MatrixFactory() {
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix create(double[][] data) {
        return new Matrix(data);
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix createDiagonal(double[] diagonal) {
        double[][] matrix = new double[diagonal.length][diagonal.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = diagonal[i];
                i++;
            }
        }
        return new Matrix(matrix);
    }

    /**
     * TODO: Implement
     */
    @Override
    public IMatrix createIdentity(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 1;
                i++;
            }
        }
        return new Matrix(matrix);
    }

    @Override
    public IMatrix createZero(int size) {
        if (size < 0)
            throw new IllegalArgumentException();

        return new Matrix(new double[size][size]);
    }
}
