package assignment1;

import java.util.List;

public class AggregatorSequential implements Aggregator<Employee, Integer>{

    @Override
    public Integer aggregate(Combinator<Employee, Integer> c, List<Employee> l) {
        Integer result = 0;
        for (Employee employee: l)
            result += c.get(employee);
        return result;
    }
}
