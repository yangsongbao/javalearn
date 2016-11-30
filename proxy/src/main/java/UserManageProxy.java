/**
 * Created by songbao.yang on 2016/9/16.
 */
public class UserManageProxy implements IUserManager {

    private IUserManager userManagerImpl;

    public UserManageProxy(IUserManager userManagerImpl) {
        this.userManagerImpl = userManagerImpl;
    }

    public String getName() {
        return userManagerImpl.getName();
    }

    public int getAge() {
        System.out.println("静态代理对象getAge方法执行");
        return userManagerImpl.getAge();
    }
}
