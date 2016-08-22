import assignment1.Employee;
import assignment1.ListMutator;
import org.junit.Test;

import java.util.ArrayList;

public class ListMutatorTest {
    @Test
    public void testSomething() {
//        testListMutation();
//        assertEquals(dataSet().get(0),5);
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
        // 3000 + 2500 + 3000 + 3000 + 8000 + 3000 + 9999 + 5000 + 2000 + 2500
        // = 41.999
        // 25 + 28 + 33 + 33
        // = 119
    }

    /*
    . Writeaprivatemethodcalled testListMutationthattakesa ListMutator implementation as input, runs a map of IncreaseSalary on your
    data set, sums the salaries of the employees and asserts the equality
    of the actual sum of salaries with the expected.
     */

    private void testListMutation(ListMutator lm) {
//        assertEquals(lm.listMutate(new IncreaseSalary(), dataSet()), 41999+119);
    }
}
