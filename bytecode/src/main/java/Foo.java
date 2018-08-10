/**
 *
 * @author songbao.yang
 * @date 2018/5/16
 */
public class Foo {
    public String bar() { return null; }
    public String foo() { return null; }
    public String foo(Object o) { return null; }
    public String hello(String name) {
        if (true){
            throw new RuntimeException("test ex");
        }
        return "hello " + name;
    }
}
