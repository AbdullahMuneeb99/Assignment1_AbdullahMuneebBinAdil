import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test (expected = IllegalArgumentException.class)
    public void testBoolMatrixPrinterInvalidMatrix(){
        Matrix matrix = new Matrix(2, 3);

        int[][] data = {{0, 1, 2}, {1, 0, 1}}; // Invalid input because 2 is not allowed

        matrix.setData(data); // calls the setter method

        MatrixPrinter printer = new BoolMatrixPrinter();
        printer.print(matrix); // Should result in exception
    }
}
