class BoundedBlockingQueue {
    
    private LinkedList<Integer> queueImpl;
    private Semaphore dequeue, enqueue;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queueImpl = new LinkedList<>();
        dequeue = new Semaphore(0);
        enqueue = new Semaphore(capacity);
    }
    
    public void enqueue(int element) throws InterruptedException {
        enqueue.acquire();
        queueImpl.addLast(element);
        dequeue.release();
    }
    
    public int dequeue() throws InterruptedException {
        dequeue.acquire();
        int value = queueImpl.removeFirst();
        enqueue.release();
        return value;
    }
    
    public int size() {
        return queueImpl.size();
    }
}