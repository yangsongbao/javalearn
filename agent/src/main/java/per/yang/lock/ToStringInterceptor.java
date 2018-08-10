package per.yang.lock;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

/**
 *
 * @author songbao.yang
 * @date 2018/5/16
 */
public class ToStringInterceptor {

    @RuntimeType
    public static Object intercept(Object value, @SuperCall Callable<String> zuper) {
        System.out.println("before foo");
        try {
            return "!!!!!!!!!!!!!!!!!!!";
        } finally {
            System.out.println("after foo");
        }
    }
}
