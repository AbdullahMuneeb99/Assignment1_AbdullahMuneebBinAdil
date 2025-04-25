public class Shape extends Matrix{

    private String name;

    // Constructor with name and data array (data should be in binary)
    public Shape(String name, int[][] data) {
        super(data); // Call Matrix constructor to set data

        // Validating name of shape
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Shape must have a name.");
        }

        // Checking that data only contains 0s and 1s
        for (int[] row : data) {
            for (int value : row) {
                if (value != 0 && value != 1) {
                    throw new IllegalArgumentException("Shape matrix must contain only 0s and 1s.");
                }
            }
        }

        this.name = name;
    }
}
