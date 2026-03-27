package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaze extends AbstractMaze {
    private List<Obstacle> obs = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> getBotPath(){
        getObstacles();
        ArrayList<ArrayList<Integer>> path = new ArrayList<>();

        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 50; x++) {
                ArrayList<Integer> xy = new ArrayList<>();
                int windowX = -100 + (x * 4);
                int windowY = 200 - (y * 4);
                for (int i = 0; i < this.obs.size(); i++) {
                    int x1 = this.obs.get(i).getBottomLeftX();
                    int y1 = this.obs.get(i).getBottomLeftX();
                    if (windowX != x1 && windowY != y1) {
                        xy.add(windowX);
                        xy.add(windowY);
                        path.add(xy);
                    }
                }
            }
        }
        return path;
    }

    public List<Obstacle> getObsPath(){
        List<Obstacle> obstacles = new ArrayList<>();
        for(ArrayList<Integer> cor : getBotPath()){
            int xCor = cor.get(0);
            int yCor = cor.get(1);
            obs.add(new SquareObstacle(xCor,yCor));
        }
        return obstacles;
    }

    @Override
    public List<Obstacle> getObstacles(){
        Random rnd =new Random();
        int numOfObs = rnd.nextInt(25);

        for (int i = 0; i < numOfObs; i++){
            int xCor = rnd.nextInt(100+200) - 200;
            int yCor = rnd.nextInt(100+100) - 200;
            this.obs.add(new SquareObstacle(xCor, yCor));
        }
        return this.obs;
    }
}