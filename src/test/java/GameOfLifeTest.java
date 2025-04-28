import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the GameOfLife class.
 */
public class GameOfLifeTest {

    // Helper to build a BoolMatrixPrinter and return the board as a string
    private String getPrintedBoard(GameOfLife game) {
        BoolMatrixPrinter printer = new BoolMatrixPrinter();
        return printer.print(game);
    }

    // Test that the Blinker shape correctly changes after one step
    @Test
    public void testBlinkerAfterOneStep() {
        // Create a 5x5 Game of Life grid
        GameOfLife game = new GameOfLife(5, 5);

        // Define a vertical Blinker shape
        int[][] blinkerData = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };

        Shape blinker = new Shape("Blinker", blinkerData);
        // Place the blinker at coordinate (1,1)
        game.addShape(blinker, 1, 1);

        // Evolve the game by one step (generation)
        game.step();

        // expected output
        String expected =
                "+-----+\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "| ### |\n" +
                        "|     |\n" +
                        "|     |\n" +
                        "+-----+";

        assertEquals(expected, getPrintedBoard(game));
    }

    // Test that the Glider shape moves and evolves correctly after 10 steps
    @Test
    public void testGliderAfterTenSteps() {

        // Create a 10x10 Game of Life grid
        GameOfLife game = new GameOfLife(10, 10);

        // Define the initial Glider shape
        int[][] gliderData = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        };
        Shape glider = new Shape("Glider", gliderData);

        // Place the glider on the grid (1,1)
        game.addShape(glider, 1, 1);

        // Run 10 steps of the Game of Life
        for (int i = 0; i < 10; i++) {
            game.step();
        }

        // Expected string
        String expected =
                "+----------+\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|     #    |\n" +
                        "|   # #    |\n" +
                        "|    ##    |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "+----------+";

        assertEquals(expected, getPrintedBoard(game));
    }
}
