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

    // Getter for name
    public String getName() {
        return name;
    }

    // Instances of Shape class
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
