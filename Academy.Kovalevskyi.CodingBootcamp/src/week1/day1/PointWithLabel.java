package week1.day1;

import week1.day0.Point;

public class PointWithLabel extends PointWithValue<String> implements Comparable<Point> {
    public PointWithLabel(int coordinatX, int coordinatY, String value) {
        super(coordinatX, coordinatY, value);
    }

    public String getLabel() {
        return getValue();
    }

    @Override
    public int compareTo(Point o) {
        if (!(o instanceof PointWithLabel)) {
            return super.compareTo(o);
        }
        return getLabel().compareTo(((PointWithLabel) o).getValue());
    }
}
