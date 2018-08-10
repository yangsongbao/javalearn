package muti;

/**
 * Created by songbao.yang on 2017/12/17.
 */
public class NoStopThread extends Thread {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
