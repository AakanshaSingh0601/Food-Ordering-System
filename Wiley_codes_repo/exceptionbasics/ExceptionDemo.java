package exceptionbasics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello");

        System.out.println("Enter two numbers : ");

        int a = 0;
        int b = 0;

        try{
            a = scanner.nextInt();
            b = scanner.nextInt();

            int result = a / b;
            System.out.println(a + "/" + b + " = " + result);
        }
        catch (ArithmeticException e){
            System.out.println("Sorry you can't divide a number by zero");
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Please Enter a valid input!");
            //System.exit(0);
        }
        System.out.println("Anything more you want?");

        System.out.println("Please provide your feedback");
        scanner.next();

        String feedback = scanner.next()+scanner.nextLine();

        System.out.println("Thank You");


    }

}
