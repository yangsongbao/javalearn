package proxy;

/**
 * Created by songbao.yang on 2018/2/13.
 */
public class RealSubject implements Subject {

    @Override
    public void dealTask(String taskName) {
        System.out.println("正在执行任务："+taskName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
