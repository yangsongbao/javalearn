import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import per.yang.AppConfig;
import per.yang.aop.Performance;

import javax.annotation.Resource;

/**
 *
 * Created by songbao.yang on 2016/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public class AopTest {

    @Resource(name = "bperformance")
    private Performance aperformance;

    @Test
    public void perform(){
        aperformance.perform("dance");
    }
}
