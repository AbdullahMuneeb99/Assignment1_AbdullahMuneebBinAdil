/**
 * A printer that displays a matrix containing only 0 and 1 values
 * as a visual grid, using '#' for 1 and ' ' (space) for 0.
 *
 * Extends MatrixOutlinePrinter to reuse the border drawing functionality.
 */
public class BoolMatrixPrinter extends MatrixOutlinePrinter {

    /**
     * Overrides the method to print a row with '#' for 1 and ' ' for 0.
     * Throws an IllegalArgumentException if the matrix contains values other than 0 or 1.
     *
     * @param matrix the Matrix to print from
     * @param rowIndex the index of the row to print
     * @return a String representing the contents of the row
     * @throws IllegalArgumentException if a value other than 0 or 1 is encountered
     */
    @Override
    protected String printRow (Matrix matrix, int rowIndex) {

        int cols = matrix.columnCount(); // gets the number of columns
        StringBuilder row = new StringBuilder();

        for(int col = 0; col < cols; col++) {
            int value = matrix.getData()[rowIndex][col];


            // Check if value is 0 or 1
            if (value != 0 && value != 1) {
                throw new IllegalArgumentException("Matrix must contain only 0s and 1s.");
            }

            //Appending space for 0s and 1s according to the sample in question
            if (value == 0) {
                row.append(" ");
            } else {
                row.append("#");
            }
        }
        return row.toString();
    }
}
