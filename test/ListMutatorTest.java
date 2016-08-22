import assignment1.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListMutatorTest {

    @Test
    public void testListMutatorSequential() {
        testListMutation(new ListMutatorSequential());
    }

    @Test
    public void testListMutatorParallel() {
        // It is flickering, because the threads do not finish in the same sequence as they started.
        testListMutation(new ListMutatorParallel());
    }

    @Test
    public void testListMutatorChunked() {
        testListMutation(new ListMutatorChunked());
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
    }

    private void testListMutation(ListMutator lm) {
        ArrayList<Employee> data = dataSet();
        lm.listMutate(new IncreaseSalary(), data);
        assertEquals(data.get(0).getSalary(), 3000);
        assertEquals(data.get(1).getSalary(), 2500);
        assertEquals(data.get(2).getSalary(), 3000);
        assertEquals(data.get(3).getSalary(), 3000);
        assertEquals(data.get(4).getSalary(), 8000);
        assertEquals(data.get(5).getSalary(), 3000);
        assertEquals(data.get(6).getSalary(), 10024);
        assertEquals(data.get(7).getSalary(), 5028);
        assertEquals(data.get(8).getSalary(), 2033);
        assertEquals(data.get(9).getSalary(), 2533);
    }
}
