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
}
