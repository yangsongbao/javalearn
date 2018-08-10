package per.yang.lock;

/**
 * Created by songbao.yang on 2017/3/5.
 */
public class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return Long.toString(id);
    }
}
