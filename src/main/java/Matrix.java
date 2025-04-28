/**
 * Represents a simple 2D integer matrix with basic operations.
 */
public class Matrix {

    //Field to hold the 2D array of integers
    private int[][] data;

    /**
     * Returns the matrix data.
     */
    public int[][] getData() {
        return data;
    }

    /**
     * Sets the matrix data.
     */
    public void setData(int[][] data) {

        // Checks if data is empty and throws exception
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Data must have at least 1 row and 1 column.");

        }
        this.data = data;
    }

    /**
     * Returns the number of rows in the matrix.
     */
    public int rowCount() {
        return data.length;
    }

    /**
     * Returns the number of columns in the matrix.
     */
    public int columnCount() {
        return data[0].length;
    }

    /**
     * Constructs a matrix with the specified number of rows and columns.
     *
     * @throws IllegalArgumentException if rows or columns are less than 1
     */
    public Matrix (int rows, int cols) {

        // Checks if rows or columns are 0; if so, throws exception
        if (rows < 1 || cols < 1){
            throw new IllegalArgumentException("Matrix must have at least 1 row and 1 column");
        }

        this.data = new int[rows][cols];
    }

    /**
     * Constructs a matrix from an existing 2D array.
     *
     * @throws IllegalArgumentException if array is null or has invalid dimensions
     */
    public Matrix (int[][] data) {

        // Checks if rows or columns are 0; if so, throws exception
        if (data == null || data.length == 0 || data[0].length == 0){
            throw new IllegalArgumentException("The array must have at least 1 row and 1 column");
        }
        this.data = data;
    }
}
