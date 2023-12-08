package thread.poc.demo;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 1000;
        long keepAliveTime = 5000;

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(500));

        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 10000 ; i++)
        {
            threadPoolExecutor.submit(new Task("Task" + i));
        }
        //threadPoolExecutor.submit(new Task("Test"));
        threadPoolExecutor.shutdown();


        try {
            threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();

        System.out.println("Total Time taken : " + (end - start) + "ms");
    }
}
