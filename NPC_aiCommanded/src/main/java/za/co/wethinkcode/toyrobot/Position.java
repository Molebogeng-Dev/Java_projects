package za.co.wethinkcode.toyrobot;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Position position = (Position) obj;
        return x == position.x && y == position.y;

    }
    public boolean isIn(Position topLeft, Position bottomRight) {
        boolean withinTop = y <= topLeft.getY();
        boolean withinBottom = y >= bottomRight.getY();
        boolean withinLeft = x >= topLeft.getX();
        boolean withinRight = x <= bottomRight.getX();
        return withinTop && withinBottom && withinLeft && withinRight;
    }
}
