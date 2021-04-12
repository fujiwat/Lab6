package lab6_1;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit =0;

    public CheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public boolean withdraw(double amount) {
        if (super.getBalance() < amount) {
            if (this.overdraftLimit + this.getBalance() <= amount ) {
                System.out.println("withdraw failed: " + "(" + accountNumber + ") " + amount);
                return false;
            }
            System.out.println("withdraw succeeded: " + "(" + accountNumber + ") "+ amount);
            this.overdraftLimit -= amount - this.getBalance();
            super.withdraw(this.getBalance());
        } else {
            super.withdraw(amount);
        }
        return true;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}
