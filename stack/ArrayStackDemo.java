package stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if(isFull()) {
            return;
        }
        stack[++top] = num;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        return stack[top--];
    }

    public void list() {
        if(isEmpty()) {
            return;
        }
        for (int i = top; i > 0; i--) {
            System.out.println(stack[top]);
        }
    }
}