package Labs.Lab1;

public class HelloThread extends Thread {
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);
            }
            catch(InterruptedException e){}
        }
        System.out.println("HelloThread!");
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }
}
