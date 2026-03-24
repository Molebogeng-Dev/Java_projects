package NPC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void isValidCommand() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.isValidCommand("forward"));
        assertTrue(robot.isValidCommand("FORWARD"));
        assertTrue(robot.isValidCommand("forward 10"));
        assertTrue(robot.isValidCommand("off"));
        assertTrue(robot.isValidCommand("off "));
        assertTrue(robot.isValidCommand("help"));
        assertTrue(robot.isValidCommand(" HELP  "));
        assertFalse(robot.isValidCommand("random"));
    }

    @Test
    void initialPosition() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals(0, robot.CENTRE.getX());
        assertEquals(0, robot.CENTRE.getY());
        assertEquals(Direction.valueOf("NORTH"), robot.getCurrentDirection());
    }

    @Test
    void dump() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals("[0,0] {NORTH} CrashTestDummy> Ready", robot.toString());
    }

    @Test
    void shutdown() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(Command.create("off")));
    }

    @Test
    void forward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(Command.create("forward 10")));
        assertEquals(0, robot.CENTRE.getX());
        assertEquals(10, robot.CENTRE.getY());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void forwardforward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(Command.create("forward 10")));
        assertTrue(robot.handleCommand(Command.create("forward 5")));
        assertEquals(0, robot.CENTRE.getX());
        assertEquals(15, robot.CENTRE.getY());
        assertEquals("Moved forward by 5 steps.", robot.getStatus());
    }

    @Test
    void tooFarForward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(Command.create("forward 1000")));
        assertEquals(0, robot.CENTRE.getX());
        assertEquals(0, robot.CENTRE.getY());
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }

    @Test
    void help() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(Command.create("help")));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'", robot.getStatus());
    }
}
