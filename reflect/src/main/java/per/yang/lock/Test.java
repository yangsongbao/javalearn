package per.yang.lock;

/**
 * Created by songbao.yang on 2017/3/5.
 *
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

//        Class clazz1 = Person.class;
        Class clazz2 = Class.forName("per.yang.Person");

        Class<? extends Person> clazz = Person.class;
        clazz = Man.class;

    }
}
