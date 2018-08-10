package per.yang;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 *
 * @author songbao.yang
 * @date 2018/1/27
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

        getPrintlnMH(obj).invokeExact("yansongbao");


    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {

        MethodType methodType = MethodType.methodType(void.class, String.class);

        MethodHandle println = MethodHandles.lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);

        return println;
    }
}
