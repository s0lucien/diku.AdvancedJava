package safety2;

import java.util.Objects;

/**
 * Simple immutable Point with overridden equals and hashCode. Also implements Comparable<Point> in a way that is
 * consistent with equals.
 */
public class Point implements Comparable<Point>
{
    private final int x;
    private final int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    @Override public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    @Override public boolean equals(Object o)
    {
        // Note: This includes an implicit null check (`null instanceOf T' is false for all T)
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return (x == p.x && y == p.y);
    }

    @Override public int hashCode()
    {
        // From Java 7, you can use Objects.hash() to implement efficient hash functions with minimal fuzz!
        return Objects.hash(x, y);
    }

    /**
     * Compare this point to another, and return a negative number, zero or a positive number if the other point is less
     * than, equal or greater to this point, respectively.
     * Numbers are compared lexicographically. That is, (a, b) < (x, y) if a < x or a == x and b < y.
     */
    public int compareTo(Point other)
    {
        if (x != other.x)
            return x < other.x ? -1 : 1;
        return Integer.compare(y, other.y);
    }
}
