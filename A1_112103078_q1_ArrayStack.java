public class A1_112103078_q1_ArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public A1_112103078_q1_ArrayStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // initialize top to -1 indicating an empty stack
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed: " + value);
        } else {
            System.out.println("Stack overflow. Cannot push element.");
        }
    }

    public int pop() {
        if (top >= 0) {
            int poppedValue = stackArray[top--];
            System.out.println("Popped: " + poppedValue);
            return poppedValue;
        } else {
            System.out.println("Stack underflow. Cannot pop element.");
            return -1; // Assuming -1 indicates stack underflow
        }
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Assuming -1 indicates an empty stack
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        A1_112103078_q1_ArrayStack stack = new A1_112103078_q1_ArrayStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop(); // Attempting to pop from an empty stack

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
