package zadLambda2;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<String, String> trim = (s -> s.trim());
        Function<String, String> toUpperCase = (s -> s.toUpperCase());
        Function<String, String> trimAndUpperCase = trim.andThen(toUpperCase);

        String example = " essasito ";

//        String temp1 = trim.apply(example);
//        String temp2 = toUpperCase.apply(temp1);
        String temp3 = trimAndUpperCase.apply(example);

//        System.out.println(temp2);
        System.out.println(temp3);

    }
}

