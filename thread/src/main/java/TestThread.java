import muti.NoStopThread;
import muti.RunnableDemo;
import muti.ThreadDemo;

/**
 * Created by songbao.yang on 2016/11/25.
 */
public class TestThread {

    public static void main(String[] args) {
        int count = 0;
        while (true){
            new NoStopThread().start();
            count++;
            if (count % 1000 == 0){
                System.out.println("--------------线程数" + count);
            }
        }
    }
}
