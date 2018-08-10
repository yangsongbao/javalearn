package per.yang.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author songbao.yang
 */
public class ReentrantLockTest {

    private  final ReentrantLock lock = new ReentrantLock();
    private int i = 0;
    public void increase() {
        lock.lock();
        try {
            for (int j = 0; j < 1000; j++) {
                i++;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 100;
        ReentrantLockTest lockTest = new ReentrantLockTest();
        for (int i = 0; i < n; i++) {
            new Thread(() -> lockTest.increase()).start();
        }
        Thread.sleep(5000);
        System.out.println(lockTest.getI());
    }
}
