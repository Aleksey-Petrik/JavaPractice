package week1.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character> {
    private final char[] base;

    public StdString1() {
        base = new char[0];
    }

    public StdString1(char[] base) {
        this.base = base.clone();
    }

    public StdString1(StdString1 stdString1) {
        base = stdString1.toCharArray().clone();
    }

    public int length() {
        return base.length;
    }

    public StdString1 append(StdString1 that) {
        checkValidatity(that);

        char[] newBase = new char[base.length + that.length()];
        System.arraycopy(base.clone(), 0, newBase, 0, base.length);
        System.arraycopy(that.toCharArray().clone(), 0, newBase, base.length, that.length());

        return new StdString1(newBase);
    }

    public char[] toCharArray() {
        return base;
    }

    public char charAt(int index) {
        checkIndex(index);
        return base[index];
    }

    public int indexOf(char target) {
        for (int i = 0; i < base.length; i++) {
            if (base[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StdString1 that = (StdString1) o;

        char[] thatChars = that.toCharArray();
        if (base.length != thatChars.length) {
            return false;
        }
        for (int i = 1; i < base.length; i++) {
            if (base[i] != thatChars[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (char elem : base) {
            hash += elem;
        }
        return hash;
    }

    @Override
    public String toString() {
        return new String(base);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < base.length;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Elements is OVER!");
                }
                return base[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Character> action) {
        checkValidatity(action);
        for (Character elem : base) {
            action.accept(elem);
        }
    }

    private void checkValidatity(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Not be NULL!");
        }
    }

    private void checkIndex(int index) {
        if (index > base.length || index < 0) {
            throw new IndexOutOfBoundsException("");
        }
    }
}
