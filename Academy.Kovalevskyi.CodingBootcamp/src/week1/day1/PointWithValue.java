package week1.day1;

import week1.day0.Point;

import java.util.function.Function;

public class PointWithValue<T> extends Point {
    private final T value;

    public PointWithValue(int coordinatX, int coordinatY, T value) {
        super(coordinatX, coordinatY);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <R> PointWithValue<R> mapPoint(Function<T, R> mapFunction) {
        return new PointWithValue<R>(getX(), getY(), mapFunction.apply(value));
    }

    @Override
    public String toString() {
        return "PointWithValue{"
                + " X: " + getX()
                + ", Y: " + getY()
                + ", value: " + value
                + '}';
    }
}
