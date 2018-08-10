package per.yang.lock.reentrantreadwritelock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWDictionary {

    private final Map<String, Data> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Data getData(String key){
        r.lock();
        try {
            return m.get(key);
        }finally {
            r.unlock();
        }
    }

    public Object[] allKeys(){
        r.lock();
        try {
            return m.keySet().toArray();
        } finally {
            r.unlock();
        }
    }

    public Data put(String key, Data data){
        w.lock();
        try {
            return m.put(key, data);
        } finally {
            w.unlock();
        }
    }

    public void clear(){
        w.lock();
        try {
            m.clear();
        } finally {
            w.unlock();
        }
    }

}
