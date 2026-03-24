package NPC;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getShutdownName() {
        Command test = new ShutdownCommand();
        assertEquals("off", test.getName());
    }

    @Test
    void executeShutdown() {
        Robot robot = new Robot("CrashTestDummy");
        Command shutdown = Command.create("shutdown");
        assertTrue(shutdown.execute(robot));
        assertEquals("Shutting down...", robot.getStatus());
    }

    @Test
    void getForwardName() {
        ForwardCommand test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());
    }

    @Test
    void executeForward() {
        Robot robot = new Robot("CrashTestDummy");
        Command forward100 = Command.create("forward 10");
        assertTrue(forward100.execute(robot));
        Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void getHelpName() {
        Command test = new HelpCommand();
        assertEquals("help", test.getName());
    }

    @Test
    void executeHelp() {
        Robot robot = new Robot("CrashTestDummy");
        Command help = Command.create("help");
        assertTrue(help.execute(robot));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'", robot.getStatus());
    }

    @Test
    void createCommand() {
        Command forward = Command.create("forward 10");
        assertEquals("forward", forward.getName());
        assertEquals("10", forward.getArgument());

        Command shutdown = Command.create("shutdown");
        assertEquals("off", shutdown.getName());

        Command help = Command.create("help");
        assertEquals("help", help.getName());
    }

    @Test
    void createInvalidCommand() {
        try {
            Command forward = Command.create("say hello");
            fail("Should have thrown an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Unsupported command: say hello", e.getMessage());
        }
    }

    static class RobotTest {

        @Test
        void initialPosition() {
            Robot robot = new Robot("CrashTestDummy");
            assertEquals(Robot.CENTRE, robot.getPosition());
            assertEquals(Direction.NORTH, robot.getCurrentDirection());
        }

        @Test
        void dump() {
            Robot robot = new Robot("CrashTestDummy");
            assertEquals("[0,0] CrashTestDummy> Ready", robot.toString());
        }

        @Test
        void shutdown() {
            Robot robot = new Robot("CrashTestDummy");
            Command command = new ShutdownCommand();
            assertTrue(robot.handleCommand(command));
        }

        @Test
        void forward() {
            Robot robot = new Robot("CrashTestDummy");
            Command command = new ForwardCommand("10");
            assertTrue(robot.handleCommand(command));
            Position expectedPosition = new Position(Robot.CENTRE.getX(), Robot.CENTRE.getY() + 10);
            assertEquals(expectedPosition, robot.getPosition());
            assertEquals("Moved forward by 10 steps.", robot.getStatus());
        }

        @Test
        void forwardforward() {
            Robot robot = new Robot("CrashTestDummy");
            assertTrue(robot.handleCommand(new ForwardCommand("10")));
            assertTrue(robot.handleCommand(new ForwardCommand("5")));
            assertEquals("Moved forward by 5 steps.", robot.getStatus());
        }

        @Test
        void tooFarForward() {
            Robot robot = new Robot("CrashTestDummy");
            assertTrue(robot.handleCommand(new ForwardCommand("1000")));
            assertEquals(Robot.CENTRE, robot.getPosition());
            assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
        }

        @Test
        void help() {
            Robot robot = new Robot("CrashTestDummy");
            Command command = new HelpCommand();
            assertTrue(robot.handleCommand(command));
            assertEquals("I can understand these commands:\n" +
                    "OFF  - Shut down robot\n" +
                    "HELP - provide information about commands\n" +
                    "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'", robot.getStatus());
        }
    }
}
