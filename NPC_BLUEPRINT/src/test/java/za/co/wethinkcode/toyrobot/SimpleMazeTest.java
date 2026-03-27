package za.co.wethinkcode.toyrobot.maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMazeTest {
    @Test
    void testSimpleMazeHasOne() {
        Maze maze = new SimpleMaze();
        assertEquals(1, maze.getObstacles().size());
    }
    @Test
    void testSimpleMazeInCenter() {
        Maze maze = new SimpleMaze();
        assertEquals(1, maze.getObstacles().get(0).getBottomLeftX());
        assertEquals(1, maze.getObstacles().get(0).getBottomLeftY());
    }
    @Test
    void testSimpleMazeHasOneObstacle() {
        Maze maze = new SimpleMaze();
        assertEquals(1, maze.getObstacles().size());
    }
}
