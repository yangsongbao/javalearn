package per.yang.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by songbao.yang on 2016/9/17.
 */
public class PipeExample {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    pipedOutputStream.write("i am thread1".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (pipedOutputStream != null){
                        try {
                            pipedOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    int data = pipedInputStream.read();
                    while (data != -1) {
                        System.out.println((char) data);
                        data = pipedInputStream.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (pipedInputStream != null) {
                        try {
                            pipedInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
