package per.yang.lock.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    final CyclicBarrier cyclicBarrier;

    final int MAX_TASK;

    public CyclicBarrierTest(int cnt) {
        this.cyclicBarrier = new CyclicBarrier(cnt + 1);
        this.MAX_TASK = cnt;
    }

    public void doWork(final Runnable work){
        new Thread(() -> {
            work.run();
            try {
                int index = cyclicBarrier.await();
                doWithIndex(index);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
                return;
            }
        }).start();
    }

    private void doWithIndex(int index) {
        if (index == MAX_TASK / 3){
            System.out.println("Left 30%");
        } else if (index == MAX_TASK / 2){
            System.out.println("Left 50%");
        } else if (index == 0){
            System.out.println("run over");
        }
    }

    public void waitForNext(){
        try {
            doWithIndex(cyclicBarrier.await());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) {
        final int count = 10;
        CyclicBarrierTest barrierTest = new CyclicBarrierTest(count);
        for (int i = 0; i < 100; i++) {
            barrierTest.doWork(() -> {
                System.out.println("~~~~~~~~~~~~~~");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            });
            if ((i + 1) % count == 0){
                barrierTest.waitForNext();
            }
        }
    }
}
