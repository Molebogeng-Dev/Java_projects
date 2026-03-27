package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.Maze;

import java.util.List;

import static za.co.wethinkcode.toyrobot.world.IWorld.UpdateResponse.*;

public class TextWorld extends AbstractWorld{
    Maze maze;
    private final Position TOP_LEFT = new Position(-200, 200);
    private final Position BOTTOM_RIGHT = new Position(200, -200);
    public static final Position CENTRE = new Position(0, 0);
    private Position position;
    private IWorld.Direction currentDirection;
    private final List<Obstacle> obstacles;
    private IWorld.Direction edgeDirection;

    public TextWorld(Maze maze) {
        this.maze = maze;
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
        this.obstacles = maze.getObstacles();
        this.edgeDirection = Direction.UP;
    }

    @Override
    public UpdateResponse updatePosition(int steps){
        int newY = position.getY();
        int newX = position.getX();

        switch (currentDirection) {
            case UP:
                newY += steps;
                break;
            case RIGHT:
                newX += steps;
                break;
            case DOWN:
                newY -= steps;
                break;
            case LEFT:
                newX -= steps;
                break;
        }

        Position newPosition = new Position(newX, newY);
        if (isNewPositionAllowed(newPosition)) {
            this.position = newPosition;
            return UpdateResponse.SUCCESS;
        }

        return UpdateResponse.FAILED_OUTSIDE_WORLD;
    }

    @Override
    public void updateDirection(boolean right){
        if (right) {
            switch (currentDirection) {
                case UP:
                    setCurrentDirection(Direction.RIGHT);
                    break;
                case DOWN:
                    setCurrentDirection(Direction.LEFT);
                    break;
                case RIGHT:
                    setCurrentDirection(Direction.DOWN);
                    break;
                case LEFT:
                    setCurrentDirection(Direction.UP);
                    break;
            }
        } else {
            switch (currentDirection) {
                case UP:
                    setCurrentDirection(Direction.LEFT);
                    break;
                case DOWN:
                    setCurrentDirection(Direction.RIGHT);
                    break;
                case RIGHT:
                    setCurrentDirection(Direction.UP);
                    break;
                case LEFT:
                    setCurrentDirection(Direction.DOWN);
                    break;
            }
        }
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    @Override
    public void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    @Override
    public boolean isNewPositionAllowed(Position position){
        return position.isIn(TOP_LEFT,BOTTOM_RIGHT);
    }

    @Override
    public boolean isAtEdge(){
        switch (edgeDirection) {
            case UP:
                return position.getY() == TOP_LEFT.getY();
            case DOWN:
                return position.getY() == BOTTOM_RIGHT.getY();
            case RIGHT:
                return position.getX() == BOTTOM_RIGHT.getX();
            case LEFT:
                return position.getX() == TOP_LEFT.getX();
            default:
                return false;
        }
    }

    @Override
    public void reset() {
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
    }

    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

    @Override
    public void showObstacles() {
    }

    @Override
    public void update() {

    }

}