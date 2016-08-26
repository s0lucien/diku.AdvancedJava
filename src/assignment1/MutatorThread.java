package assignment1;

/**
 * Created by Lu on 8/25/2016.
 */
public class MutatorThread <T> extends Thread {

    Mutator <T> mutator;
    T obj;

    public MutatorThread (Mutator<T> mutator, T objectToMutate) {
        this.mutator = mutator;
        this.obj = objectToMutate;
    }

    @Override
    public void run() {
        mutator.mutate(obj);
    }
}


