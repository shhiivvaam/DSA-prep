class shhiivvaam {
    private int data[];
    private int top;

    public shhiivvaam() {
        this.data = new int[10];
        this.top = 0;
    }

    public shhiivvaam(int capacity) {
        this.data = new int[capacity];
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public boolean isFull() {
        // return this.top == this.data.length;
        return this.top == this.data.length; // since the top is started from 0 based indexing
    }

    public void push(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Sun bey pgl hai kya, shhiivvaam k Stack ka pet bhar gya hai!!");
        }

        this.data[this.top] = item;
        top++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Aabe katayi pagal hi ho kya, shhiivvaam k Stack ka pet khalli pada hai!!");
        }

        top--;
        return this.data[this.top];
    }

    public int peek() {
        return this.data[this.top - 1]; // remember -> top-1 > does not actually change the top value, but top-- does
    }

    public int size() {
        return this.top;
    }

    public void display() {
        for (int i = 0; i < this.top; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
}

public class Stackshhiivvaam {
    public static void main(String[] args) throws Exception {
        shhiivvaam stack = new shhiivvaam(2);
        stack.push(0);
        stack.push(1);
        // stack.push(3);
        stack.display();
        stack.pop();
        stack.peek();
        stack.display();
    }
}
