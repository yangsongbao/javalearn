package per.yang.JavaCompiler;

import javax.tools.ToolProvider;

/**
 * Created by songbao.yang on 2017/7/11.
 */
public class JavaCompiler {

    static String path = "D:\\project\\Learn\\javalearn\\test\\src\\main\\java\\per\\yang\\bytecode\\";

    public static void main(String[] args) {
        javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int run = compiler.run(null, null, null, "-d", path, path + "Test.java");
        System.out.println(run);
    }
}
