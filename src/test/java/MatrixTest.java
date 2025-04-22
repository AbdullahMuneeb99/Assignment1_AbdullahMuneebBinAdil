import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    // Test Constructor if it throws exception for invalid rows
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorWithRows(){
        new Matrix(0, 4); //invalid rows
    }

    // Test Constructor if it throws exception for invalid columns
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorWithCols(){
        new Matrix(3, 0); //null input
    }

    // Test Constructor if it throws exception for invalid data
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorWithArray(){
        new Matrix(new int[0][0]); // 0X0 array
    }

    // Test row and column count for a valid Matrix
    @Test
    public void testRowAndColumnCount(){

        Matrix testMatrix = new Matrix(3, 4); // 3 rows and 4 columns matrix

        assertEquals(3, testMatrix.rowCount()); //Checks if the rows are 3
        assertEquals(4, testMatrix.columnCount()); //Checks if the columns are 4

    }
}
