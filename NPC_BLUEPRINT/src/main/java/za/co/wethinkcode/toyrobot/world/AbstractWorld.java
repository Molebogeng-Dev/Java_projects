package za.co.wethinkcode.toyrobot.world;
import za.co.wethinkcode.toyrobot.maze.Maze;
import za.co.wethinkcode.toyrobot.Position;
import java.util.List;

public abstract class AbstractWorld implements IWorld {
    protected Direction direction;

    protected Position position;
    public AbstractWorld(){
        position = new Position(0, 0);
        direction = Direction.UP;
    }

    @Override
    public UpdateResponse updatePosition(int steps){
        int y = position.getY();
        int x = position.getX();

        switch (direction) {
            case UP:
                y = y + steps;
                break;
            case RIGHT:
                x = x + steps;
                break;
            case DOWN:
                y = y + steps;
                break;
            case LEFT:
                x = x + steps;
                break;
            default:
                System.out.println("Invalid direction: " + direction);
                break;
        }

        Position newPosition = new Position(x,y);
        if (isNewPositionAllowed(newPosition)){
            this.position = newPosition;
            return UpdateResponse.SUCCESS;
        }

        return UpdateResponse.FAILED_OUTSIDE_WORLD;
    }

    @Override
    public void updateDirection(boolean right){
        if (right) {
            switch (this.direction) {
                case UP:
                    this.direction = Direction.RIGHT;
                    break;
                case RIGHT:
                    this.direction = Direction.DOWN;
                    break;
                case DOWN:
                    this.direction = Direction.LEFT;
                    break;
                case LEFT:
                    this.direction = Direction.UP;
                    break;
            }
        } else {
            switch (this.direction) {
                case UP:
                    this.direction = Direction.LEFT;
                    break;
                case LEFT:
                    this.direction = Direction.DOWN;
                    break;
                case DOWN:
                    this.direction = Direction.RIGHT;
                    break;
                case RIGHT:
                    this.direction = Direction.UP;
                    break;
            }
        }
    }

    @Override
    public Position getPosition(){
        return this.position;
    }

    @Override
    public Direction getCurrentDirection(){
        return null;
    }

    public abstract void setCurrentDirection(Direction direction);

    @Override
    public boolean isNewPositionAllowed(Position position){
        if ((position.getX() <= 200 && position.getX() >= -200) && (position.getY() <= 200 && position.getY() >= -200)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isAtEdge(){
        if((position.getX() >= 200) || (position.getX() <= -200) || (position.getY() <= -200) || (position.getY() >= 200)){
            return true;
        }
        return false;
    }

    @Override
    public void reset(){
    }

    public List<Obstacle> getObstacles(){
        return null;
    }

    @Override
    public void showObstacles(){

    }

    public abstract void update();
}