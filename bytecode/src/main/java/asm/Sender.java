package asm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author songbao.yang
 * @date 2018/6/18
 */
public class Sender {

    public static void send(String className,String method,String desc, Object[] args, Object targetThis){
        System.out.println("className: " + className);
        System.out.println("method: " + method);
        System.out.println("desc: " + desc);
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("targetThis: " + targetThis);
    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("asm.TestClass");
        Object o = aClass.newInstance();
        Method test1 = findMethod(aClass, "test1");
        test1.invoke(o, "yangsongbao");
    }

    private static Method findMethod(Class<?> aClass, String name){
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods){
            if (name.equals(method.getName())){
                return method;
            }
        }
        return null;
    }

}
