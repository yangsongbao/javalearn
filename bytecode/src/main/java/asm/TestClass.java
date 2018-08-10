package asm;

/**
 *
 * @author songbao.yang
 * @date 2018/6/17
 */
public class TestClass<E> {
    public void test(E data){
        System.out.println("I'm  TestClass.test(), " + data.toString());
    }
    public void test1(E data){
        System.out.println("I'm  TestClass.test1(), " + data.toString());
    }

}
