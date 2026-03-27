package za.co.wethinkcode.toyrobot.maze;
import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;
import java.util.ArrayList;
import java.util.List;

public class SimpleMaze extends AbstractMaze{
    @Override
    public List<Obstacle> getObstacles(){
        ArrayList<Obstacle> obs = new ArrayList<>();
        obs.add(new SquareObstacle(1,1));
        return obs;
    }

    @Override
    public boolean blocksPath(Position a, Position b){
        return false;
    }
}