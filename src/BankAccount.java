public class BankAccount {
    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    public void deposit(double sum) {
        if (sum > 0) {
            amount += sum;
        }
    }
    public void withDraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Недостаточно средств на счете", amount);
        }
        amount -= sum;
    }
}
