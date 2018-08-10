package proxy;

/**
 * Created by songbao.yang on 2018/2/13.
 */
public interface Subject {
    /**
     * 执行给定名字的任务。
     * @param taskName 任务名
     */
    public void dealTask(String taskName);
}
