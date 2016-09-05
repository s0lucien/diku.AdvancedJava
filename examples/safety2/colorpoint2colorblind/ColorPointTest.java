package safety2.colorpoint2colorblind;

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
     * This test succeeds now.
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

    /**
     * But now we have a new problem. The Liskov substitution principle says if some type S satisfies a property P(S),
     * then for all subtypes T of S should satisfy P(T). In other words, if we only observe propertyies about the
     * interface on S, then if S is actually a T, we should not be able to observe any difference. This is what you
     * normally expect, and is the reason why the interface abstraction works so well (i.e., you just talk to a List<T>,
     * and you do not care that it is actually an ArrayList<T> underneath).
     *
     * This test demonstrates that our "fixed" equals() method violates the Liskov substitution principle. Break
     * abstraction; not good!
     *
     * It is in fact *impossible* to define an equals() method that both implements a proper equivalence relation and
     * also satisfies the Liskov substitution principle.
     */
    @Test
    public void testLiskovSubstitutionPrinciple()
    {
        // We have two points with the same coordinates, but one is a red ColorPoint.
        Point p = new Point(1,0);
        Point cp = new ColorPoint(1,0,Color.red);

        // Seen as a Point, both p and cp lies on the unit circle. We would therefore expect the following two tests to
        // return true:
        assertTrue(isOnUnitCircle(p));
        // ... but this one fails:
        assertTrue(isOnUnitCircle(cp));
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
