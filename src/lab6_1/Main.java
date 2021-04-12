package lab6_1;

import java.util.ArrayList; // import the ArrayList class
import java.util.Random;

public class Main {
    //    private ArrayList<BankAccount> accounts = new ArrayList <>();
    private static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static BankAccount newSavingsAccount(double interesRate) {
        BankAccount tempAccount;
        tempAccount = new SavingsAccount(interesRate);
        accounts.add(tempAccount);
        return tempAccount;
    }

    public static BankAccount newCheckingAccount(double overdraftLimit) {
        BankAccount tempAccount;
        tempAccount = new CheckingAccount(overdraftLimit);
        accounts.add(tempAccount);
        return tempAccount;
    }

    public static void main(String[] args) {
        // write your code here
        // test 1
        {
            System.out.println("test 1 ---------------------");
            BankAccount account1 = new SavingsAccount(0.1);
            System.out.println(account1);
            account1.deposit(1000);
            System.out.println(account1);
            ((SavingsAccount) account1).addInterest();
            System.out.println(account1);
        }
        // test 2
        {
            System.out.println("test 2 ---------------------");
            int custId;
            Random random = new Random();
            Customer customer;

            Bank bank = new Bank("OTP");
            customer = new Customer("Harvey ", "Specter");
            bank.addCustomer(customer);
            customer.addAccount(newSavingsAccount(0.1));
            customer.addAccount(newCheckingAccount(5000));

            customer = new Customer("Mike", "Ross");
            bank.addCustomer(customer);

            customer.addAccount(newSavingsAccount(0.1));
            customer.addAccount(newCheckingAccount(10000));

            custId = 1;
            System.out.println("**printCustomer before deposit");
            bank.getCustomer(custId).printCustomerToStdout();

            System.out.println("**printCustomer after deposit");
            for (String s : bank.getCustomer(custId).getAccountNumbers()) {
                BankAccount b = bank.getCustomer(custId).getAccount(s);
                b.deposit(random.nextInt(10) * 1000 + 500);
                if ( b instanceof SavingsAccount ) {
                    ((SavingsAccount) b).addInterest();
                }
            }
            bank.getCustomer(custId).printCustomerToStdout();

            System.out.println("**printCustomer after withdraw");
            for (String s : bank.getCustomer(custId).getAccountNumbers()) {
                BankAccount b = bank.getCustomer(custId).getAccount(s);
                b.withdraw(random.nextInt(10) * 1000 + 500);
                if ( b instanceof SavingsAccount ) {
                    ((SavingsAccount) b).addInterest();
                }
            }
            bank.getCustomer(custId).printCustomerToStdout();



            custId = 2;
            System.out.println("**printCustomer before deposit");
            bank.getCustomer(custId).printCustomerToStdout();

            System.out.println("**printCustomer after deposit");
            for (String s : bank.getCustomer(custId).getAccountNumbers()) {
                BankAccount b = bank.getCustomer(custId).getAccount(s);
                b.deposit(random.nextInt(10) * 100 + 50);
                if ( b instanceof SavingsAccount ) {
                    ((SavingsAccount) b).addInterest();
                }
            }
            bank.getCustomer(custId).printCustomerToStdout();

            System.out.println("**printCustomer after withdraw");
            for (String s : bank.getCustomer(custId).getAccountNumbers()) {
                BankAccount b = bank.getCustomer(custId).getAccount(s);
                b.withdraw(random.nextInt(10) * 1000 + 500);
                if ( b instanceof SavingsAccount ) {
                    ((SavingsAccount) b).addInterest();
                }
            }
            bank.getCustomer(custId).printCustomerToStdout();
        }
    }
}
