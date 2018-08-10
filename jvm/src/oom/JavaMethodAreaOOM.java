package oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by songbao.yang on 2017/5/28.
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<Object>();
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });

            Object o = enhancer.create();
            objects.add(o);
        }
    }

    static class OOMObject{

    }
}
