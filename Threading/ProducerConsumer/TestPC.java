package Threading.ProducerConsumer;

class SharedResouce {
    int x;
    boolean produced;

    public synchronized void produce() {
        while (produced) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        x++;
        produced = true;
        notify();
    }

    public synchronized int consume() {
        while (!produced) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Consume : " + x);
        produced = false;
        notify();
        return x;
    }

}

class Consumer extends Thread {
    private SharedResouce sharedResouce;

    Consumer(SharedResouce s) {
        this.sharedResouce = s;
    }

    @Override
    public void run() {
        while (true) {
            sharedResouce.consume();
        }
    }
}

class Producer extends Thread {
    private SharedResouce sharedResouce;

    Producer(SharedResouce s) {
        this.sharedResouce = s;
    }

    @Override
    public void run() {
        while (true) {
            sharedResouce.produce();
        }
    }
}

public class TestPC {
    public static void main(String[] args) {
        SharedResouce sharedResouce = new SharedResouce();

        Producer producer = new Producer(sharedResouce);
        Consumer consumer = new Consumer(sharedResouce);

        producer.start();
        consumer.start();
    }
}