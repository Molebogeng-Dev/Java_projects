package za.co.wethinkcode.toyrobot.world;
import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.EmptyMaze;

import static org.junit.jupiter.api.Assertions.*;

public class TextWorldTest {
    @Test
    void testTextWorld() {
        IWorld world = new TextWorld(new EmptyMaze());
        assertEquals(IWorld.CENTRE, world.getPosition());
    }
    @Test
    void updatePosition() {
        IWorld world = new TextWorld(new EmptyMaze());
        assertEquals(IWorld.CENTRE, world.getPosition());
        world.updatePosition(100);
        Position expectedPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY() + 100);
        assertEquals(expectedPosition, world.getPosition());
    }
    @Test
    void reset() {
        IWorld world = new TextWorld(new EmptyMaze());
        world.updatePosition(100);
        world.updateDirection(true);
        assertEquals(IWorld.Direction.RIGHT, world.getCurrentDirection());
        world.reset();
        assertEquals(IWorld.Direction.UP, world.getCurrentDirection());
        assertEquals(IWorld.CENTRE, world.getPosition());
    }
}
