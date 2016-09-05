package safety2.comparable;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Simple example to demonstrate what might happen when you implement Comparable such that it is not consistent with
 * equals. Note that this is legal according to the contract of Comparable, but that it might break data structures
 * relying on this consistency. The sorted collections in the Java library which rely on Comparable say in their
 * documentations that the elements put in the collections should implement Comparable such that it is consistent with
 * equals.
 *
 * You can still use them even though this is not satisfied, but be aware that, for example, different Set
 * implementations will give different results.
 *
 * In this example we use a class from the Java library (BigDecimal) which implements Comparable in a way that is
 * inconsistent with equals, and show that HashSet and TreeSet behave differently.
 */

public class InconsistentWithEqualsExample
{
    public static void main(String[] args)
    {
        // BigDecimal implements arbitrary-precision decimal numbers.

        // The following two numbers represent the same value, but at different scale (the first has one zero to the
        // right of the decimal point, the second has two zeroes).
        // The natural order considers them equal, but .equal takes scale into account and deems them to be unequal.
        BigDecimal b1 = new BigDecimal("2.0");
        BigDecimal b2 = new BigDecimal("2.00");

        // HashSet uses .equals and .hashCode to determine equality.
        Set<BigDecimal> hashSet = new HashSet<BigDecimal>();
        // TreeSet uses the equivalence induced by the natural order as its notion of equality.
        Set<BigDecimal> treeSet = new TreeSet<BigDecimal>();

        // Add the two BigDecimals to the two sets.
        hashSet.add(b1);
        hashSet.add(b2);
        treeSet.add(b1);
        treeSet.add(b2);

        System.out.println(hashSet); // Prints [2.00, 2.0]
        System.out.println(treeSet); // Prints [2.0]
    }
}
