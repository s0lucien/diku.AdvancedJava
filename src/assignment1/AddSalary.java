package assignment1;

/**
 * Created by lucia on 8/22/2016.
 */
public class AddSalary implements Combinator<Employee,Integer> {
    @Override
    public Integer neutral() {
        return null;
    }

    @Override
    public Integer combine(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public Integer get(Employee x) {
        return x.getSalary();
    }
}
