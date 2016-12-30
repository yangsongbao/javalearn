package state;

/**
 *
 * Created by songbao.yang on 2016/12/10.
 */
public class ThreadWAITING {

    public static void main(String[] args) {
        final Object lock = new Object();

        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("wait in");
                        lock.wait();
                        System.out.println("wait over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "WAITING-Thread-A");

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("sleep in");
                        Thread.sleep(20000);
                        System.out.println("sleep over");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        }, "WAITING-Thread-B");
        threadB.start();
        try {
            System.out.println("main sleep in");
            Thread.sleep(10000);
            System.out.println("main sleep out");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }
}
