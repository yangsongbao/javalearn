package per.yang.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author songbao.yang
 */
public class CountDownLatchTest1 {

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(n);

        for (int i = 0; i < n; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }
        doSomethingElse();
        startSignal.countDown();
        doSomethingElse();
        doneSignal.await();
        System.out.println("-------------done-------------");
    }

    private static void doSomethingElse() {
        System.out.println("--------doSomethingElse");
    }
}
