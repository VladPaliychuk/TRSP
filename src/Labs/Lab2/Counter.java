package Labs.Lab2;

import static java.lang.Thread.sleep;

public class Counter {

    private int c = 0;

    private int count1 = 0;
    private int count2 = 0;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void increment() throws InterruptedException {
        int a;
        sleep(100);
        a = c;
        a++;
        c = a;
    }
    public void decrement() throws InterruptedException {
        int a;
        sleep(100);
        a = c;
        a--;
        c = a;
    }

    public synchronized void incrementSync() throws InterruptedException {
        int a;
        sleep(100);
        a = c;
        a++;
        c = a;
    }
    public synchronized void decrementSync() throws InterruptedException {
        int a;
        sleep(100);
        a = c;
        a--;
        c = a;
    }

    public void incrementCount1() throws InterruptedException {
            int a;
            sleep(100);
            a = count1;
            a++;
            count1 = a;
    }

    public void decrementCount1() throws InterruptedException {
            int a;
            sleep(100);
            a = count1;
            a--;
            count1 = a;
    }

    public void incrementCount2() throws InterruptedException {
            int a;
            sleep(100);
            a = count2;
            a++;
            count2 = a;
    }

    public void decrementCount2() throws InterruptedException {
            int a;
            sleep(100);
            a = count2;
            a--;
            count2 = a;
    }

    public void incrementLockCount1() throws InterruptedException {
        synchronized (lock1) {
            int a;
            sleep(100);
            a = count1;
            a++;
            count1 = a;
        }
    }

    public void decrementLockCount1() throws InterruptedException {
        synchronized (lock1) {
            int a;
            sleep(100);
            a = c;
            a--;
            c = a;
        }
    }

    public void incrementLockCount2() throws InterruptedException {
        synchronized (lock1) {
            int a;
            sleep(100);
            a = count2;
            a++;
            count2 = a;
        }
    }

    public void decrementLockCount2() throws InterruptedException {
        synchronized (lock2) {
            int a;
            sleep(100);
            a = c;
            a--;
            c = a;
        }
    }

    public int value() {
        return c;
    }

    public int value1() {
        return count1;
    }

    public int value2() {
        return count2;
    }
}
