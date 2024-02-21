public class CreditCard {
    private String customer;
    private String bank;
    private String account;
    private int limit;
    private double balance;

    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public boolean charge(double price) {
        if (price + balance > limit) {
            return false;
        }
        balance += price;
        return true;
    }

    public void makePayment(double amount) {
        if (amount >= 0) {
            balance -= amount;
        }
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        CreditCard card = new CreditCard("jason", "a bank", "123456789", 10000, 5000.0);

        System.out.println("Customer: " + card.getCustomer());
        System.out.println("Bank: " + card.getBank());
        System.out.println("Account: " + card.getAccount());
        System.out.println("Limit: " + card.getLimit());
        System.out.println("Balance: " + card.getBalance());

        double chargeAmount = 4000.0;
        System.out.println("try to charge $" + chargeAmount);
        if (card.charge(chargeAmount)) {
            System.out.println("success");
        } else {
            System.out.println("failed due to exceeding limit.");
        }

        double paymentAmount = 1000.0;
        System.out.println("creating payment of $" + paymentAmount);
        card.makePayment(paymentAmount);

        System.out.println("updates: " + card.getBalance());
    }
}
