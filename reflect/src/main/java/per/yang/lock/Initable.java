package per.yang.lock;

/**
 * Created by songbao.yang on 2017/3/5.
 */
public class Initable {
    static final int staticFinal = 47;  //编译期常量
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000); //非编译期常量

    static {
        System.out.println("Initializing Initable");
    }
}
