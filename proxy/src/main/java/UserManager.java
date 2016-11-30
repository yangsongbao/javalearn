/**
 * Created by songbao.yang on 2016/9/16.
 */
public class UserManager {

    private String name;
    private int age;

    public UserManager() {
    }

    public UserManager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        System.out.println("原始对象的getName方法");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        System.out.println("原始对象的geAge方法");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
