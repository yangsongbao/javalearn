import muti.RunnableDemo;
import muti.ThreadDemo;

/**
 * Created by songbao.yang on 2016/11/25.
 */
public class TestThread {

    public static void main(String[] args) {
//        RunnableDemo runnableDemo = new RunnableDemo("Thread-1");
//        runnableDemo.start();
//
//        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-2");
//        runnableDemo2.start();

        ThreadDemo threadDemo = new ThreadDemo("Thread-3");
        threadDemo.start();

        ThreadDemo threadDemo1 = new ThreadDemo("Thread-4");
        threadDemo1.start();
    }
}
