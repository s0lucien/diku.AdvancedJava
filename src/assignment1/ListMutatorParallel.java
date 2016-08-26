package assignment1;

import java.util.ArrayList;
import java.util.List;

public class ListMutatorParallel<T> implements ListMutator<T> {

    @Override
    public void listMutate(Mutator<T> m, List<T> l) {
        ArrayList<Thread> starting = new ArrayList<>();
        for (T e: l) {
            Thread  t = new MutatorThread<T>(m,e);
            starting.add(t);
            t.start();
        }// starts all threads

        for (Thread t:starting) {
            try {
                t.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }//ensures that you wait on all of them to complete
    }
}
