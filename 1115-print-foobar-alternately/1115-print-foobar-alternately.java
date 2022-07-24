class FooBar {
    private int n;
    private AtomicInteger counter = new AtomicInteger(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (counter.get() != 0) {
                // wait
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            counter.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while (counter.get() != 1) {
                // wait
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            counter.decrementAndGet();
        }
    }
}