import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 *
 * @author songbao.yang
 * @date 2018/3/17
 */
public class MyClassVisitor extends ClassVisitor {

    public MyClassVisitor(int api) {
        super(api);
    }

    public MyClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        MethodVisitor methodVisitor = cv.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals("add")){
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("-----access:" + access);
            System.out.println("-----name:" + name);
            System.out.println("-----desc:" + desc);
            System.out.println("-----signature:" + signature);
            System.out.println("-----exceptions:" + exceptions);
            return new MyMethodVisitor(api, methodVisitor);
        }
        return methodVisitor;
    }
}
