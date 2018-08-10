package per.yang.lock;

import java.util.Random;

/**
 * Created by songbao.yang on 2017/3/5.
 *
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("Atfer creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("per.yang.Initable3");
        System.out.println("After creating initable ref");
        System.out.println(Initable3.staticNonFinal);

        Class<?> integerClass = int.class;
        integerClass = Integer.class;
        integerClass = String.class;
    }
}
