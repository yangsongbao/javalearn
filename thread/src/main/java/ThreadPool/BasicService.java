package ThreadPool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by songbao.yang on 2016/11/25.
 */
public class BasicService {

    public List<Integer> add(Integer input){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for(int i = input; i< input + 10; i++){
            integers.add(i);
        }
        return integers;
    }
}
