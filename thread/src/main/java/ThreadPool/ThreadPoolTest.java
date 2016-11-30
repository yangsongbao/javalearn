package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *
 * Created by songbao.yang on 2016/11/25.
 */
public class ThreadPoolTest {
    private ExecutorService executorService;

    public List<Integer> run(){

        threadPoolInit();
        List<Integer> integers = new ArrayList<Integer>();

        List<Future<List<Integer>>> futureTasks = new ArrayList<Future<List<Integer>>>();
        for(int i = 0; i < 1000; i += 100){
            Callablethread callablethread = new Callablethread(i, String.valueOf(i));
            Future<List<Integer>> listFuture = executorService.submit(callablethread);
            futureTasks.add(listFuture);
        }

        List<Integer> result = new ArrayList<Integer>();

        System.out.println("futureTasks的size为：" + futureTasks.size());

        for (Future<List<Integer>> future : futureTasks){
            try {
                while (!future.isDone());
                result.addAll(future.get());
                System.out.println("获取一次结果：" + future.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
        return result;
    }

    public void threadPoolInit() {
        // 从qconfig取得线程池应创建线程数量
        executorService = Executors.newFixedThreadPool(10);
        System.out.println("线程池初始化成功,核心线程数为10");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();

        List<Integer> result = threadPoolTest.run();
        System.out.println("size: " + result.size());
        System.out.println(result.toString());
    }
}
