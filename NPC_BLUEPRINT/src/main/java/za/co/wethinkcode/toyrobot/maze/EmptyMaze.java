package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.Position;

import java.util.List;
import java.util.ArrayList;

public class EmptyMaze extends AbstractMaze {
    List<Obstacle> obs = new ArrayList<>();

    @Override
    public List<Obstacle> getObstacles(){
        return obs;
    }

    @Override
    public boolean blocksPath(Position a,Position b ){
        return false;
    }
}