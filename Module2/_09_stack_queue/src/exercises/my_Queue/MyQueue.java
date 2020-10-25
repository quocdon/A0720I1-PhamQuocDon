package exercises.my_Queue;

public class MyQueue {
    private Node front;
    private Node rear;

    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (this.front == null) {
            this.front = temp;
            this.rear = temp;
            this.front.link = rear;
            this.rear.link = front;
        } else {
            this.rear.link = temp;
            this.rear = temp;
            this.rear.link = this.front;
        }
    }

    public Node deQueue() {
        if (front == null) {
            return null;
        } else if (front == rear) {
            Node temp = front;
            front = null;
            rear = null;
            return temp;
        } else {
            Node temp = front;
            front = front.link;
            rear.link = front;
            return temp;
        }
    }

    public void displayQueue() {
        Node temp = front;
        if (front == null){
            System.out.println("null");
        } else {
            while (temp.link != front) {
                System.out.println(temp.data);
                temp = temp.link;
            }
            System.out.println(rear.data);
        }
    }
}
