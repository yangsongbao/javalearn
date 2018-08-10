package proxy;

/**
 *
 * @author songbao.yang
 * @date 2018/2/13
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = DynProxyFactory.getInstance();
        subject.dealTask("yangsongbao");
    }
}
