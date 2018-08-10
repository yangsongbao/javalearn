import java.lang.management.ManagementFactory;

/**
 * Created by songbao.yang on 2018/6/3.
 */
public class RunningMain {

    public static void main(String[] args) throws InterruptedException {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        Foo foo = new Foo();
        while (true){
            try {
                System.out.println(foo.hello("RunningMain"));
            } catch (Exception e){
                e.printStackTrace();
            }
            Thread.sleep(3000);
        }
    }
}
