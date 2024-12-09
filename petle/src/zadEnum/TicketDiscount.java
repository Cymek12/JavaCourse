package zadEnum;

public enum TicketDiscount {
    CHILD(0.23),
    ADULT(0.0),
    SENIOR(0.5);

    double discount;

    TicketDiscount(double discount) {
        this.discount = discount;
    }

    public double calculateDiscount(double price) {
        return price - price * discount;
    }
}
