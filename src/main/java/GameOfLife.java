/**
 * Represents the Game of Life simulation field.
 * Extends the Matrix class to implement Conway's Game of Life logic.
 */
public class GameOfLife extends Matrix {

    /**
     * Constructs a GameOfLife board with a specified number of rows and columns.
     *
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     */
    public GameOfLife (int rows, int cols) {

        super(rows, cols); // Call Matrix constructor

    }

    /**
     * Adds a Shape to the board at a specified starting row and column.
     * Throws an exception if the shape cannot fit at the given position.
     *
     * @param shape the Shape to add
     * @param startRow the starting row position
     * @param startCol the starting column position
     * @throws IllegalArgumentException if the shape does not fit within the bounds
     */
    public void addShape (Shape shape, int startRow, int startCol) {

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

    /**
     * Advances the board by one generation according to Conway's Game of Life rules.
     * Updates the board state based on neighbor counts.
     */
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

        setData(nextGen);
    }

    /**
     * Counts the number of alive (1) neighboring cells around a given cell.
     * Skips counting the cell itself and ensures bounds checking.
     *
     * @param grid the current board grid
     * @param r the row index of the cell
     * @param c the column index of the cell
     * @return the number of alive neighbors
     */
    private int countAliveNeighbors (int[][] grid, int r, int c) {

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

    /**
     * Main method to demonstrate Game of Life using Blinker, Glider, and Beacon patterns.
     * Animates 10 generations of each pattern with a delay between each step.
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if the thread sleep is interrupted
     */
    public static void main (String[] args) throws InterruptedException {
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
