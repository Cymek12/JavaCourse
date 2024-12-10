package zadStream;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        User user1 = new User(1L, "Ada", "Antczak", "a_antczak@email.com", 3456.5, 20, Job.JAVA_DEVELOPER);
        User user2 = new User(2L, "Beata", "Byk", "b_byk@email.com", 11223.5, 33, Job.SCALA_DEVELOPER);
        User user3 = new User(3L, "Czesław", "Cios", "c_cios@email.com", 6500.D, 33, Job.JAVA_DEVELOPER);
        User user4 = new User(4L, "Daria", "Chodkowska", "d_chodkowska@email.com", 2344.3, 40, Job.JAVA_DEVELOPER);
        User user5 = new User(5L, "Artur", "Boski", "a_boski@email.com", 8798.1, 21, Job.KOTLIN_DEVELOPER);
        User user6 = new User(6L, "Grzegorz", "Cyrych", "g_cytych@email.com", 12333D, 25, Job.GROOVY_DEVELOPER);
        User user7 = new User(7L, "Igor", "Drzewicki", "i_drzewicki@email.com", 12333D, 26, Job.JAVA_DEVELOPER);
        User user8 = new User(8L, "Lidia", "Figura", "l_figura@email.com", 1243D, 28, Job.SCALA_DEVELOPER);
        User user9 = new User(9L, "Norbert", "Gość", "n_gosc@email.com", 12322D, 45, Job.GROOVY_DEVELOPER);
        User user10 = new User(10L, "Urszula", "Grotkowska", "u_grotkowska@email.com", 11333D, 30, Job.SCALA_DEVELOPER);

        List<User> users = List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);

//        zad11
//        List<User> userNameContainsA = users.stream()
//                .filter(name -> name.getFirstName().contains("a"))
//                .toList();
//        for (User u : userNameContainsA) {
//            System.out.println(u);
//        }


//        zad10
//        users.stream()
//                .map(user -> {
//                    user.setSalary(user.getSalary() + 500);
//                            return user;
//                })
//                .forEach(System.out::println);


//        zad9
//        boolean isAgeEquals33 = users.stream()
//                .allMatch(user -> user.getAge() == 33);
//        System.out.println("Czy wszyscy maja 33 lata: " + isAgeEquals33);


//        zad8
//        boolean isAgeEquals33 = users.stream()
//                .anyMatch(user -> user.getAge() == 33);
//        System.out.println("czy ktos ma 33 lata: " + isAgeEquals33);


//        zad7
//        Optional<User> any = users.stream()
//                .filter(user -> user.getAge() > 25)
//                .findAny();
//        any.ifPresent(System.out::println);


//        zad6
//        Optional<User> first = users.stream()
//                .filter(user -> user.getId() == 1L)
//                .findFirst();
//        first.ifPresent(System.out::println);


//        zad5
//        DoubleSummaryStatistics doubleSummaryStatistics = users.stream()
//                .mapToDouble(x -> x.getSalary())
//                .summaryStatistics();
//        System.out.println(doubleSummaryStatistics);


//        zad4
//        long count = users.stream()
//                .filter(user -> user.getAge() % 2 == 0)
//                .filter(user -> user.getJob().equals(Job.JAVA_DEVELOPER))
//                .count();
//        System.out.println(count);


//        zad3
//        String example = users.stream()
//                .map(user -> user.getEmail())
//                .collect(Collectors.joining(", "));
//        System.out.println(example);


//        zad2
//        users.stream()
//                .map(user -> user.getEmail())
//                .forEach(System.out::println);


//        zad1
//        users.stream()
//                .filter(user -> user.getSalary()>5000.0)
//                .forEach(System.out::println);
    }
}