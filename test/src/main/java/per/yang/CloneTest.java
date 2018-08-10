package per.yang;

import per.yang.JavaCompiler.JavaCompiler;

/**
 * Created by songbao.yang on 2017/7/29.
 */
public class CloneTest implements Cloneable {

    public static void main(String[] args) {

        CloneTest cloneTest = new CloneTest();
        try {
            CloneTest clone = (CloneTest)cloneTest.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
