package per.yang.lock.io;

import java.io.*;

/**
 * Created by songbao.yang on 2017/6/15.
 */
public class InputStreamTest {


    public static void main(String[] args) {

        String path = "D:\\project\\Learn\\javalearn\\nio\\src\\main\\resources\\test.txt";
        String out = "D:\\project\\Learn\\javalearn\\nio\\src\\main\\resources\\out.txt";

        long _1MB = 1024 * 1024;
        long _1GB = 1024 * _1MB;

        try {
//            File in = new File(path);
//            FileInputStream fileInputStream = new FileInputStream(in);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//            int n = 0;
//            byte[] bytes = new byte[1024];
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            while ((n = bufferedInputStream.read(bytes)) != -1){
//                byteArrayOutputStream.write(bytes);
//            }
//            System.out.println(in.length());

            File outFile = new File(out);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            String s = "i am yangsongbao";
            byte[] bytes = s.getBytes();
            while (outFile.length() < _1GB) {
                bufferedOutputStream.write(bytes);
            }

            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
