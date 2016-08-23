package assignment1;

import java.util.List;

public class AggregatorParallel implements Aggregator<Employee, Integer>{

    private Integer result;
    private Thread mainThread;

    public AggregatorParallel() {
        this.result = 0;
    }

    @Override
    public Integer aggregate(Combinator<Employee, Integer> c, List<Employee> list) {
        divideAndConquer(list, c);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.currentThread().wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return result;
    }

    private void divideAndConquer(List<Employee> list, Combinator<Employee, Integer> c) {
        new Thread() {
            public void run() {
                if (list.size() > 1) {
                    List<Employee> head = list.subList(0, list.size()/2);
                    List<Employee> tail = list.subList(list.size()/2, list.size());
                    divideAndConquer(head, c);
                    divideAndConquer(tail, c);
                } else {
                    result = c.combine(result, c.get(list.get(0)));
//                    notify();
                }
            }
        }.start();
    }
}
