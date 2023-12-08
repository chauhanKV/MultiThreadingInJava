package thread.poc.demo;

public class RunnableDemo {
    public static void main(String[] args) {
        Task task = new Task("Task-1");
        //task.run();

        // A single task can be shared among multiple threads
        Thread myThread = new Thread(task);
        myThread.start();

        Thread myThread1 = new Thread(task);
        myThread1.start();

        try {
            myThread.join();
            myThread1.join();
            task.run();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
