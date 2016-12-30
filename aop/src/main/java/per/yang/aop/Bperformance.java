package per.yang.aop;

import org.springframework.stereotype.Component;

/**
 * Created by songbao.yang on 2016/11/29.
 */
@Component("bperformance")
public class Bperformance implements IPerformance {
    public void perform(String action) {
        System.out.println("实际执行操作的IPerformance对象是：" + this.getClass());
        System.out.println("B perform: " + action);
        throw new RuntimeException("啊。。。B异常了");
    }
}
