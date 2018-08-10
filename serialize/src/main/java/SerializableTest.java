import java.io.*;

/**
 *
 * @author songbao.yang
 * @date 2018/3/11
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        TestObject testObject = new TestObject();
        objectOutputStream.writeObject(testObject);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TestObject object = (TestObject)objectInputStream.readObject();
        System.out.println(object.parentValue);
        System.out.println(object.testValue);
            System.out.println(object.innerObject.innerValue);
    }

}
