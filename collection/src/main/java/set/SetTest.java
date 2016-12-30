package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by songbao.yang on 2016/12/29.
 */
public class SetTest {

    public static void main(String[] args) {
        HashSet<Integer> strings = new LinkedHashSet<Integer>();

        strings.add(3);
        strings.add(4);
        strings.add(5);
        strings.add(2);
        strings.add(1);
        strings.add(10);

        Iterator<Integer> iterator = strings.iterator();

        if(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//            iterator.remove();
//        }
//        System.out.println("----------------");
        Iterator<Integer> iterator1 = strings.iterator();
        while (iterator1.hasNext()){
            Integer next = iterator1.next();
            System.out.println(next);
        }
        strings.size();
    }
}
