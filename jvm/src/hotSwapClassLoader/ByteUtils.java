package hotSwapClassLoader;

import java.io.*;

/**
 * Created by songbao.yang on 2017/6/9.
 */
public class ByteUtils {

    public static int byte2Int(byte[] b, int start, int len){
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = (int) b[i] & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    public static byte[] int2Byte(int value, int len){
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return bytes;
    }

    public static String byte2String(byte[] b, int start, int len){
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str){
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, newBytes,
                offset + replaceBytes.length, originalBytes.length - offset -len);
        return newBytes;
    }


    public static void write2ClassFile(byte[] b, File file){

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
