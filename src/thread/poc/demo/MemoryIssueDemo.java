package thread.poc.demo;

public class MemoryIssueDemo {
    public static void main(String[] args) {
        Signal signal = new Signal();

        Thread thread1 = new Thread(() -> {
            while(!signal.getStop()) {
                System.out.println("Executing thread : " + Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            signal.setStop(true);
            System.out.println("Setting Signal to True : " + Thread.currentThread().getName());
        });
        thread2.start();
        thread1.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("done");
    }
}
