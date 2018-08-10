package asm;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

/**
 *
 * @author songbao.yang
 * @date 2018/6/18
 */
class YMethodVisitor extends AdviceAdapter {
    private final String targetClassName;

    YMethodVisitor(int api, MethodVisitor mv, int access, String name, String desc, String targetClassName) {
        super(api, mv, access, name, desc);
        this.targetClassName = targetClassName;
    }

    @Override
    protected void onMethodEnter() {
        mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
        mv.visitLdcInsn("Hello world!");
        mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println",
                "(Ljava/lang/String;)V", false);
    }

    @Override
    protected void onMethodExit(int opcode) {
        mv.visitLdcInsn(targetClassName);
        mv.visitLdcInsn(getName());
        mv.visitLdcInsn(methodDesc);
        loadArgArray();
        loadThisOrPushNullIfIsStatic();
        visitMethodInsn(Opcodes.INVOKESTATIC, "asm.Sender","send",
                "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Object;)V", false);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        super.visitLineNumber(line, start);
    }

    final protected boolean isStaticMethod() {
        return (methodAccess & ACC_STATIC) != 0;
    }
    final protected void loadThisOrPushNullIfIsStatic() {
        if (isStaticMethod()) {
            pushNull();
        } else {
            loadThis();
        }
    }

    final protected void pushNull() {
        push((Type) null);
    }
}
