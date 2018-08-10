package per.yang.sync;

/**
 *
 * @author songbao.yang
 * @date 2017/12/23
 */
public class TestMonitor {

    private int i;

    void add(){
        synchronized (String.class){
            i++;
        }
    }
}
