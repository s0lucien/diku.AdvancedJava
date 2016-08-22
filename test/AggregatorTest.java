import assignment1.*;
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
        ArrayList<Employee> employees = dataSet();
        Combinator<Employee,Integer> c = new AddSalary();
        assertEquals(41999, a.aggregate(c, employees));
    }


    private ArrayList<Employee> dataSet() {
        ArrayList<Employee> result = new ArrayList<>();
        result.add(new Employee("Bla", 18, 3000));
        result.add(new Employee("Blb", 19, 2500));
        result.add(new Employee("Blc", 20, 3000));
        result.add(new Employee("Bld", 30, 3000));
        result.add(new Employee("Ble", 40, 8000));
        result.add(new Employee("Blf", 33, 3000));
        result.add(new Employee("Blg", 50, 9999));
        result.add(new Employee("Blh", 56, 5000));
        result.add(new Employee("Bli", 66, 2000));
        result.add(new Employee("Blj", 67, 2500));
        return result;
        // sum = 3000 + 2500 + 3000 + 3000 + 8000 + 3000 + 9999 + 5000 + 2000 + 2500 = 41999
    }
}
