package exercises.my_Queue;

public class TestMyQueue {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.deQueue()); //null
        myQueue.enQueue(node1);
        System.out.println(myQueue.deQueue().data); //node1.data = 1
        myQueue.displayQueue(); //null
        myQueue.enQueue(node1);
        myQueue.displayQueue(); // 1
        myQueue.enQueue(node2);
        myQueue.enQueue(node3);
        myQueue.enQueue(node4);
        myQueue.enQueue(node5);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.displayQueue(); // 3 4 5
    }
}
