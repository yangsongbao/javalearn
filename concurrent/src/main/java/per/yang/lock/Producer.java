package per.yang.lock;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class Producer extends Thread{
    private int maxSize;
    private String name;
    private LinkedList<Integer> buffer;
    private int count = 100;

    public Producer(LinkedList buffer, int maxSize, String name){
        this.buffer = buffer;
        this.maxSize = maxSize;
        this.name = name;
    }

    public void run(){
        while (count > 0){
            synchronized (buffer){
                while (buffer.size() >= maxSize){
                    System.out.println("buffer is full, wait consumer");
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                buffer.add(i);
                System.out.println("produce value: " + i);
                buffer.notifyAll();
                count--;
            }
            System.out.println();
        }
    }


}
