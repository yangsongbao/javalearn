package per.yang.zk;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 *
 * @author songbao.yang
 * @date 2018/5/10
 */
@JsonRootName("services")
public class DistributedService {
    private String address ;
    private String info;

    public DistributedService(){
        this("", "");
    }
    public DistributedService(String address, String info){
        this.address = address;
        this.info = info;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
