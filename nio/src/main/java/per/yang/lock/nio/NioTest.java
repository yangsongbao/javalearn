package per.yang.lock.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by songbao.yang on 2017/6/17.
 */
public class NioTest {

    public static void main(String[] args) throws IOException {

        String path = "D:\\project\\Learn\\javalearn\\nio\\src\\main\\resources\\test.txt";
        RandomAccessFile file = new RandomAccessFile(path, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(2);

        int bytesRead = channel.read(buffer);
        while (bytesRead != -1){
            System.out.println("Read: " + bytesRead);
            buffer.flip();

            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }

            buffer.clear();
            bytesRead = channel.read(buffer);
        }

        file.close();
    }
}
