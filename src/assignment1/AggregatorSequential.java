package assignment1;

import java.util.List;

public class AggregatorSequential implements Aggregator<Employee, Integer>{

    private Integer result;

    public AggregatorSequential() {
        this.result = 0;
    }

    @Override
    public Integer aggregate(Combinator<Employee, Integer> c, List<Employee> l) {
        for (Employee employee: l) {
            this.result = c.combine(this.result, c.get(employee));
        }
        return this.result;
    }
}
