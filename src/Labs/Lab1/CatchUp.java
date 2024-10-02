package Labs.Lab1;

public class CatchUp {
    static Rabbit rabbit;

    public void run() {
        rabbit = new Rabbit();
        rabbit.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("тупотіння!");
        }

        if (rabbit.isAlive()) {
            try {
                rabbit.join();
            } catch (InterruptedException e) {
            }
            System.out.println("Останнім був заєць!");
        } else {
            System.out.println("Останнім був ведмідь!");
        }

        System.out.println("Кінець квача!");
    }
}
