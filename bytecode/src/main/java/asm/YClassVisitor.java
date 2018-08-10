package asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 *
 * @author songbao.yang
 * @date 2018/6/18
 */
public class YClassVisitor extends ClassVisitor {
    private final String targetClassName;

    public YClassVisitor(ClassVisitor classVisitor, String targetClassName) {
        super(Opcodes.ASM6, classVisitor);
        this.targetClassName = targetClassName;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

        MethodVisitor methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);
        MethodVisitor wrappedMv = methodVisitor;
        if ("test1".equals(name)){
            wrappedMv = new YMethodVisitor(Opcodes.ASM6, methodVisitor, access, name, descriptor, targetClassName);
        }
        return wrappedMv;
    }
}
