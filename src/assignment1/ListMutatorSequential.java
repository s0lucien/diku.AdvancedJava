package assignment1;

import java.util.List;

public class ListMutatorSequential<T> implements ListMutator<T> {

    @Override
    public void listMutate(Mutator<T> m, List<T> l) {
        l.forEach(m::mutate);
    }
}
