import org.objectweb.asm.MethodVisitor;

/**
 *
 * @author songbao.yang
 * @date 2018/3/18
 */
public class MyMethodVisitor extends MethodVisitor {
    public MyMethodVisitor(int api) {
        super(api);
    }

    public MyMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }
}
