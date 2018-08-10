package per.yang.bytecode;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * Created by songbao.yang on 2017/7/10.
 */
public class Test {

    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        try {
            CtClass ctClass = classPool.get("per.yang.lock.Main");
            ctClass.setSuperclass(classPool.get("per.yang.lock.Human"));
            ctClass.writeFile("D:\\project\\Learn\\javalearn\\test\\src\\main\\java\\per\\yang\\bytecode");
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
