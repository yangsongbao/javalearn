package proxy;

import com.google.common.io.Files;

import java.lang.reflect.Proxy;

/**
 * Created by songbao.yang on 2018/2/13.
 */
public class DynProxyFactory {

    public static Subject getInstance(){
        RealSubject delegate = new RealSubject();
        SubjectInvocationHandler handler = new SubjectInvocationHandler(delegate);
        Subject proxy = (Subject) Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                handler);

        Class<? extends Subject> aClass = proxy.getClass();


        return proxy;
    }
}
