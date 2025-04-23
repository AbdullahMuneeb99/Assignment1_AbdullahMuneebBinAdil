public class MatrixOutlinePrinter implements MatrixPrinter{
    // Implements the print method to generate the matrix outline
    @Override
    public String print(Matrix matrix){
        int rows = matrix.rowCount();
        int cols = matrix.columnCount();

        //this will be used to create the String Outline
        StringBuilder sb = new StringBuilder();

        // Top border: Calls private method generateTopOrBottomBorder
        sb.append(generateTopOrBottomBorder(cols)).append("\n");

        //Middle Rows: Calls protected method printRow
        for(int i = 0; i < rows; i++){
            sb.append("|");
            sb.append(printRow(matrix, i));
            sb.append("|").append("\n");
        }

        // Bottom border: Calls private method generateTopOrBottomBorder
        sb.append(generateTopOrBottomBorder(cols));

        return sb.toString();
    }

    // Creates the top.bottom border like +----+
    private String generateTopOrBottomBorder(int cols){

        // Starts building the Ouline with +
        StringBuilder border = new StringBuilder("+");

        // Creates the ---- part in the Ouline
        for(int i = 0; i < cols; i++){
            border.append("-");
        }
        // Ends the Upper/Lower border with +
        border.append("+");

        return border.toString();

    }

    // Protected method to generate a row - can be overridden later
    protected String printRow(Matrix matrix, int rowIndex){

        //
        int cols = matrix.columnCount();
        StringBuilder row = new StringBuilder();

        // prints the row contents: For now, prints empty spaces
        for(int j = 0; j < cols; j++){
            row.append(" "); // currently just a space per cell
        }
        return row.toString();
    }
}
