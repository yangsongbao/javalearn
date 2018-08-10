import com.google.common.io.Files;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author songbao.yang
 * @date 2018/3/17
 */
public class AsmTest {

    public static void main(String[] args) throws Exception {

        Class<Adder> adderClass = Adder.class;
//        ClassReader classReader = new ClassReader(adderClass.getCanonicalName());
//        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//        classReader.accept(new MyClassVisitor(Opcodes.ASM5, classWriter), 2);
//        classWriter.toByteArray();
//
//        byte[] bytes = classWriter.toByteArray();


        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get(adderClass.getCanonicalName());
        CtMethod addMethod = ctClass.getDeclaredMethod("add");
        addMethod.insertAt(7, "System.out.println(\"-------------\" + a + b);\n");

        CtClass exceptionClass = classPool.get(NullPointerException.class.getCanonicalName());
        addMethod.addCatch("System.out.println(\"++++++++\");\n", exceptionClass);
        byte[] bytes = ctClass.toBytecode();
        File file = new File("D:\\a.class");
        Files.write(bytes, file);
    }
}
