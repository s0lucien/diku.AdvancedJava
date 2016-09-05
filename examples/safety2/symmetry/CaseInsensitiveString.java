package safety2.symmetry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Unsafe implementation of equals() for a string implementation which considers strings to be equal up to case
 * insensitive comparison.
 */
public final class CaseInsensitiveString
{
    private final String s;
    public CaseInsensitiveString(String s)
    {
        if (s == null) throw new NullPointerException();
        this.s = s;
    }

    /**
     * The equals() implementation compares CaseInsensitiveString instances by comparing the underlying strings and
     * ignoring case.
     * This implementation also attempts to be compatible with ordinary strings. However, this breaks symmetry:
     *   new CaseInsensitiveString("Foo").equals("Foo") == true, but
     *   "Foo".equals(new CaseInsensitiveString("Foo")) == false,
     * since String.equals() does not know how to compare with CaseInsensitiveString.
     */
    @Override public boolean equals(Object o)
    {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        // this line is what causes the incorrect behavior. Too many objects are equated.
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    @Override public int hashCode()
    {
        return Objects.hash(s.toLowerCase());
    }

    /**
     * Demonstration of unpredictable behavior.
     * @param args
     */
    public static void main(String args[])
    {
        CaseInsensitiveString ifoo = new CaseInsensitiveString("Foo");
        List<CaseInsensitiveString> l1 = new ArrayList<CaseInsensitiveString>();
        List<String> l2 = new ArrayList<String>();
        l1.add(ifoo);
        l2.add("Foo");
        // It is up to the implementation which order .equals() is called in in the contains() method.
        // If equals() was implemented correctly, both of the following invocations should return the same.
        System.out.println("l1.contains(\"Foo\") === " + l1.contains("Foo"));
        System.out.println("l2.contains(si1) === " + l2.contains(ifoo));
    }
}
