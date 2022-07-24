class ZeroEvenOdd {
    private int n;
    private Semaphore zero, even, odd;
    private boolean printOdd = true;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        even = new Semaphore(0);
        odd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (printOdd) {
                odd.release();
            } else {
                even.release();
            }
            printOdd = !printOdd;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i+2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i+2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}