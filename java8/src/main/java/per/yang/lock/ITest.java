package per.yang.lock;

/**
 * Created by songbao.yang on 2017/12/10.
 */
public interface ITest {

    String str = "yangsongbao";

    default void print(){
        System.out.println(str);
    }


}
