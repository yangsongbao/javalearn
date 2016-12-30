package state;

/**
 *
 * Created by songbao.yang on 2016/12/10.
 */
public class ThreadRUNNABLE {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println(i);
                }
            }
        });

        thread.start();
    }
}
