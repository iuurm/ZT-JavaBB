package P08_MultiThreading.L72_1_SynchronizedBlock;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableImpl1 runnable = new MyRunnableImpl1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    static int count = 0;
}

class MyRunnableImpl1 implements Runnable {

    private void sayHi() {
        System.out.println("Hi!");
    }

    private void increment() {
        sayHi();

        // Синхронизация будет вестись по объекту runnable
        synchronized (this) {
            Counter.count++;
            System.out.print(Counter.count + " ");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}

