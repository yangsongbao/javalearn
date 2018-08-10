package per.yang.lock;

/**
 * Created by songbao.yang on 2017/3/5.
 */
public class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}
