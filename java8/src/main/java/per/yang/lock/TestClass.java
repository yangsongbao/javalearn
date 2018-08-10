package per.yang.lock;

/**
 * Created by songbao.yang on 2017/12/10.
 */
public class TestClass implements ITest {

    @Override
    public void print() {
        System.out.println("TestClass");
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.print();
    }
}
