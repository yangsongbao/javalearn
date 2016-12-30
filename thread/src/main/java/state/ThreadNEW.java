package state;

/**
 * Created by songbao.yang on 2016/12/10.
 */
public class ThreadNEW {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getState());
    }
}
