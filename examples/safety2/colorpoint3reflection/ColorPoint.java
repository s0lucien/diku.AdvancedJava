package safety2.colorpoint3reflection;

import java.awt.Color;

import safety2.ReflectivePoint;

/**
 * Attempt to fix the problem demonstrated in safety2.transitivity by using reflection to make objects of different
 * classes incomparable.
 */
public class ColorPoint extends ReflectivePoint
{
    private final Color color;

    public ColorPoint(int x, int y, Color color)
    {
        super(x, y);
        this.color = color;
    }

    @Override public String toString()
    {
        return "(" + getX() + "," + getY() + ";" + color.getRGB() + ")";
    }

    @Override public boolean equals(Object o)
    {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint c = (ColorPoint) o;
        return getX() == c.getX() && getY() == c.getY() && color.equals(c.color);
    }
}
