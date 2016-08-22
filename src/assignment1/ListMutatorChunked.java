package assignment1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMutatorChunked implements ListMutator<Employee> {
    public final int MAX_THREAD_COUNT = 3;

    @Override
    public void listMutate(Mutator<Employee> m, List<Employee> l) {
        int currentIndex = 0;
        List<Employee> next_batch;
        if(currentIndex < l.size()) {
            next_batch = l.subList(currentIndex, currentIndex + MAX_THREAD_COUNT);
        }else{
            next_batch = l.subList(currentIndex, l.size());
        }

        for (Employee e : next_batch){
            new Thread() {
                public void run() {
                    m.mutate(e);
                    //Thread.yield();
                }
            }.start();
        }

    }

}
