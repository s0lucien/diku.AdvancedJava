package assignment1;


import java.util.List;

public class ListMutatorChunked implements ListMutator<Employee> {
    public final int MAX_THREAD_COUNT = 3;

    @Override
    public void listMutate(Mutator<Employee> m, List<Employee> employees) {
        int currentIndex = 0;
        List<Employee> next_batch;
        if(currentIndex < employees.size()) {
            next_batch = employees.subList(currentIndex, currentIndex + MAX_THREAD_COUNT);
        }else{
            next_batch = employees.subList(currentIndex, employees.size());
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
