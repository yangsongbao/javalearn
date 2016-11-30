package muti;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * Created by songbao.yang on 2016/11/25.
 */
public class CallableThreadTest implements Callable<Integer> {
    public Integer call() throws Exception {
        int i = 0;
        for (; i< 100; i++){
            System.out.println(Thread.currentThread().getName() + ">>>>>>>>>>>>>>>>>>>>>" + i);
        }
        return i;
    }

    public static void main(String[] args) {
        CallableThreadTest callableThreadTest = new CallableThreadTest();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(callableThreadTest);

        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if(i == 20){
                new Thread(integerFutureTask, "有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值： " + integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
