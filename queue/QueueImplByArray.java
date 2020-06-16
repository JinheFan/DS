package queue;

public class QueueImplByArray {
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        System.out.println(arrayQueue.poll());
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = -1;    //指向队列头的前一个位置
        this.rear = -1;     //指向队列尾的数据 （就是队列的最后一个数据）
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void add(int num) throws Exception {
        if(isFull()) {
            throw new Exception();
        }
        array[++rear] = num;
    }

    public int poll() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        return array[++front];
    }

    public void iterate() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        for(int num : array) {
            System.out.println(num);
        }
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        return array[front + 1];
    }
}
