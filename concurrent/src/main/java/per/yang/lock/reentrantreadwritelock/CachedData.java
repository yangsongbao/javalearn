package per.yang.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {

    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCacheData(){
        rwl.readLock().lock();
        if (!cacheValid){
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                if (!cacheValid){
                    data = "123";
                    cacheValid = true;
                }
                rwl.readLock().lock();
            } finally {
                rwl.readLock().unlock();
            }
        }

        try {
            use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }

    private void use(Object data) {

    }


}
