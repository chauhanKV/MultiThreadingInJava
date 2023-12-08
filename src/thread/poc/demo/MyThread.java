package thread.poc.demo;

public class MyThread extends Thread {
    @Override
    public void run()
    {
        System.out.println("Thread Running in : " + Thread.currentThread().getName());
    }
}
