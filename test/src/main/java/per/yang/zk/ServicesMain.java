package per.yang.zk;

import java.lang.management.ManagementFactory;

/**
 *
 * @author songbao.yang
 * @date 2018/5/10
 */
public class ServicesMain {

    public static void main(String[] args) throws Exception {
        DistributedDiscovery dd = new DistributedDiscovery();

        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.printf("getRuntimeMXBean mame: %s", name);
        int index = name.indexOf('@');
        // pid as the service name .
        dd.addService(name.substring(0, index), "192.168.11.2:8089", "cluster node 1");
        dd.addService(name, "192.168.11.3:8089", "cluster node 2");
        dd.listServices();
//        Callable<Boolean > callable = new Callable<Boolean>(){
//            @Override
//            public Boolean call() throws Exception{
//                System.out.println();
//                boolean isStop = true;
//                while(isStop){
//                    //wait 10 seconds
//                    Thread.sleep(10000);
//                    isStop = false;
//                }
//                return true;
//            }
//        };
//        callable.call();
        Thread.currentThread().sleep(10000);
        dd.listServices();
    }
}
