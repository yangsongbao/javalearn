package ThreadPool;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by songbao.yang on 2016/11/25.
 */
public class Callablethread implements Callable<List<Integer>>{

    private Integer i;
    private String name;

    public Callablethread(Integer i, String name) {
        this.i = i;
        this.name = name;
    }

    public List<Integer> call() throws Exception {

        System.out.println("开始执行一次call调用，线程名：" + name);
        BasicService basicService = new BasicService();
        List<Integer> result = basicService.add(i);
        System.out.println("线程" + name + "的执行结果为：" + result.toString());
        return result;
    }
}
