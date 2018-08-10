package per.yang.lock;

import java.util.LinkedList;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class Consumer extends Thread{

    private int maxSize;
    private String name;
    private LinkedList<Integer> buffer;

    public Consumer(LinkedList buffer, int maxSize, String name){
        this.buffer = buffer;
        this.maxSize = maxSize;
        this.name = name;
    }

    public void run(){
        while (true){
            synchronized (buffer){
                while (buffer.isEmpty()){
                    System.out.println("buffer is empty, wait");
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer integer = buffer.removeFirst();
                System.out.println("Cosumering value : " + integer);
                buffer.notify();
            }
        }

    }

}
