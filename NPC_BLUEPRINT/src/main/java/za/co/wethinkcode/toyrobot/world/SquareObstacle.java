package za.co.wethinkcode.toyrobot.world;
import za.co.wethinkcode.toyrobot.Position;

import java.util.ArrayList;

public class SquareObstacle implements Obstacle{
    private int x;
    private int y;
    private Position bottomLeftCorner;
    private Position bottomRightCorner;
    private Position topRightCorner;
    private Position topLeftCorner;

    private final ArrayList<ArrayList<String>> obstacles = new ArrayList<>();

    public Position getBottomLeftCorner(){
        return bottomLeftCorner;
    }
    public Position getBottomRightCorner(){
        return bottomRightCorner;
    }
    public Position getTopRightCorner(){
        return topRightCorner;
    }
    public Position getTopLeftCorner(){
        return topLeftCorner;
    }

    private ArrayList<Position> getRoutes(Position a, Position b){
        int xPosA = a.getX();
        int yPosA = a.getY();
        int xPosB = b.getX();
        int yPosB = b.getY();

        ArrayList<Position> routes = new ArrayList<>();

        if(xPosA == xPosB && yPosA < yPosB){
            for(int i = 0; i <= yPosB; i++){
                Position XY = new Position(xPosA, yPosA + i);
                routes.add(XY);
            }
        }
        else if(xPosA == xPosB && yPosA > yPosB){
            for(int i = 0; i >= yPosB; i--){
                Position XY = new Position(xPosA, yPosA + i);
                routes.add(XY);
            }
        } else if(yPosA == yPosB && xPosA < xPosB){
            for(int i = 0; i <= xPosB; i++){
                Position XY = new Position(xPosA + i, yPosA);
                routes.add(XY);
            }
        }else if(yPosA == yPosB && xPosA > xPosB){
            for(int i = 0; i >= xPosB; i--){
                Position XY = new Position(xPosA + i, yPosA);
                routes.add(XY);
            }
        }

        return routes;
    }

    @Override
    public int getBottomLeftX(){
        return this.x;
    }

    @Override
    public int getBottomLeftY(){
        return this.y;
    }

    @Override
    public int getSize(){
        return 5;
    }

    private void generateObs(){
        ArrayList<String> obs = new ArrayList<>();
        this.bottomLeftCorner = new Position(getBottomLeftX(), getBottomLeftY());
        this.bottomRightCorner = new Position(getBottomLeftX() + (getSize()-2), getBottomLeftY());
        this.topRightCorner = new Position(getBottomLeftX() + (getSize()-2), getBottomLeftY() + (getSize()-2));
        this.topLeftCorner = new Position(getBottomLeftX(), getBottomLeftY() + (getSize()-2));

        for(Position position: getRoutes(this.bottomLeftCorner, this.topLeftCorner)){
            String positionXY = String.format("(%d,%d)",position.getX(),position.getY());
            obs.add(positionXY);
        }
        for(Position position: getRoutes(this.bottomLeftCorner,this.bottomRightCorner)){
            String positionXY = String.format("(%d,%d)",position.getX(),position.getY());
            obs.add(positionXY);
        }
        for(Position position: getRoutes(this.topLeftCorner,this.topRightCorner)){
            String xyPosition = String.format("(%d,%d)",position.getX(),position.getY());
            obs.add(xyPosition);
        }
        for(Position position: getRoutes(this.bottomRightCorner,this.topRightCorner)){
            String xyPosition = String.format("(%d,%d)",position.getX(),position.getY());
            obs.add(xyPosition);
        }

        this.obstacles.add(obs);
    }

    public SquareObstacle(int x, int y){
        this.x = x;
        this.y = y;
        generateObs();
    }

    public ArrayList<ArrayList<String>> getObstacles(){
        return this.obstacles;
    }

    @Override
    public boolean blocksPosition(Position pos){
        String positionXY = String.format("(%d,%d)", pos.getX(),pos.getY());
        for(ArrayList<String> squareObs : obstacles){
            if (squareObs.contains(positionXY)){
                return true;
            }
        } return false;
    }

    @Override
    public boolean blocksPath(Position a, Position b){
        for (Position pos : getRoutes(a,b)){
            if(blocksPosition(pos)){
                return true;
            }
        } return false;
    }
}