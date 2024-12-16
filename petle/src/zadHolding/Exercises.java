package zadHolding;

import zadHolding.generator.HoldingGenerator;
import zadHolding.model.*;
import zadHolding.model.Currency;
import zadHolding.model.Holding;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();

    public static void main(String[] args) {

    }


    /** ZADANIE 1
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(s -> !s.getCompanies().isEmpty())
                .count();
    }

    /** ZADANIE 2
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {
        return holdings.stream()
                .map(s -> {
                    String name = s.getName();
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    return name;
                })
                .collect(Collectors.toList());
    }

    /** ZADANIE 3
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {
        return holdings.stream()
                .map(s -> s.getName())
                .sorted()
                .collect(Collectors.joining(", ", "(", ")"));
    }

    /** ZADANIE 4
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .count();
    }

    /** ZADANIE 5
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .count();
    }

    /** ZADANIE 6
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {
        return holdings.stream()
                        .flatMap(s -> s.getCompanies().stream())
                        .map(s -> s.getName())
                        .collect(Collectors.toCollection(LinkedList::new));
    }

    /** ZADANIE 7
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount()
                .multiply(BigDecimal.valueOf(account.getCurrency().rate))
                .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    /** ZADANIE 8
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .filter(userPredicate)
                .map(s -> s.getFirstName())
                .collect(Collectors.toSet());
    }

    /** ZADANIE 9
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .forEach(consumer);
    }

    /** ZADANIE 10
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        Optional<User> max = holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .filter(s -> s.getSex().equals(Sex.WOMAN))
                .max(Comparator.comparing(Exercises::getUserAmountInPLN));

        return max;
    }

    private static BigDecimal getUserAmountInPLN(final User user) {
        return user
                .getAccounts()
                .stream()
                .map(Exercises::getAccountAmountInPLN)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /** ZADANIE 11
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .limit(n)
                .map(s -> s.getName())
                .collect(Collectors.toSet());
    }

    /** ZADANIE 12
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getUsers()));
    }

    /** ZADANIE 13
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        Optional<User> firstUserMatch = holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .filter(predicate)
                .findFirst();

        if(firstUserMatch.isEmpty()){
            throw new IllegalArgumentException();
        }

        return firstUserMatch.get();
    }

    /** ZADANIE 14
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .flatMap(s -> s.getAccounts().stream())
                .collect(Collectors.toMap(s -> s.getNumber(), s -> s));
    }

    /** ZADANIE 15
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .map(s -> s.getFirstName())
                .distinct()
                .collect(Collectors.joining(", "));
    }

    /** ZADANIE 16
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
        String result = holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return -o1.compareTo(o2);
                    }
                })
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    /** ZADANIE 17
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return holdings.stream()
                .flatMap(s -> s.getCompanies().stream())
                .flatMap(s -> s.getUsers().stream())
                .flatMap(s -> s.getAccounts().stream())
                .map(s -> s.getCurrency())
                .collect(Collectors.toSet());
    }

    /** ZADANIE 18
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream());
    }

    /** ZADANIE 19
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream()
                .flatMap(company -> company.getUsers().stream());
    }

    /** ZADANIE 20
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream()
                .flatMap(user -> user.getAccounts().stream());
    }

}
