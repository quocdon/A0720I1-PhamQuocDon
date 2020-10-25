package exercises.my_Queue;

public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.deQueue()); //null
        myQueue.enQueue(1);
        System.out.println(myQueue.deQueue().data); //node1.data = 1
        myQueue.displayQueue(); //null
        myQueue.enQueue(1);
        myQueue.displayQueue(); // 1
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.enQueue(5);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.displayQueue(); // 3 4 5
    }
}
