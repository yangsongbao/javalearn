package per.yang.aop;

import org.springframework.stereotype.Component;

/**
 * Created by songbao.yang on 2016/11/29.
 */
@Component("bperformance")
public class Bperformance implements Performance {
    public void perform(String action) {
        System.out.println("B perform: " + action);
        throw new RuntimeException("啊。。。B异常了");
    }
}
