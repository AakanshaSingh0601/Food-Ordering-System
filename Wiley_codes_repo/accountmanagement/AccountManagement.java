package accountmanagement;

import java.util.Scanner;

public class AccountManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner("System.in");

        // Create few accounts
        Account a1 = new Account(1234567890, "Taniya Sethiya" , 100000);
        Account a2 = new Account(456678789 , "Siddhant Thakur" , 200000);
        a1.showAccountInfo();
        a2.showAccountInfo();

       // Display the number of accounts
        int count= Account.getCount();
        System.out.println("Number of accounts created: " + count);

        // Do the basic operations (deposit/withdraw)
        a1.deposit(4000);
        a2.deposit(6000);

        a1.withdraw(1000);
        a2.withdraw(200000);

        a1.showAccountInfo();
        a2.showAccountInfo();

    }

}
