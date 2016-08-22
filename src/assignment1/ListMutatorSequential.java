package assignment1;

import java.util.List;

public class ListMutatorSequential implements ListMutator<Employee> {

    @Override
    public void listMutate(Mutator<Employee> m, List<Employee> l) {
        for (Employee e: l) {
            m.mutate(e);
        }
    }
}
