import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by songbao.yang on 2016/9/16.
 */
public class UserManagerProxy2 implements MethodInterceptor {

    public Object getProxyInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("--------------------------代理执行前");
        Object result = methodProxy.invokeSuper(target, args);
        System.out.println("--------------------------代理执行后");


//        System.out.println("target: " + target);
        System.out.println("name: " + method.getName());
        return result;
    }
}
