package Threading.ProducerConsumer;
/*
package Threading.ProducerConsumer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResouce {
    int x;
    boolean produced;
    private final Lock lock = new ReentrantLock();

    public void produce() {
        synchronized (lock) {
            while (produced) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            x++;
            produced = true;
            lock.notify();
        }
    }

    public int consume() {
        synchronized (lock) {
            while (!produced) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("Consume : " + x);
            produced = false;
            lock.notify();
            return x;
        }

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



*/
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
