package per.yang.lock;


import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by songbao.yang on 2017/6/6.
 */
public class Java8Test {

    public static void main(String[] args) {
        Set<String> set1 = Sets.newHashSet();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("5");

        Set<String> set2 = Sets.newHashSet();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("4");
        set2.add("5");

        Set<String> set3 = Sets.newHashSet();
        set3.add("2");
        set3.add("3");
        set3.add("4");
        set3.add("5");
        set3.add("6");

        Set<String> set4 = Sets.newHashSet();
        set4.add("3");
        set4.add("4");
        set4.add("5");
        set4.add("6");
        set4.add("7");


        HashMap<String, Set> map = new HashMap<String, Set>();
        map.put("1",set1);
        map.put("2",set2);
        map.put("3",set3);
        map.put("4",set4);

        Set result = new HashSet();
        for (String key : map.keySet()){
            Set set = map.get(key);
//            set.forEach(n -> result.add(n));
        }

        System.out.println(result);

    }
}
