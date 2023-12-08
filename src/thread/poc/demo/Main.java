package thread.poc.demo;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread mythread = new MyThread();
        mythread.setName("Child-Thread-01");
        mythread.start();
        // mythread.run();

        try {
            mythread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done");
    }
}
