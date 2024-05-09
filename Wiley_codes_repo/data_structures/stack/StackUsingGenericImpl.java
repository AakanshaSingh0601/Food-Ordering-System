package data_structures.stack;

public class StackUsingGenericImpl {

    public static void main(String[] args) {

        UsingGeneric<Long> longUsingGeneric = new UsingGeneric<>(5);
        longUsingGeneric.push(5L);
        longUsingGeneric.push(10L);
        System.out.println(longUsingGeneric.pop());

        UsingGeneric<String> stringUsingGeneric = new UsingGeneric<>(2);
        stringUsingGeneric.push("Taniya");
        stringUsingGeneric.push("Naman");
        System.out.println(stringUsingGeneric.pop());

    }
}