package per.yang;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.IOException;

/**
 * Created by songbao.yang on 2018/2/26.
 */
public class Main {

    public static void main(String[] args) throws IOException, NotFoundException {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("per.yang.TestClassVisitor");

        ClassReader classReader = new ClassReader(String.class.getName());
        TestClassVisitor testClassVisitor = new TestClassVisitor(Opcodes.ASM5);
        classReader.accept(testClassVisitor, 0);

    }
}
