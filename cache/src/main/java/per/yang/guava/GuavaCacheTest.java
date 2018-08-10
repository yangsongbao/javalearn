package per.yang.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.graph.Graph;

import java.security.Key;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by songbao.yang on 2017/7/13.
 */
public class GuavaCacheTest {


    public static void main(String[] args) {

        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .refreshAfterWrite(1, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("load key : " + key);
                        return key + "test";
                    }
                });

        try {
            String str = graphs.get("yangsongbao");
            System.out.println("end1");
            String str2 = graphs.get("yangsongbao");
            System.out.println("end2");
            Thread.sleep(12000);
            String str3 = graphs.get("yangsongbao");
            System.out.println("end3");

            Thread.sleep(2000);
            String str4 = graphs.get("yangsongbao");
            System.out.println("end4");

            System.out.println("-----------------");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
