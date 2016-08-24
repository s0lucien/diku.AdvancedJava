///*
//package junitsamples.combination;
//
//import static org.junit.Assert.*;
//
//import java.util.Random;
//
//import org.junit.Test;
//
//public class IntegerCombinatorTest {
//
//    private Random rnd = new Random();
//    Combinator<Integer, Integer> intComb = new IntegerCombinator();
//
//    @Test
//    public void testTwoTimesTwo() {
//        Integer expected = 4;
//        assertEquals(expected, intComb.combine(intComb.get(2), intComb.get(2)));
//    }
//
//    @Test
//    public void testNeutralElem() {
//        Integer testValue = 42;
//        assertEquals(intComb.combine(intComb.neutral(), intComb.get(testValue)),
//                intComb.get(testValue));
//    }
//
//    @Test
//    public void testNeutralElemRnd() {
//        for (int i = 0; i < 10000; i++) {
//            Integer testValue = new Integer(rnd.nextInt(1000));
//            assertEquals(
//                    intComb.combine(intComb.neutral(), intComb.get(new Integer(testValue))),
//                    intComb.get(intComb.get(testValue)));
//        }
//    }
//
//    @Test(expected = ArithmeticException.class)
//    public void testOverflow() {
//        //requires Math.multiplyExact in place of regular multiplication in combine() method.
//        intComb.combine(intComb.get(Integer.MAX_VALUE), intComb.get(Integer.MAX_VALUE));
//    }
//
//}
//*/
