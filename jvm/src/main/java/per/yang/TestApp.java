package per.yang;

/**
 *
 * @author songbao.yang
 * @date 2018/1/21
 */
public class TestApp implements Runnable{

    void sayHi(Man man){


        System.out.println("hi " + man.getClassName());
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sayHi(new Man("yangsongbao"));
        }
    }
}
