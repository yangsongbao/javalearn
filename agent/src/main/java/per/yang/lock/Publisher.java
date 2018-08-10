package per.yang.lock;

/**
 *
 * @author songbao.yang
 * @date 2018/6/7
 */
public class Publisher {

    private static MethodListener methodListener;

    public static Object enter(Object self, Object[] args){
        return methodListener.onMethodEnter(self, args);
    }


    public static void exit(Object self, Object returned, Object[] args, Throwable t, Object enter){
        methodListener.onMethodExit(self, returned, args, t, enter);
    }

    public static void register(MethodListener methodListener){
        Publisher.methodListener = methodListener;
    }
}
