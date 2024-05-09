package functionalinterfaceandlambda;

@FunctionalInterface
interface Printable{
    void show();
}
public class LambdaExpressionsDemo {
    public static void main(String[] args) {
        //below Lamda expression is written it reduces line of codes but it is less readable.
        //implementation of FunctionalInterface is Lambda Expression.
        //Functional Interface : An Interface with only one abstract method.
        Printable printable = ()-> System.out.println("Hello Everyone!");
        printable.show();
    }
}
