package per.yang;


/**
 * Created by songbao.yang on 2018/2/24.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Hello hello = new Hello();
        while (true){
            hello.sayHello();
            Thread.sleep(5000L);
        }
    }
}
