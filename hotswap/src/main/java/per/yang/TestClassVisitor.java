package per.yang;


import org.objectweb.asm.ClassVisitor;

/**
 * Created by songbao.yang on 2018/2/26.
 */
public class TestClassVisitor extends ClassVisitor {

    public TestClassVisitor(int i) {
        super(i);
    }

    public TestClassVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature,
                      String superName, String[] interfaces) {
        System.out.println(version);
        System.out.println(access);
        System.out.println(name);
        System.out.println(signature);
        System.out.println(superName);
        System.out.println(interfaces);
    }


}
