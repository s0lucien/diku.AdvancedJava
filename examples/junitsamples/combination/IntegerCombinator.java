package junitsamples.combination;

public class IntegerCombinator implements Combinator<Integer, Integer> {

    @Override
    public Integer neutral() {        
        return 1;
    }

    @Override
    public Integer combine(Integer x, Integer y) {
        // throws an exception in case of overflow
        //return Math.multiplyExact(x, y);
        if (y == 0) { return 0; } else {return x * y;}
    }

    @Override
    public Integer get(Integer x) {        
        return x;
    }

}
