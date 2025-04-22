import org.junit.Test;

public class MatrixTest {

    // Test Constructor if it throws exception for invalid rows
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorWithRows(){
        new Matrix(0, 4);
    }

    // Test Constructor if it throws exception for invalid columns
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorWithCols(){
        new Matrix(3, 0);
    }


}
