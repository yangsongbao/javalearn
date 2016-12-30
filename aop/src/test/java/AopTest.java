import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.yang.AppConfig;
import per.yang.aop.IPerformance;
import per.yang.aop.ISinger;

import javax.annotation.Resource;

/**
 *
 * Created by songbao.yang on 2016/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public class AopTest {

    @Resource(name = "bperformance")
    private IPerformance aperformance;

    @Test
    public void perform(){
        System.out.println("注入的IPerformance对象是：" + aperformance.getClass());
        aperformance.perform("dance");
//
//        ISinger singer = (ISinger)aperformance;
//        singer.sing();
    }
}
