package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by songbao.yang on 2016/12/29.
 */
public class MapTest {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        map.put("d","ddd");
        map.put("e","eee");
        map.put("f","fff");

        Iterator<String> iterator = map.keySet().iterator();


        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            System.out.println(map.get(next));
        }

    }
}
