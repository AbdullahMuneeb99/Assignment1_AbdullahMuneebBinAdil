public class GameOfLife extends Matrix{

    // Constructor: creates a game field with specified size
    public GameOfLife(int rows, int cols) {

        super(rows, cols); // Call Matrix constructor

    }

    // Adds the required shape at a given position (row, col)
    public void addShape(Shape shape, int startRow, int startCol) {

        // Gets the data (values in Matrix)
        int[][] shapeData = shape.getData();


        int shapeRows = shapeData.length;
        int shapeCols = shapeData[0].length;

        // Validating that the shape fits on the board
        if (startRow < 0 || startCol < 0 || startRow + shapeRows > this.rowCount() || startCol + shapeCols > this.columnCount()) {
            throw new IllegalArgumentException("Shape does not fit at the given position.");
        }

        // Copies data and sets it on the Matrix
        int[][] newData = getData(); // Copy current data
        for (int i = 0; i < shapeRows; i++) {
            for (int j = 0; j < shapeCols; j++) {
                newData[startRow + i][startCol + j] = shapeData[i][j];
            }
        }

        setData(newData); // Update board
    }

    // Computes the next generation based on Conway's Game of Life rules
    public void step() {

        int[][] current = getData();
        int rows = rowCount();
        int cols = columnCount();
        int[][] nextGen = new int[rows][cols];

        // Iterate over each cell in the current Matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // Calls in the helper method to count Alive neighbors in each iteration
                int aliveNeighbors = countAliveNeighbors(current, r, c);

                // Decides if next generation of the current cell is alive
                if (current[r][c] == 1) {
                    // Cell is alive
                    nextGen[r][c] = (aliveNeighbors == 2 || aliveNeighbors == 3) ? 1 : 0;
                } else {
                    // Cell is dead
                    nextGen[r][c] = (aliveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        setData(nextGen); // Update to next generation
    }

    // Helper method to count alive neighbors of a cell
    // iterates over the cells surrounding the current cell to check whether they are alive
    private int countAliveNeighbors(int[][] grid, int r, int c) {

        int aliveCount = 0;

        // Checking range for rows is r-1 to r+1 for every column
        for (int i = r - 1; i <= r + 1; i++) {
            // Checking range for columns is c-1 to c+1 for every column
            for (int j = c - 1; j <= c + 1; j++) {

                // If we come across the cell we are currently checking neighbors for, we skip the check
                if (i == r && j == c) continue;

                // As we are checking through the grid, we make sure not to go over the boundaries of the matrix
                if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
                    aliveCount += grid[i][j];
                }
            }
        }
        return aliveCount;
    }

    // Demo method with animation
    public static void main(String[] args) throws InterruptedException {
        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        // === Blinker Demo ===
        System.out.println("=== Blinker Demo ===");
        Shape blinker = new Shape("Blinker", new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        });

        GameOfLife game1 = new GameOfLife(10, 10);
        game1.addShape(blinker, 2, 2);

        for (int step = 0; step < 10; step++) {
            System.out.println(printer.print(game1));
            Thread.sleep(500);
            game1.step();
        }

        // === Glider Demo ===
        System.out.println("\n=== Glider Demo ===");
        Shape glider = new Shape("Glider", new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        });

        GameOfLife game2 = new GameOfLife(10, 10);
        game2.addShape(glider, 0, 0);

        for (int step = 0; step < 10; step++) {
            System.out.println(printer.print(game2));
            Thread.sleep(500);
            game2.step();
        }

        // === Beacon Demo ===
        System.out.println("\n=== Beacon Demo ===");
        Shape beacon = new Shape("Beacon", new int[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        });

        GameOfLife game3 = new GameOfLife(10, 10);
        game3.addShape(beacon, 2, 2);

        for (int step = 0; step < 10; step++) {
            System.out.println(printer.print(game3));
            Thread.sleep(500);
            game3.step();
        }
    }
}
