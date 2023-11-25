package Threading.PriorityThread;


class CounterThread extends Thread {
    private static int counter = 0;

    CounterThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
       for(int i=0;i<50;i++) {
            counter++;
            System.out.println(getName() + " Counter: " + counter);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class MainThread {
    public static void main(String[] args) {
        CounterThread normalPriorityCounterThread = new CounterThread("NormalPriorityThread", Thread.NORM_PRIORITY);
        CounterThread lowPriorityCounterThread = new CounterThread("LowPriorityThread", Thread.MIN_PRIORITY);
        CounterThread highPriorityCounterThread = new CounterThread("HighPriorityThread", Thread.MAX_PRIORITY);

        normalPriorityCounterThread.start();
        lowPriorityCounterThread.start();
        highPriorityCounterThread.start();

        try {
           highPriorityCounterThread.join();
           lowPriorityCounterThread.join();
           normalPriorityCounterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished Main Thread");

    }
}
