package data_structures.queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(5);
        queue.insert("Karan");
        queue.insert("Ram");
        queue.insert("Shyam");
        queue.insert("John");
        queue.insert("Sid");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.peek());

    }
}
