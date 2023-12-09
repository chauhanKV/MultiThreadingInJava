package thread.poc.demo;

public class Signal {
    private boolean stop;

    public synchronized boolean getStop()
    {
        return stop;
    }

    public synchronized void setStop(boolean value)
    {
        this.stop = value;
    }
}
