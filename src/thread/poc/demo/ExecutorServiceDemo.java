package thread.poc.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println(availableProcessors);
        // for single thread pool all tasks are executing in this thread so it takes around 145ms to execute all the tasks
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Now when I create a thread pool of 5 threads

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 100 ; i++)
        {
            executorService.submit(new Task("Task" + i));
        }
        executorService.submit(new Task("Test"));
        executorService.shutdown();


        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();

        System.out.println("Total Time taken : " + (end - start) + "ms");
    }
}
