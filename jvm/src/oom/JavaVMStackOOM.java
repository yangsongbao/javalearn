package oom;

/**
 * -verbose:gc -Xms1M -Xmx1M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * Created by songbao.yang on 2017/5/28.
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stackLeakByThread(){
        int i = 0;
        long start = System.currentTimeMillis();
        try {
            while (true) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dontStop();
                    }
                });
                i++;
                System.out.println("线程数: " + i);
                thread.start();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            System.out.println("-----------------stackLeakByThread异常啦");
        } finally {
            System.out.println("stackLeakByThread耗时: " + (System.currentTimeMillis() - start));
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
            javaVMStackOOM.stackLeakByThread();
        } catch (Throwable e){
            System.out.println("-----------------" + e);
            System.out.println("----------------main异常啦");
        } finally {
            System.out.println("main耗时: " + (System.currentTimeMillis() - start));
        }
    }
}
