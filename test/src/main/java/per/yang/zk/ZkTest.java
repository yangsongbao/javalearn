package per.yang.zk;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

/**
 *
 * @author songbao.yang
 * @date 2018/5/10
 */
public class ZkTest {

    public static void main(String[] args) throws Exception {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("l-zk1.plat.dev.cn6.qunar.com:2181", retryPolicy);
        client.start();
        List<String> strings = client.getChildren().forPath("/yangsongbao");
        System.out.println(strings);
    }


}
