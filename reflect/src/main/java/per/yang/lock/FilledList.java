package per.yang.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songbao.yang on 2017/3/5.
 *
 */
public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }

    public List<T> create(int nElements){
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < nElements; i++) {
            T t = null;
            try {
                t = type.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            result.add(t);
        }
        return result;
    }
}
