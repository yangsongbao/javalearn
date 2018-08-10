package per.yang.lock;

/**
 * Created by songbao.yang on 2018/6/7.
 */
public interface MethodListener {

    Object onMethodEnter(Object self, Object[] args);

    void onMethodExit(Object self,
                        Object returned,
                        Object[] args,
                        Throwable t,
                      Object enter);
}
