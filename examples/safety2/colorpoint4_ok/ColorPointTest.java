package safety2.colorpoint4_ok;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

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
        Point[] points = { new Point(1, 2), new Point(2, 3),
                new Point(1, 2), new Point(1, 2) };
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


    // The testTransitivityMix() test doesn't even typecheck now, as Point and ColorPoint only have Object as common
    // supertype. It therefore "succeeds" in the sense that it is impossible to run into the problematic behavior.


    /**
     * The Liskov substitution test also succeeds, since the previous attempt doesn't typecheck. We are forced to give
     * the Point view of a ColorPoint to the isOnUnitCircle() method - we cannot pass a ColorPoint as is.
     */
    @Test
    public void testLiskovSubstitutionPrinciple()
    {
        Point p = new Point(1,0);
        ColorPoint cp = new ColorPoint(1,0,Color.red);

        assertTrue(isOnUnitCircle(p));
        assertTrue(isOnUnitCircle(cp.asPoint()));
    }

    /**
     * Check that given point is on the unit circle.
     * @param p point
     * @return whether p lies on the unit circle or not
     */
    private boolean isOnUnitCircle(Point p)
    {
        Set<Point> unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1,0));
        unitCircle.add(new Point(-1,0));
        unitCircle.add(new Point(0,1));
        unitCircle.add(new Point(0,-1));
        return unitCircle.contains(p);
    }
}
