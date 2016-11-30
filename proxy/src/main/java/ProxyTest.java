import org.apache.ibatis.executor.loader.cglib.CglibProxyFactory;

/**
 *
 * Created by songbao.yang on 2016/9/16.
 */
public class ProxyTest {

    public static void main(String[] args) {

        UserManagerProxy2 userManagerProxy2 = new UserManagerProxy2();
        UserManager userManager = (UserManager)userManagerProxy2.getProxyInstance(UserManager.class);
        userManager.getName();
        userManager.getAge();
    }
}
