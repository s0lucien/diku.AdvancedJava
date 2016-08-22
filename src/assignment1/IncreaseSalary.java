package assignment1;

public class IncreaseSalary implements Mutator<Employee> {

    @Override
    public void mutate(Employee x) {
        if (x.getAge() > 40 ) {
            x.setSalary(x.getSalary() +x.getAge()/2  ); // one dollar less in odd case
        }
    }

}
