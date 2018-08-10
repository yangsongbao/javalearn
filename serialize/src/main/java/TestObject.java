import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author songbao.yang
 * @date 2018/3/11
 */
public class TestObject extends Parent implements Serializable {
    private static final long serialVersionUID = -269096654004839129L;
    private String password = "pass";

    public int testValue = 300;

    public InnerObject innerObject = new InnerObject();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void writeObject(ObjectOutputStream out){
        try {
            ObjectOutputStream.PutField putField = out.putFields();
            System.out.println("原密码：" + password);
            password = "encryption";
            putField.put("password", password);
            System.out.println("加密后的密码" + password);
            out.writeFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in) {
        try {
            ObjectInputStream.GetField readFields = in.readFields();
            Object object = readFields.get("password", "");
            System.out.println("要解密的字符串:" + object.toString());
            password = "pass";//模拟解密,需要获得本地的密钥
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
