package per.yang.zk;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author songbao.yang
 * @date 2018/5/10
 */
public class DistributedDiscovery {
    private List<DistributedServer> servers = Lists.newArrayList();
    private static final String PATH = "/discovery/distributed_services";
    private CuratorFramework client = null;
    private ServiceDiscovery<DistributedService> serviceDiscovery = null;

    public DistributedDiscovery(){
        init();
    }
    public void init(){
        client = CuratorFrameworkFactory.newClient("l-zk1.plat.dev.cn6.qunar.com:2181",
                new ExponentialBackoffRetry(1000, 3));
        client.start();

        JsonInstanceSerializer<DistributedService> serializer = new
                JsonInstanceSerializer<DistributedService>(DistributedService.class);
        serviceDiscovery = ServiceDiscoveryBuilder.builder(DistributedService.class)
                .client(client)
                .basePath(PATH)
                .serializer(serializer)
                .build();
        try {
            serviceDiscovery.start();
        } catch (Exception e) {
            System.out.println("serviceServiceDiscovery.start() with an exception." +
                    e.getMessage());
            e.printStackTrace();
        }
    }

    public void addService(String serviceName,
                           String address,
                           String info) throws Exception {
        DistributedServer server = new DistributedServer(client, PATH, serviceName,address,  info);
        servers.add(server);
        server.start();

        System.out.println(serviceName + " added");
    }

    public void listServices() throws Exception {
        Collection<String> serviceNames = serviceDiscovery.queryForNames();
        System.out.println(serviceNames.size() + " type(s)");
        for (String serviceName : serviceNames) {
            Collection<ServiceInstance<DistributedService>> instances = serviceDiscovery.queryForInstances(serviceName);
            System.out.println(serviceName);
            for(ServiceInstance<DistributedService> instance: instances){
                outputInstance(instance);
            }
        }
    }
    private static void outputInstance(ServiceInstance<DistributedService> instance) {
        System.out.println("\t address: " + instance.getPayload().getAddress()+ ", info: " +
                instance.getPayload().getInfo()+ ": " + instance.buildUriSpec());
    }
    public List<DistributedServer> getServers() {
        return servers;
    }
}
