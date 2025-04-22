public class Matrix {

    //Field to hold the 2D array of integers
    private int[][] data;

    //Getter method for the data field
    public int[][] getData(){
        return data;
    }

    //Setter method with input validation
    public void setData(int[][] data){

        // Checks if data is empty and throws exception
        if(data == null || data.length == 0 || data[0].length == 0){
            throw new IllegalArgumentException("Data must have at least 1 row and 1 column.");

        }
        this.data = data;
    }

    //Returns number of rows (outer array length)
    public int rowCount() {
        return data.length;
    }

    //Returns number of columns (inner array length)
    public int columnCount(){
        return data[0].length;
    }

    //Constructor that creates an empty matrix with given rows and columns as arguments
    public Matrix(int rows, int cols){

        // Checks if rows or columns are 0; if so, throws exception
        if(rows < 1 || cols < 1){
            throw new IllegalArgumentException("Matrix must have at least 1 row and 1 column");
        }

        this.data = new int[rows][cols];
    }

    //Constructor that uses an existing 2D array as the matrix
    public Matrix(int[][] data){

        // Checks if rows or columns are 0; if so, throws exception
        if (data == null || data.length == 0 || data[0].length == 0){
            throw new IllegalArgumentException("The array must have at least 1 row and 1 column");
        }
        this.data = data;
    }
}
