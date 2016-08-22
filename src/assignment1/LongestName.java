package assignment1;

public class LongestName implements Combinator<Employee, String> {

    @Override
    public String neutral() {
        return "";
    }

    @Override
    public String combine(String x, String y) {
        if (x.length() == y.length()) {
            return x.compareToIgnoreCase(y) > 0 ?  x : y; // in case of equality, it does not matter wether x or y is returned
        } else
            return x.length() > y.length() ? x : y;
    }

    @Override
    public String get(Employee x) {
        return x.getName();
    }
}
