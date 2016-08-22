import assignment1.Employee;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CombinatorTest {

    final int MIN_AGE = 20;
    final int MAX_AGE = 60;
    final int MIN_SALARY = 3000;
    final int MAX_SALARY = 5000;

    @Test
    public void testSomething() {
        assertEquals(5, 5);
    }

    private Employee genEmployee() {
//        int randomAge = ;
//        int randomSalary = ;

        return new Employee("John Doe", MIN_AGE + (int)(Math.random() * MAX_AGE), MIN_SALARY + (int)(Math.random() * MAX_SALARY) );
    }
}
