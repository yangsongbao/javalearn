package per.yang.aop;

import org.springframework.stereotype.Component;

/**
 *
 * Created by songbao.yang on 2016/10/15.
 */
@Component("aperformance")
public class Aperformance implements IPerformance {
    public void perform(String action) {

        System.out.println("实际执行操作的IPerformance对象是：" + this.getClass());
        System.out.println("A perform: " + action);
        throw new RuntimeException("啊。。。A异常了");
    }
}
