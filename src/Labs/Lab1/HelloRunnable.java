package Labs.Lab1;

import static java.lang.Thread.sleep;

public class HelloRunnable implements Runnable {
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);
            }
            catch(InterruptedException e){}
        }
        System.out.println("HelloRunnable!");
    }

    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
    }
}
