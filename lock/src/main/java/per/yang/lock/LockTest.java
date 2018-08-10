package per.yang.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author songbao.yang
 */
public class LockTest {

    private static AtomicInteger increaser = new AtomicInteger(0);
    private static final int THREADS_COUNTS = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNTS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
            System.out.println("thread " + i + " start, increaser: " + increaser);
        }

        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(increaser);
    }

    private static int increase(){
        return increaser.incrementAndGet();
    }
}
