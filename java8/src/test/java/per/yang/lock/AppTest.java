package per.yang.lock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by songbao.yang on 2017/12/9.
 */
public class AppTest {

    private List<Person> persons = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        int count = 10000000;
        for (int i = 0; i < count; i++) {
            persons.add(new Person("name", i));
        }

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void streamTest(){
        long start1 = System.currentTimeMillis();
        List<Integer> collect1 = persons.stream().filter(e -> (e.getAge() % 2 == 0)).map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println("time1:" + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        List<Integer> collect2 = persons.parallelStream().filter(e -> (e.getAge() % 2 == 0)).map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println("time2:" + (System.currentTimeMillis() - start2));

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.get("1");

    }

}