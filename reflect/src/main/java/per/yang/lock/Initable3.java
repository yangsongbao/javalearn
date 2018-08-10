package per.yang.lock;

/**
 * Created by songbao.yang on 2017/3/5.
 */
public class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}
