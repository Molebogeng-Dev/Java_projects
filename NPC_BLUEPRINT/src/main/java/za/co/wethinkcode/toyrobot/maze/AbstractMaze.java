package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

import java.util.List;

public class AbstractMaze implements Maze{
    @Override
    public List<Obstacle> getObstacles( ){
        return null;
    }

    @Override
    public boolean blocksPath(Position a, Position b){
        return false;
    }
}