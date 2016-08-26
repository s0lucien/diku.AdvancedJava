package assignment1;


import java.util.List;

public class ListMutatorChunked<T> implements ListMutator<T> {
    public final int MAX_THREAD_COUNT = 3;

    @Override
    public void listMutate(Mutator<T> m, List<T> l) {
        int currentIndex = 0;
        ListMutator parallel = new ListMutatorParallel();
        List<T> next_batch;
        while(currentIndex + MAX_THREAD_COUNT < l.size()) {
            //System.out.println(currentIndex + " < " + l.size());
            next_batch = l.subList(currentIndex, currentIndex + MAX_THREAD_COUNT);
            currentIndex += MAX_THREAD_COUNT;
            parallel.listMutate(m,next_batch);
        }
        //System.out.println("parallelizing "+ currentIndex + " to " + l.size());
        next_batch = l.subList(currentIndex, l.size());
        parallel.listMutate(m,next_batch);
    }

}
