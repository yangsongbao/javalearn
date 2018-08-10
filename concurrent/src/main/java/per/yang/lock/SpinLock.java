package per.yang.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class SpinLock {
    private AtomicReference<Thread> sign =new AtomicReference<Thread>();

    public void lock(){
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)){

        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }

}
