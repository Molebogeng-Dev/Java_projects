package za.co.wethinkcode.toyrobot.maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyMazeTest {
    @Test
    void testEmptyMazeIsEmpty() {
        Maze maze = new EmptyMaze();
        assertEquals(0, maze.getObstacles().size());
    }

    @Test
    void testEmptyMazeHasNoObstacles() {
        Maze maze = new EmptyMaze();
    }
}
