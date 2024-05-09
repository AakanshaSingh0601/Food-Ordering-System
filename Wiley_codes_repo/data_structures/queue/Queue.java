package data_structures.queue;

public class Queue<T> {
    private int maxSize;
    private T[] queueArray;
    private int front;
    private int rear;
    private int itemCount;

    public Queue(int maxSize){
        this.maxSize=maxSize;
        queueArray=(T[])new Object[maxSize];
        front=0;
        rear=-1;
        itemCount=0;
    }

    public boolean insert(T item){
        if(isFull()){
            throw new RuntimeException("Queue is Full");
        }

        rear++;
        queueArray[rear]=item;
        itemCount++;
        return true;
    }

    public T remove(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty Please Insert some item..");
        }
        T item = queueArray[front];
        front++;
        itemCount--;
        return item;
    }

    public boolean isEmpty(){
        return itemCount==0;
    }

    public boolean isFull(){
         return itemCount==maxSize;
    }

    public T peek(){
         return queueArray[front];
    }

}
