package zadLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
        OwnPredicate<Integer> predicate = s -> s < 10;

        for (Integer i : filterList(numbers, predicate)) {
            System.out.println(i);
        }
    }

    @FunctionalInterface
    interface OwnPredicate<T>{
        boolean test(T number);
    }

    static public List<Integer> filterList(List<Integer> integerList, OwnPredicate<Integer> predicate) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer i : integerList) {
            if(predicate.test(i)){
                resultList.add(i);
            }
        }
        return resultList;
    }


}