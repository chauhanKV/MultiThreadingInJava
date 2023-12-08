package thread.poc.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceConditionDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        VisitorCountTask visitorCountTask = new VisitorCountTask();

        for(int i = 0 ; i < 100000 ; i++)
        {
            threadPool.submit(visitorCountTask);
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(visitorCountTask);
    }
}
