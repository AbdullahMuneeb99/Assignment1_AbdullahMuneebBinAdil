public class BoolMatrixPrinter extends MatrixOutlinePrinter{

    // Overriding the printRow method to handle 0s and 1s
    @Override
    protected String printRow(Matrix matrix, int rowIndex){

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
