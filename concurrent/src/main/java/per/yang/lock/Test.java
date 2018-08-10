package per.yang.lock;

import java.security.acl.LastOwnerException;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class Test {

    private static LockTest flag = new LockTest();


        class NotifyThread extends Thread {

            public void run() {
                System.out.println("notify thread is running");
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (flag) {
                    flag.flag = false;
                    flag.notifyAll();
                    System.out.println("notify thread is exit");
                }
            }
        };


        class WaitThread extends Thread {
            private String name;
            public WaitThread(String name){
                this.name = name;
            }

            public void run(){

                synchronized (flag){
                    System.out.println(name + " get flag lock, flag value is " + flag.flag);
                    while (flag.flag){
                        System.out.println(name + " begin waiting");

                        try {
                            flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(name + " finish waiting");
                    }
                }
            }
        }

    public static void main(String[] args) {

        Test test = new Test();
        NotifyThread notifyThread = test.new NotifyThread();
        WaitThread waitThread1 = test.new WaitThread("waitThread1");
        WaitThread waitThread2 = test.new WaitThread("waitThread2");
        WaitThread waitThread3 = test.new WaitThread("waitThread3");

        waitThread1.start();
        waitThread2.start();
        waitThread3.start();
        notifyThread.start();

    }
}
