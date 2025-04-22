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
}
