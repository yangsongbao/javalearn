package per.yang.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private CountDownLatch startSignal;
    private CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWorker();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            doneSignal.countDown();
        }
    }

    private void doWorker() {
        System.out.println("--------doWorker");
    }
}
