package Labs.Lab2;

import Labs.Lab1.CatchUp;

import java.util.Scanner;

public class Lab2_main {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nОберіть варіант для запуску:");
        System.out.println("0. Exit");
        System.out.println("1. Async Example (Problem)");
        System.out.println("2. Sync Example (Solution)");
        System.out.println("3. Two unconnected counters. Without lock. (Problem)");
        System.out.println("4. Two unconnected counters. With lock. (Solution)");
        System.out.print("Enter: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                asyncExample();
                run();
                break;
            case 2:
                syncExample();
                run();
                break;
            case 3:
                twoUnconnectedCountersWithoutLock();
                run();
                break;
            case 4:
                twoUnconnectedCounters1();
                run();
                break;
            case 0:
                break;
            default:
                System.out.println("Невідомий вибір.");
                run();
                break;
        }

        scanner.close();

    }

    public void asyncExample(){
        Counter counter = new Counter();

        System.out.println("Not synchronized:");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    counter.increment();
                    System.out.println("Thread 1 increment: " + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    counter.increment();
                    System.out.println("Thread 2 increment: " + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void syncExample() {
        Counter counter = new Counter();

        System.out.println("Synchronized:");
        Thread syncThread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    counter.incrementSync();
                    System.out.println("Thread 1 increment: " + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread syncThread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    counter.incrementSync();
                    System.out.println("Thread 2 increment: " + counter.value());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        syncThread1.start();
        syncThread2.start();

        try {
            syncThread1.join();
            syncThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void twoUnconnectedCountersWithoutLock(){
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementCount1();
                    System.out.println("Thread 1 increment (value1): " + counter.value1());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementCount1();
                    System.out.println("Thread 2 increment (value1): " + counter.value1());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementCount2();
                    System.out.println("Thread 3 increment (value2): " + counter.value2());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementCount2();
                    System.out.println("Thread 4 increment (value2): " + counter.value2());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void twoUnconnectedCounters1() {
        System.out.println("Async counters, Sync increment and decrement.\n" +
                "Problem: synchronization between threads does not ensure sequence, " +
                "methods may be called twice due to the unconfigured order in which the counter methods are run.\n");

        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementLockCount1();
                    System.out.println("Thread 1 increment (value1): " + counter.value1());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementLockCount1();
                    System.out.println("Thread 2 increment (value1): " + counter.value1());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementLockCount2();
                    System.out.println("Thread 3 increment (value2): " + counter.value2());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementLockCount2();
                    System.out.println("Thread 4 increment (value2): " + counter.value2());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void twoUnconnectedCounters2(){
        System.out.println("Sync counters, Sync increment and decrement.:");

        TwoStreamSyncCounter counter = new TwoStreamSyncCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementCount1();
                    System.out.println("Thread 1 increment (value1): " + counter.value1());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.decrementCount1();
                    System.out.println("Thread 2 decrement (value1): " + counter.value1());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.incrementCount2();
                    System.out.println("Thread 3 increment (value2): " + counter.value2());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    counter.decrementCount2();
                    System.out.println("Thread 4 decrement (value2): " + counter.value2());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
