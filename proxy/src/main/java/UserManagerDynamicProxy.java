import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * Created by songbao.yang on 2016/9/16.
 */
public class UserManagerDynamicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().toLowerCase().contains("name")){
            System.out.println("不执行原始对象的getName方法，返回结果由动态代理对象决定");
             return "songbao";
        }
        System.out.println("动态代理对象的invoke方法开始执行");
        Object invoke = method.invoke(target, args);

        return invoke;
    }
}
