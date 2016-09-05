package safety2.colorpoint1super;

import java.awt.Color;

import safety2.Point;

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
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint c = (ColorPoint) o;
        return super.equals(o) && color.equals(c.color);
    }
}
