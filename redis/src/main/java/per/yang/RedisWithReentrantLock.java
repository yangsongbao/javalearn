package per.yang;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisWithReentrantLock {

    private ThreadLocal<Map<String, Integer>> lockers = new ThreadLocal<>();
    private Jedis jedis;


    public RedisWithReentrantLock(Jedis jedis) {
        this.jedis = jedis;
    }

    private Map<String, Integer> currrenntLockers() {
        Map<String, Integer> refs = lockers.get();
        if (refs == null){
            lockers.set(new HashMap<>());
        }
        return lockers.get();
    }

    public boolean lock(String key){
        Map<String, Integer> refs = currrenntLockers();
        Integer refCnt = refs.get(key);
        if (refCnt != null){
            refs.put(key, refCnt + 1);
            return true;
        }
        boolean ok = this._lock(key);
        if (!ok){
            return false;
        }
        refs.put(key, 1);
        return true;
    }

    public boolean unlock(String key) {
        Map<String, Integer> refs = currrenntLockers();
        Integer refCnt = refs.get(key);
        if (refCnt == null){
            return false;
        }
        if (refCnt > 1){
            refs.put(key, refCnt - 1);
            return true;
        }
        refs.remove(key);
        this._unlock(key);
        return true;
    }

    private boolean _lock(String key) {
        return jedis.set(key, "", "nx", "ex", 5L) != null;
    }

    private void  _unlock(String key) {
        jedis.del(key);
    }


}
