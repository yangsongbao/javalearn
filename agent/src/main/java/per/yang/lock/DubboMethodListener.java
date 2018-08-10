package per.yang.lock;

import java.util.Arrays;

/**
 * Created by songbao.yang on 2018/6/7.
 */
public class DubboMethodListener implements MethodListener {

    @Override
    public Object onMethodEnter(Object self, Object[] args) {
        System.out.println("this: " + self);
        System.out.println("this class: " + self.getClass().getName());
        System.out.println("args: " + Arrays.toString(args));
        return "DubboMethodListener";
    }

    @Override
    public void onMethodExit(Object self, Object returned, Object[] args, Throwable t, Object enter) {
        System.out.println("returned: " + returned);
        System.out.println("t: " + t);
        System.out.println("enter: " + enter);
    }
}
