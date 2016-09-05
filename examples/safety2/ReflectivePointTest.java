package safety2;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class ReflectivePointTest
{
    private Random rand = new Random();

    private ReflectivePoint genPoint()
    {
        return new ReflectivePoint(rand.nextInt(7)-3, rand.nextInt(7)-3);
    }

    @Test
    public void testReflexivity()
    {
        for (int i = 0; i < 5000; i++)
        {
            ReflectivePoint p = genPoint();
            assertTrue(p.equals(p));
        }
    }

    @Test public void testSymmetry()
    {
        for (int i = 0; i < 5000; i++)
        {
            ReflectivePoint p1 = genPoint();
            ReflectivePoint p2 = genPoint();
            assertTrue(!p1.equals(p2) || p2.equals(p1));
        }
    }

    @Test public void testTransitivity()
    {
        for (int i = 0; i < 5000; i++)
        {
            ReflectivePoint p1 = genPoint(), p2 = genPoint(), p3 = genPoint();
            assertTrue(!(p1.equals(p2) && p2.equals(p3)) || p1.equals(p3));
        }
    }

    @Test public void testComparableCompatibility()
    {
        for (int i = 0; i < 5000; i++)
        {
            ReflectivePoint p1 = genPoint(), p2 = genPoint();
            assertTrue("natural order incompatible with equals: " + p1 + ", " + p2, (p1.compareTo(p2) == 0) == p1.equals(p2));
        }
    }
}
