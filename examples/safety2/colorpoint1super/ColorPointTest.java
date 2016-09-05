package safety2.colorpoint1super;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import safety2.Point;

public class ColorPointTest
{
    /**
     * Point.equals is reflexive and symmetric, and has the "non-nullity" property.
     */
    @Test
    public void testEqualsPoint()
    {
        assertTrue(new Point(1,2).equals(new Point(1,2)));
        assertFalse(new Point(1,2).equals(new Point(1,3)));
        Point p = new Point(5,6);
        assertTrue(p.equals(p));
        assertFalse(p.equals(null));
    }

    /**
     * ColorPoint.equals is reflexive and symmetric, and has the "non-nullity" property.
     */
    @Test
    public void testEqualsColorPoint()
    {
        assertTrue(new ColorPoint(1,2, Color.red).equals(new ColorPoint(1,2, Color.red)));
        assertFalse(new ColorPoint(1,2, Color.red).equals(new ColorPoint(1,3, Color.red)));
        assertFalse(new ColorPoint(1,2, Color.red).equals(new ColorPoint(1,2, Color.green)));
        ColorPoint p = new ColorPoint(5,6, Color.red);
        assertTrue(p.equals(p));
        assertFalse(p.equals(null));
    }

    @Test
    public void testSymmetry()
    {
        Point[] points = { new Point(1, 2), new ColorPoint(2, 3, Color.red),
                new ColorPoint(1, 2, Color.red), new ColorPoint(1, 2, Color.green) };
        for (Point a : points)
            for (Point b : points)
                assertTrue("Symmetry failed: " + a + ", " + b, !(a.equals(b)) || b.equals(a));
    }

    /**
     * Point.equals is transitive when restricted to points.
     */
    @Test
    public void testTransitivityPoint()
    {
        Point[] points = { new Point(1,2), new Point(2,3), new Point(1,2), new Point(3,2) };
        for (Point a : points)
            for (Point b : points)
                for (Point c : points)
                {
                    assertTrue(!(a.equals(b) && b.equals(c)) || a.equals(c));
                }
    }

    /**
     * ColorPoint.equals is transitive when restricted to color points.
     */
    @Test
    public void testTransitivityColorPoint()
    {
        ColorPoint[] points = { new ColorPoint(1, 2, Color.red), new ColorPoint(2, 3, Color.red),
                new ColorPoint(1, 2, Color.red), new ColorPoint(3, 2, Color.green) };
        for (ColorPoint a : points)
            for (ColorPoint b : points)
                for (ColorPoint c : points)
                {
                    assertTrue(!(a.equals(b) && b.equals(c)) || a.equals(c));
                }
    }

    /**
     * This test fails. Point and ColorPoint should not be comparable, since one "has more information" than the other.
     * This breaks transitivity. (1,2; red) "equals" (1,2) and (1,2) "equals" (1,2; green), but we do not have
     *   (1,2; red) "equals" (1,2; green)
     */
    @Test
    public void testTransitivityMix()
    {
        Point[] points = { new Point(1, 2), new ColorPoint(2, 3, Color.red),
                new ColorPoint(1, 2, Color.red), new ColorPoint(1, 2, Color.green) };
        for (Point a : points)
            for (Point b : points)
                for (Point c : points)
                {
                    assertTrue(a + " == " + b + " and " + b + " == " + c + ", but " + a + " != " + c,
                            !(a.equals(b) && b.equals(c)) || a.equals(c));
                }
    }
}
