class Foo {
    
    private CountDownLatch firstCountDown = new CountDownLatch(1);
    private CountDownLatch secondCountDown = new CountDownLatch(1);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstCountDown.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstCountDown.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondCountDown.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondCountDown.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}