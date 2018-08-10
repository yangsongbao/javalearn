package per.yang.lock;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by songbao.yang on 2016/9/15.
 */
public class ReflectTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        //1.通过实例变量的getClass()方法：
        Person person = new Person();
        Class personClass1 = person.getClass();

        //2.通过类Class的静态方法forName()
        try {
            Class personClass2 = Class.forName("per.yang.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //3.直接给出对象类文件的.class：
        Class<Person> personClass3 = Person.class;


        String name = personClass1.getName();
        System.out.println("name: " + name);
        Field[] declaredFields = personClass1.getDeclaredFields();
        for(int i = 0; i < declaredFields.length; i++){
            System.out.println(declaredFields[i].toString());
        }
        try {
            Field name1 = personClass1.getDeclaredField("name");
            name1.setAccessible(true);
            Person person1 = (Person)personClass1.newInstance();
            System.out.println("before: " + person1.toString());
            name1.set(person1, "yangsongbao");
            System.out.println("afer: " + person1.toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Method[] declaredMethods = personClass1.getDeclaredMethods();
        System.out.println("-------------declaredMethods------------");
        for (int i= 0; i < declaredMethods.length; i++){
            Method declaredMethod = declaredMethods[i];
            System.out.println(declaredMethod.toString());
        }

        Annotation[] annotations = personClass1.getAnnotations();
        System.out.println("---------------annotations--------------");
        for (int i = 0; i < annotations.length; i++){
            Annotation annotation = annotations[i];
            System.out.println(annotation.toString());
        }
        
    }
}
