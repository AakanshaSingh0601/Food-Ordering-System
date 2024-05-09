package data_structures.stack;

public class UsingGeneric<T> {

//    private int maxSize;
//    private long[] stackArray;
//    private int top;

    private int maxSize;
    private T[] stackArray;
    private int top;

    public UsingGeneric(int maxSize){
        this.maxSize=maxSize;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }

    public T push(T data){
        if(isFull()){
            throw new RuntimeException("Stack is already full");
        }
        top++;
        stackArray[top]=data;
        return data;
    }

    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is already empty");
        }
        T data = stackArray[top];
        top--;
        return data;
    }

    public T peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==(maxSize-1);
    }

}