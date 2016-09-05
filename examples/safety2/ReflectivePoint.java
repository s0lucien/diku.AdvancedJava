package safety2;

import java.util.Objects;

/**
 * Attempt to fix the problem demonstrated in colorpoint2colorblind by modifying equals in the base class to make
 * subtypes incomparable to this type. THIS DOES NOT WORK!
 */
public class ReflectivePoint implements Comparable<ReflectivePoint>
{
    private final int x;
    private final int y;

    public ReflectivePoint(int x, int y)
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
        // Use reflection to check that runtime types match. This effectively makes ReflectivePoint incomparable with
        // subtypes.
        if (o == null || o.getClass() != getClass())
            return false;
        ReflectivePoint p = (ReflectivePoint) o;
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
    public int compareTo(ReflectivePoint other)
    {
        if (x != other.x)
            return x < other.x ? -1 : 1;
        return Integer.compare(y, other.y);
    }
}
