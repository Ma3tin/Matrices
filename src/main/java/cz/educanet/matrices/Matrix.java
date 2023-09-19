package cz.educanet.matrices;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (this.getRows() != matrix.getColumns()) throw new IllegalArgumentException();

        double[][] newMatrix = new double[matrix.getRows()][matrix.getColumns()];

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                for (int k = 0; k < matrix.getRows(); k++) {
                    newMatrix[i][j] += (get(i, k) * matrix.get(k, j));
                }
            }
        }


        return new Matrix(newMatrix);
    }


    @Override
    public IMatrix times(Number scalar) {
        double[][] newMatrix = new double[this.getRows()][this.getColumns()];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = this.get(i, j) * scalar.doubleValue();
            }
        }
        return new Matrix(newMatrix);
    }


    @Override
    public IMatrix add(IMatrix matrix) {
        if (matrix.getRows() != this.getRows() || matrix.getColumns() != this.getColumns())
            throw new IllegalArgumentException();

        double[][] newMatrix = new double[this.getRows()][this.getColumns()];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = this.get(i, j) + matrix.get(i, j);
            }
        }
        return new Matrix(newMatrix);
    }

    @Override
    public IMatrix transpose() {
        double[][] transposeMatrix = new double[this.getColumns()][this.getRows()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                transposeMatrix[j][i] = this.get(i, j);
            }
        }
        return new Matrix(transposeMatrix);
    }

    /**
     * TODO: Implement
     */
    @Override
    public double determinant() {
        if (this.rawArray.length == 1) return this.rawArray[0][0];
        double sum = 0;
        for (int i = 0; i < this.getColumns(); i++) {
            Matrix a = new Matrix(this.getSubMatrix(i));
            if (i % 2 == 1) sum += (get(0, i) * a.determinant()) * -1;
            else sum += (get(0, i) * a.determinant()) * 1;
        }

        return sum;
    }

    public double[][] getSubMatrix(int y) {
        double[][] smallerMatrix = new double[this.getRows()-1][this.getColumns()-1];
        for (int i = 0; i < this.getRows(); i++) {
            if (i == 0) continue;

            for (int j = 0; j < this.getColumns(); j++) {

                if (j == y) continue;
                if (i > 0 && j > y) smallerMatrix[i - 1][j - 1] = this.get(i,j);
                else if (i > 0) smallerMatrix[i - 1][j] = this.get(i,j);
                else if (j > y) smallerMatrix[i][j - 1] = this.get(i,j);
            }
        }


        return smallerMatrix;
    }

    @Override
    public boolean isSquare() {
        return (this.getRows() == this.getColumns());
    }

    @Override
    public boolean isDiagonal() {
        boolean isDiagonal = true;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (this.get(i, j) == 0) isDiagonal = false;
                i++;
            }
        }
        int countOfNonZeros = 0;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (this.get(i,j) != 0) countOfNonZeros++;
            }
        }
        if (countOfNonZeros == this.getRows()) isDiagonal = true;
        else isDiagonal = false;

        return isDiagonal;
    }

    @Override
    public Number getTrace() {
        double sumOfDiagonal = 0;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                sumOfDiagonal += this.get(i, j);
                i++;
            }
        }
        return sumOfDiagonal;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if(n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}
