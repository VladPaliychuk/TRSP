import Labs.Lab1.CatchUp;
import Labs.Lab1.HelloRunnable;
import Labs.Lab1.HelloThread;
import Labs.Lab2.Lab2_main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть варіант для запуску:");
        System.out.println("1. Lab1 - CatchUp");
        System.out.println("2. Lab2 - Counter");

        System.out.print("Ввід: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                HelloThread helloThread = new HelloThread();
                helloThread.start();

                HelloRunnable helloRunnable = new HelloRunnable();
                (new Thread(helloRunnable)).start();

                CatchUp catchUp = new CatchUp();
                catchUp.run();
                break;
            case 2:
                Lab2_main lab2_main = new Lab2_main();
                lab2_main.run();
                break;
            default:
                System.out.println("Невідомий вибір.");
                break;
        }

        scanner.close();
    }
}