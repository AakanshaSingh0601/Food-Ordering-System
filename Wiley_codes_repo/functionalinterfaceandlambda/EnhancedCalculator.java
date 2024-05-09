package functionalinterfaceandlambda;

public class EnhancedCalculator {
    static int calculate(int a , int b , Operation op){
        return op.operate(a,b);
    }

    public static void main(String[] args) {
        var sum = calculate(2,3,(a,b) -> a+b);
        var sub = calculate (3,4,(a,b) ->a-b);
        var mul = calculate(4,5,(a,b) ->a*b);
        var div = calculate(10,5,(a,b) ->a/b);
        var max = calculate(10,5,(a,b) ->a>b?a:b);
        System.out.println("Sum : "+sum);
        System.out.println("Substraction :  "+sub);
        System.out.println("Multiplication: "+mul);
        System.out.println("Division : "+div);
        System.out.println("Maximum number : "+max);

    }
}

interface Operation {
    int operate(int a, int b);
}
