import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for MatrixPrinter and its implementations.
 */
public class MatrixPrinterTest {


    @Test
    public void testOutlineMatrixPrinterSize() {
        Matrix matrix = new Matrix(3, 4); // Creates empty matrix of size 3X4
        MatrixPrinter printer = new MatrixOutlinePrinter();


        // expected result
        String expected =
                "+----+\n" + "|    |\n" + "|    |\n" + "|    |\n" + "+----+";

        assertEquals(expected, printer.print(matrix));
    }

    // Tests invalid matrix input (not all values are 0 or 1)
    @Test (expected = IllegalArgumentException.class)
    public void testBoolMatrixPrinterInvalidMatrix(){
        Matrix matrix = new Matrix(2, 3);

        int[][] data = {{0, 1, 2}, {1, 0, 1}}; // Invalid input because 2 is not allowed

        matrix.setData(data); // calls the setter method

        MatrixPrinter printer = new BoolMatrixPrinter();
        printer.print(matrix); // Should result in exception
    }

    // Tests valid input (all values are either 0 or 1)
    @Test
    public void testBoolMatrixPrinterValidMatrix(){

        // First matrix
        Matrix matrix1 = new Matrix(2, 4);
        matrix1.setData(new int[][] {
                {0, 1, 0, 1},
                {1, 0, 0, 1}
        });

        String expected1 =
                "+----+\n" + "| # #|\n" + "|#  #|\n" + "+----+";

        assertEquals(expected1, new BoolMatrixPrinter().print(matrix1));

        // Second matrix
        Matrix matrix2 = new Matrix(1, 3);
        matrix2.setData(new int[][] {
                {1, 0, 1}
        });

        String expected2 =
                "+---+\n" + "|# #|\n" + "+---+";

        assertEquals(expected2, new BoolMatrixPrinter().print(matrix2));

    }
}
