package thread.poc.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCountTask implements Runnable{
    private int count;
    private final AtomicInteger atomic = new AtomicInteger(0);

//    private synchronized void increment()
//    {
//        count++;
//    }

    private void increment()
    {
        count++;
        atomic.getAndIncrement();
    }

    @Override
    public void run() {
        increment();
    }

    @Override
    public String toString() {
        return "VisitorCountTask{" +
                "count=" + count +
                ", atomic=" + atomic +
                '}';
    }
}
