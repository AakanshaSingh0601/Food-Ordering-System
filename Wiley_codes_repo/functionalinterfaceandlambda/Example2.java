package functionalinterfaceandlambda;

interface Scannable{
    void scan(String filename);
}

interface Calculator{
    int calculate(int a , int b);
}
 //Lambda expression to get the length of a string
//Lambda expression to find the max of two numbers
//Lambda expression to check if a string is not blank
interface StringOperation{
    boolean operation(String str);

interface StringLengthOperation{
    int operation(String str);
}
}


public class Example2 {
    public static void main(String[] args) {
        Scannable scannable = (filename) -> System.out.println("Scanning..." + filename);
        //type inference there is no need to write type
        scannable.scan("MyFile.txt");

        Calculator calculator = (a, b) -> a + b;
        int result = calculator.calculate(2, 3);
        System.out.println(result);

        Calculator calc = (a, b) -> a > b ? a : b;
        int maxre = calculator.calculate(2, 3);
        System.out.println(maxre);

        StringOperation checkBlank = str -> str.isBlank();
        System.out.println(checkBlank.operation(" "));

        StringOperation.StringLengthOperation checkLength = str -> str.length();
        System.out.println(checkLength.operation("Taniya"));
    }
}

