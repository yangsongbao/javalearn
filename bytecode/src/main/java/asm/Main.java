package asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.ClassReader.EXPAND_FRAMES;
import static org.objectweb.asm.ClassReader.SKIP_DEBUG;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;

/**
 *
 * @author songbao.yang
 * @date 2018/6/18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String clazz = "asm.TestClass";
        ClassReader classReader = new ClassReader(clazz);
        ClassWriter classWriter = new ClassWriter(classReader, COMPUTE_MAXS);
        YClassVisitor yClassVisitor = new YClassVisitor(classWriter, clazz);
        classReader.accept(yClassVisitor, EXPAND_FRAMES);
        byte[] data = classWriter.toByteArray();
        File file = new File("D:\\project\\Learn\\javalearn\\bytecode\\src\\main\\java\\asm\\TestClass.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
    }
}
