package watki.bank;

public class Account {
    private String firstName;
    private double balance;

    public Account(String firstName, double balance) {
        this.firstName = firstName;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Wplacono " + amount + " zł");
        }
        else {
            System.out.println("Kwota do wplacenia musi byc dodatnia");
        }
    }

    public synchronized void withdraw(int amount){
        if(amount > 0 && balance <= amount){
            balance -= amount;
            System.out.println("Wyplacono " + amount  + " zl");
        }
        else {
            System.out.println("Kwota do wyplacenia musi byc dodatni lub saldo jest za małe");
        }
    }
}
