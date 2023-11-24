package Stack;
class Stack {
    int capacity;
    int top;
    Object[] stack;

    Stack(int cap) {
        this.capacity = cap;
        this.stack = new Object[cap];
        this.top = -1;
    }

    // push operation
    public void push(Object item) {
        if (isFull()) {
            throw new RuntimeException("Stack is Fully!!");
        } else {
            this.top++;
            this.stack[top] = item;
        }
    }

    // pop operation

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty!!");
        }
        Object item = stack[top];
        top--;
        System.out.println("Poped Item:" + item);
        return item;
    }

    // Check for stack empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // Check for stack Full
    public Boolean isFull() {
        return top == capacity - 1;
    }
}

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(9);
        stack.push("Hi");

        stack.pop();
        stack.pop();
        // stack.pop();

        stack.push("Hello");
        stack.push(3.14);
        stack.push(true);
        stack.push("Hi");
    }
}
