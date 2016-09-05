package safety2.colorpoint4_ok;

import java.awt.Color;

import safety2.Point;

public final class ColorPoint
{
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color)
    {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint()
    {
        return point;
    }

    @Override public String toString()
    {
        return "(" + point.getX() + "," + point.getY() + ";" + color.getRGB() + ")";
    }

    @Override public boolean equals(Object o)
    {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint c = (ColorPoint) o;
        return point.equals(c.point) && color.equals(c.color);
    }
}
