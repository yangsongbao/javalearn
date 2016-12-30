package state;

/**
 *
 * Created by songbao.yang on 2016/12/10.
 */
public class ThreadTIMED_WAITINGandBLOCKED {

    public static void main(String[] args) {
        final Object lock = new Object();

        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + "invoke");
                    try {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(i);
                            Thread.sleep(10000L);
                        }
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }

            }
        }, "BLOCKED-Thread-A");

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " invoke");
                    try {
                        for (int i = 10; i < 20; i++) {
                            System.out.println(i);
                            Thread.sleep(10000L);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BLOCKED-Thread-B");
        threadA.start();
        threadB.start();
    }
}
