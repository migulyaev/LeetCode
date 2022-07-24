class H2O {
    
    private ReentrantLock lock = new ReentrantLock();
    private Condition printHydro = lock.newCondition();
    private Condition printOxygen = lock.newCondition();
    private int hCounter = 0;
    private int oCounter = 1;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            lock.lock();
            while (oCounter == 0) {
                printHydro.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hCounter++;
            if (hCounter == 2) {
                oCounter = 0;
                printOxygen.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            lock.lock();
            while (hCounter != 2) {
                printOxygen.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            oCounter = 1;
            hCounter = 0;
            printHydro.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

// class H2O {
    
//     private Semaphore hydrogen, oxygen;

//     public H2O() {
//         hydrogen = new Semaphore(2);
//         oxygen = new Semaphore(0);
//     }

//     public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
// 		hydrogen.acquire();
//         // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//         releaseHydrogen.run();
//         oxygen.release();
//     }

//     public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//         oxygen.acquire(2);
//         // releaseOxygen.run() outputs "O". Do not change or remove this line.
// 		releaseOxygen.run();
//         hydrogen.release(2);
//     }
// }