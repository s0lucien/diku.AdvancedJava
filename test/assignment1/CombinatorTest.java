package assignment1;

import assignment1.AddSalary;
import assignment1.Combinator;
import assignment1.Employee;
import assignment1.LongestName;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CombinatorTest {

    private final int MIN_AGE = 20;
    private final int MAX_AGE = 60;
    private final int MIN_SALARY = 3000;
    private final int MAX_SALARY = 5000;

    @Test
    public void testAddSalaryForAssociativity() {
        testAssociativityOneThousandTimes(new AddSalary());
    }

    @Test
    public void testLongestNameForAssociativity() {
        testAssociativityOneThousandTimes(new LongestName());
    }

    @Test
    public void testAddSalaryForNeutralElement() {
        testNeutralElementOneThousandTimes(new AddSalary());
    }

    @Test
    public void testLongestNameForNeutralElement() {
        testNeutralElementOneThousandTimes(new LongestName());
    }

    private void testAssociativityOneThousandTimes(Combinator c) {
        for (int i = 0; i < 1000; i++) {
            Employee e_1 = genEmployee();
            Employee e_2 = genEmployee();
            Employee e_3 = genEmployee();
            assertEquals(c.combine(c.get(e_1), c.combine(c.get(e_2), c.get(e_3))), c.combine(c.combine(c.get(e_1), c.get(e_2)), c.get(e_3)));
        }
    }

    private void testNeutralElementOneThousandTimes(Combinator c) {
        for (int i = 0; i < 1000; i++) {
            Employee employee = genEmployee();
            assertEquals(c.combine(c.get(employee), c.neutral()), c.combine(c.neutral(), c.get(employee)));
        }
    }

    private Employee genEmployee() {
        return new Employee("John Doe", MIN_AGE + (int)(Math.random() * MAX_AGE), MIN_SALARY + (int)(Math.random() * MAX_SALARY) );
    }
}
