public class GameOfLife extends Matrix{

    // Constructor: creates a game field with specified size
    public GameOfLife(int rows, int cols) {

        super(rows, cols); // Call Matrix constructor

    }

    // Adds the required shape at a given position (row, col)
    public void addShape(Shape shape, int startRow, int startCol) {

        // Gets the data (values in Matrix)
        int[][] shapeData = shape.getData();


        int shapeRows = shapeData.length;
        int shapeCols = shapeData[0].length;

        // Validating that the shape fits on the board
        if (startRow < 0 || startCol < 0 || startRow + shapeRows > this.rowCount() || startCol + shapeCols > this.columnCount()) {
            throw new IllegalArgumentException("Shape does not fit at the given position.");
        }

        // Copies data and sets it on the Matrix
        int[][] newData = getData(); // Copy current data
        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                newData[startRow + i][startCol + j] = shapeData[i][j];
            }
        }

        setData(newData); // Update board
    }

}
