package per.yang;

/**
 * Created by songbao.yang on 2016/9/15.
 */
@Deprecated
public class Person {

    private String name;
    private int age;

    public Person() {
        System.out.println("I am a person!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk(){
        System.out.println("I am walking");
    }

    public void say(String content){
        System.out.println("I am saying: " + content);
    }

    public String read(){
        return "I am reading";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
