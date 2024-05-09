package accountmanagement;

public class Account {

    private long accountNo;
    private String customerName;
    private double balance;
    private static int count = 0;


    public Account(long accountNo, String customerName, double balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
        count++;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", customerName='" + customerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static int getCount() {
        return count;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into account. Updated balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " from account. Updated balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void showAccountInfo(){
        System.out.println("Account Number: "+accountNo+"\nAccount Name: "+customerName+"\nAccount Balance: "+balance);
    }

}
