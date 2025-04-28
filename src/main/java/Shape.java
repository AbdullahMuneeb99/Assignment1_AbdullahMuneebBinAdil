/**
 * Represents a named shape made of a boolean (0/1) matrix.
 * Extends the Matrix class by adding a name field for identification.
 */
public class Shape extends Matrix{

    private String name;

    /**
     * Constructs a Shape with a given name and a 2D array of 0s and 1s.
     * Validates that the name is not null/empty and the matrix contains only 0s and 1s.
     *
     * @param name the name of the shape
     * @param data a 2D integer array representing the shape (must contain only 0s and 1s)
     * @throws IllegalArgumentException if the name is invalid or the matrix contains values other than 0 or 1
     */
    public Shape (String name, int[][] data) {
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

    /**
     * Gets the name of the shape.
     *
     * @return the name of the shape
     */
    public String getName() {
        return name;
    }

    /**
     * Main method to showcase the creation and printing of two Shape instances: Beehive and Boat.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Beehive shape (still life)
        int[][] beehiveData = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };
        Shape beehive = new Shape("Beehive", beehiveData);

        // Boat shape (still life)
        int[][] boatData = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        Shape boat = new Shape("Boat", boatData);

        // Use BoolMatrixPrinter to print both shapes
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        System.out.println("Shape: " + beehive.getName());
        System.out.println(printer.print(beehive));

        System.out.println("\nShape: " + boat.getName());
        System.out.println(printer.print(boat));
    }
}
