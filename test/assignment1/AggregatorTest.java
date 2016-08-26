package assignment1;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class AggregatorTest {

    @Test
    public void testAggregatorSequential() {
        testAggregation(new AggregatorSequential());
    }

    @Test
    public void testAggregatorParallel() {
        testAggregation(new AggregatorParallel());
    }

    private void testAggregation(Aggregator a) {
        ArrayList<Employee> employees = ListMutatorTest.dataSet();
        Combinator<Employee,Integer> c = new AddSalary();
        assertEquals(41999, a.aggregate(c, employees));
    }



}
