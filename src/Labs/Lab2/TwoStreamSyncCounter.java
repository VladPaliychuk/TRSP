package Labs.Lab2;

public class TwoStreamSyncCounter {
    private int count1 = 0;
    private int count2 = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private boolean isTurn1 = true;
    private boolean isTurn2 = true;

    public void incrementCount1() throws InterruptedException {
        synchronized (lock1) {
            while (!isTurn1) {
                lock1.wait();
            }
            Thread.sleep(150);
            count1++;
            isTurn1 = false;
            lock1.notifyAll();
        }
    }

    public void decrementCount1() throws InterruptedException {
        synchronized (lock1) {
            while (isTurn1) {
                lock1.wait();
            }
            Thread.sleep(100);
            count1--;
            isTurn1 = true;
            lock1.notifyAll();
        }
    }

    public void incrementCount2() throws InterruptedException {
        synchronized (lock2) {
            while (!isTurn2) {
                lock2.wait();
            }
            Thread.sleep(150);
            count2++;
            isTurn2 = false; // Передаємо чергу декрементору
            lock2.notifyAll();
        }
    }

    public void decrementCount2() throws InterruptedException {
        synchronized (lock2) {
            while (isTurn2) {
                lock2.wait(); // Чекаємо, поки черга не перейде до декремента count2
            }
            Thread.sleep(100);
            count2--;
            isTurn2 = true; // Передаємо чергу інкрементору
            lock2.notifyAll();
        }
    }

    public int value1() {
        synchronized (lock1) {
            return count1;
        }
    }

    public int value2() {
        synchronized (lock2) {
            return count2;
        }
    }
}
