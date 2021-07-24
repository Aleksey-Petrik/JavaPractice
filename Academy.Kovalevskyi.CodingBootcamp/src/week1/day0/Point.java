package week1.day0;

public class Point implements Comparable<Point> {

    private final int coordinatX;
    private final int coordinatY;

    public Point(final int coordinatX, final int coordinatY) {
        this.coordinatX = coordinatX;
        this.coordinatY = coordinatY;
    }

    public int getX() {
        return coordinatX;
    }

    public int getY() {
        return coordinatY;
    }

    public Point updateX(int newX) {
        return new Point(newX, coordinatY);
    }

    public Point updateY(int newY) {
        return new Point(coordinatX, newY);
    }

    public Point sum(final Point that) {
        return new Point(coordinatX + that.getX(), coordinatY + that.coordinatY);
    }

    public int distanceTo(Point that) {
        return NumberUtils.powerRecursive(coordinatX - that.getX(), 2)
                + NumberUtils.powerRecursive(coordinatY - that.getY(), 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return coordinatX == point.coordinatX && coordinatY == point.coordinatY;
    }

    @Override
    public int hashCode() {
        return coordinatX + coordinatY;
    }

    @Override
    public String toString() {
        return "Point{"
                + "X: " + coordinatX
                + ", Y: " + coordinatY
                + '}';
    }

    @Override
    public int compareTo(Point o) {
        int thisPoint = coordinatX + coordinatY;
        int thatPoint = o.getX() + o.getY();
        return thisPoint - thatPoint;
    }

}
