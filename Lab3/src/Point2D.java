public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        this.x = this.y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void resetToOrigin() {
        this.x = this.y = 0;
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point2D && this.x == ((Point2D) obj).x && this.y == ((Point2D) obj).y;
    }
}
