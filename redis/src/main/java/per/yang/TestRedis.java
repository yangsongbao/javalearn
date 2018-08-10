package per.yang;

import redis.clients.jedis.Jedis;

/**
 *
 * @author songbao.yang
 * @date 2017/12/23
 */
public class TestRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.86.53.225", 6379);

        System.out.println();
    }
}
