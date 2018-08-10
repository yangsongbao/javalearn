package per.yang;

import javassist.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

    private static final String line = System.getProperty("line.separator");

    public static void main( String[] args ) throws InterruptedException, CannotCompileException, NotFoundException, IOException {

        String path = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println("---------------path: " + path);

        MethodMap.methodMap.put("class1#method1", "Thread.sleep(1000L);");
        MethodMap.methodMap.put("class2#method2", "throw new RuntimeException(\"exception\");");
        MethodMap.methodMap.put("class3#method3", "System.out.println(\"sout\");");

        ClassPool classPool = ClassPool.getDefault();
        classPool.importPackage("per.yang.Man");
        classPool.importPackage("per.yang.MethodMap");

        CtClass ctClass = classPool.makeClass("per.yang.ProxyApp");
        ctClass.setModifiers(Modifier.PUBLIC);
        CtMethod ctMethod = CtMethod.make(makeSrc(), ctClass);
        ctClass.addMethod(ctMethod);
        ctClass.writeFile("D:\\project\\Learn\\javalearn\\jvm\\target\\classes\\per\\");


        classPool.importPackage("per.yang.ProxyApp");
        CtClass testAppClass = classPool.get("per.yang.TestApp");
        CtMethod sayHiMethod = testAppClass.getDeclaredMethod("sayHi");
        sayHiMethod.insertBefore("new per.yang.ProxyApp().invoke($1);");

        testAppClass.writeFile("D:\\project\\Learn\\javalearn\\jvm\\target\\classes\\per\\");

//        TestApp testApp = new TestApp();
//        new Thread(testApp).start();
        System.out.println();
    }
    private static String makeSrc(){
        StringBuilder builder = new StringBuilder("");
        builder.append("public void invoke(Man man){").append(line);

        for (String method : MethodMap.methodMap.keySet()) {
            String[] split = method.split("#");
            if (split.length != 2){
                continue;
            }
            String className = split[0];
            String methodName = split[1];

            builder.append("if (\"")
                    .append(className).append("\"").append(".equals(man.getClassName()) && ")
                    .append("\"").append(methodName).append("\"").append(".equals(man.getMethodName())")
                    .append(")")
                    .append("{").append(line);
            builder.append(MethodMap.methodMap.get(method)).append(line);
            builder.append("}").append(line);
        }

        builder.append("}").append(line);

        return builder.toString();
    }
}
