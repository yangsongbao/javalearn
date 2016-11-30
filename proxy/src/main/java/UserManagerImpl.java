/**
 * Created by songbao.yang on 2016/9/16.
 */
public class UserManagerImpl implements IUserManager {
    public String getName() {

        System.out.println("原始对象getName方法被调用");
        return "yangsongbao";
    }

    public int getAge() {

        System.out.println("原始对象getAge方法被调用");
        return 0;
    }
}
