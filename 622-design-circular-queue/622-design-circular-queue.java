class MyCircularQueue {

    int arr[];
    int front;
    int rear;
    int size;
    
    public MyCircularQueue(int k) {
        arr = new int[k];
        size = k;
        front = 0;
        rear = 0;
        Arrays.fill(arr, -1);
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        arr[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        arr[front] = -1;
        front = (front + 1) % size;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        
        return arr[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        
        if (rear - 1 >= 0)
        return arr[rear-1];
        else return arr[size - 1];
    }
    
    public boolean isEmpty() {
        if (front == rear && arr[front] == -1) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if (front == rear && arr[front] != -1) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */