package queue;

public class QueueImplByCircleArray {
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        System.out.println(arrayQueue.poll());
    }
}

class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int num) throws Exception {
        if(isFull()) {
            throw new Exception();
        }
        array[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int poll() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        int res = array[front];
        front = (front + 1) % maxSize;
        return res;
    }

    public void iterate() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        for(int i = front; i < front + size(); i++) {
            System.out.println(array[i]);
        }
    }

    private int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        return array[front];
    }
}
