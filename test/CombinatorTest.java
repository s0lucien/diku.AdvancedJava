import assignment1.Employee;
import org.junit.Test;

public class CombinatorTest {

    private final int MIN_AGE = 20;
    private final int MAX_AGE = 60;
    private final int MIN_SALARY = 3000;
    private final int MAX_SALARY = 5000;

    @Test
    public void testAddSalaryForAssociativity() {
        for (int i = 0; i < 1000; i++) {
            Employee e_1 = genEmployee();
            Employee e_2 = genEmployee();
//            AddSalary
//            assertEquals(e_1)
        }
    }

    @Test
    public void testAddSalaryForNeutralElement() {

    }

    @Test
    public void testLongestNameForAssociativity() {

    }

    @Test
    public void testLongestNameForNeutralElement() {

    }

    private Employee genEmployee() {
        return new Employee("John Doe", MIN_AGE + (int)(Math.random() * MAX_AGE), MIN_SALARY + (int)(Math.random() * MAX_SALARY) );
    }
}
