import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class LineSegment {
    private Point2D start;
    private Point2D end;

    public LineSegment() {
        this(new Point2D(0, 0), new Point2D(0, 0));
    }

    public LineSegment(Point2D start, Point2D end) {
        setStart(start);
        setEnd(end);
    }

    public LineSegment(LineSegment lineSegment) {
        this.start = lineSegment.start;
        this.end = lineSegment.end;
    }

    public Point2D getStart() {
        return start;
    }

    public void setStart(Point2D start) {
        if (start == null) {
            return;
        }
        this.start = start;
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        if (end == null) {
            return;
        }
        this.end = end;
    }

    public double distance() {
        return sqrt(pow(abs(end.getX() - start.getX()), 2) + pow(abs(end.getY() - start.getX()), 2));
    }

    @Override
    public String toString() {
        return "Line starts at " + start + " and ends at " + end;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof LineSegment &&
                this.start == ((LineSegment) obj).start && this.end == ((LineSegment) obj).end;
    }
}
