class FooBar {
    private int n;
    volatile boolean isBarNext = false;
    private static final Object mon = new Object();
    public FooBar(int n) {
        this.n = n;
        
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(mon) {
                while(isBarNext == true) {
                    mon.wait();
                }
        	    // printFoo.run() outputs "foo". Do not change or remove this line.
        	    printFoo.run();
                isBarNext = true;
                notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(mon) {
                while(isBarNext == false) {
                    mon.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                isBarNext = false;
                notifyAll();
            }
        }
    }
}
