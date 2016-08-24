package generics;

public class PairExamples {
    public static void main(String[] args) {
        DynamicCheckedPair dynPair = new DynamicCheckedPair();
        dynPair.setFirst("A");
        dynPair.setFirst(1);
        dynPair.setSecond(2);
        
        Pair<String,Integer> pair = new Pair<>();
        pair.setFirst("A");
        //pair.setFirst(1); //type error
        pair.setSecond(2);
        System.out.println(pair);
        
        Pair rawPair = new Pair();
        rawPair = pair; // OK
        rawPair.setFirst("A");
        rawPair.setSecond("B");
        pair = rawPair; // not safe
        int snd = pair.getSecond(); // ClassCastException
        
        Pair<Object, Object> objPair = new Pair<>();
        // objPair = pair; type error
    }
}
