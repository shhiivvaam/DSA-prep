class shhiivvaam {
    private int[] data;
    private int front;
    private int size;

    public shhiivvaam() {
        this.data = new int[10];
        this.size = 0;
    }

    public shhiivvaam(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.data.length;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(int item) throws Exception {
        if (isFull()) {
            throw new Exception("bhai pet bhara hua hai Queue ka");
        }

        int index = (this.size + this.front) % this.data.length; // * This handles the Circular Queue functionalities
        // int index = this.size + this.front; //* this handles the case where linear
        // queue is being implemented
        this.data[index] = item;
        // this.data[this.size] = item; //* we have eliminated this because: while
        // remove elements from thhe Queuee(dequeue() step) > we are reducing the size,
        // and so if the size reduces its actual value, so if immediately an enqueue os
        // applied to the Queue after applying dequeue, this given data will be inserted
        // in some wrong place
        this.size++;
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Bhai waise hi pet khalli hai Queue ka");
        }

        int val = this.data[this.front];
        this.front = (this.front + 1) % this.data.length; // * Handles the case of circular Queue
        this.size--;
        return val;
    }

    public int getFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Bhai Queue ka pet toh khalli pada hai!!1");
        }

        return this.data[this.front];
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {

            int index = (this.front + i) % this.data.length;
            System.out.print(this.data[index] + " ");
        }
        System.out.println();
    }
}

public class Queuesshhiivvaam {
    public static void main(String[] args) throws Exception {
        shhiivvaam queue = new shhiivvaam(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        // queue.enqueue(5);

        queue.display();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.display();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.display();
    }
}
