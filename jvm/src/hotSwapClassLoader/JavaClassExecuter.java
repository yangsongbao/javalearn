package hotSwapClassLoader;

import java.io.*;
import java.lang.reflect.Method;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 * Created by songbao.yang on 2017/6/9.
 */
public class JavaClassExecuter {

    public static String execute(byte[] classByte){
        HackSystem.clearBuffer();
        ClassModifier classModifier = new ClassModifier(classByte);
        byte[] modiBytes = classModifier.modifyUTF8Constant("java/lang/System", "hotSwapClassLoader/HackSystem");

        File test2 = new File("D:\\project\\Learn\\javalearn\\jvm\\src\\hotSwapClassLoader\\Test2.class");
        ByteUtils.write2ClassFile(modiBytes, test2);

        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, new String[]{null});
        } catch (Throwable e){
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }

    public static void main(String[] args) {
        JavaClassExecuter javaClassExecuter = new JavaClassExecuter();
        byte[] bytes = javaClassExecuter.readClassFile("D:\\project\\Learn\\javalearn\\jvm\\src\\hotSwapClassLoader\\Test.class");
        String execute = javaClassExecuter.execute(bytes);
        System.out.println("execute result : " + execute);
    }

    private byte[] readClassFile(String path){

        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] tmp = new byte[1024];
            int len  = -1;
            while ((len = bufferedInputStream.read(tmp)) != -1){
                byteArrayOutputStream.write(tmp, 0, len);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
