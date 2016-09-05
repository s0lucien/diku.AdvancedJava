package safety2.colorpoint2colorblind;

import java.awt.Color;

import safety2.Point;

/**
 * Attempt to fix the problem demonstrated in safety2.transitivity by using reflection to make objects of different
 * classes incomparable.
 */
public class ColorPoint extends Point
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
        if (!(o instanceof Point))
            return false;

        // Do color-blind comparison if o is a normal point
        if (!(o instanceof ColorPoint))
            return o.equals(this);

        ColorPoint c = (ColorPoint) o;
        return (super.equals(o) && color.equals(c.color));
    }
}
