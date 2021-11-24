import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterTask {
    private Lock myLock = new ReentrantLock();
    private int myCounter = 0;

    public void increaseMyCounter(){
        myLock.lock();
        myCounter++;
        myLock.unlock();
    }

    public int getMyCounter(){
        return myCounter;
    }

    public static void main(String[] args) {
        CounterTask counterTask = new CounterTask();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is started");
                counterTask.increaseMyCounter();
                System.out.println(Thread.currentThread().getName() + " the counter has been increased by " + counterTask.getMyCounter());
            }).start();
        }
    }
}


