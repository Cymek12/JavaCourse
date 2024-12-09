package zadEnum;

public class Main {
    public static void main(String[] args) {
        double ticketPrice = 50;

        for (TicketDiscount value : TicketDiscount.values()) {
            System.out.println(value.calculateDiscount(ticketPrice));
        }
    }
}
