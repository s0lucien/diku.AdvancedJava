package assignment1;

import java.util.List;

public class ListMutatorParallel implements ListMutator<Employee> {

    @Override
    public void listMutate(Mutator<Employee> m, List<Employee> l) {
        for (Employee e: l) {
            new Thread() {
                public void run() {
                    m.mutate(e);
                }
            }.start();
        }
    }
}
