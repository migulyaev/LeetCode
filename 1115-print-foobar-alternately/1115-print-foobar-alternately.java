class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition printFooCondition = lock.newCondition();
    private Condition printBarCondition = lock.newCondition();
    private boolean isBarPrinted = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (!isBarPrinted) {
                    printFooCondition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                isBarPrinted = false;
                printBarCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                while (isBarPrinted) {
                    printBarCondition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isBarPrinted = true;
                printFooCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}