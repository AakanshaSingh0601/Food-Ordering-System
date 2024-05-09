package FileHandling;
import java.io.*;

public class ConsoleImplementation {
    public static void main(String[] args) {
        Console console = System.console();
        if(console !=null){
            console.printf("Enter your name: ");
            System.out.println(console.readLine());
        }

    }
}
