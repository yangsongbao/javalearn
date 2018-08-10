package per.yang.lock;

import java.util.LinkedList;

/**
 * Created by songbao.yang on 2017/6/18.
 */
public class ProducerConsumerInJava {

    public static void main(String[] args) throws InterruptedException {

        LinkedList<Integer> buffer = new LinkedList<Integer>();
        int maxSize = 10;
        Producer producer = new Producer(buffer, maxSize, "PRODUCER");
        Consumer consumer = new Consumer(buffer, maxSize, "CONSUMER");
        System.out.println("----------------------------------");
        producer.start();
        Thread.sleep(1000);
        consumer.start();

    }
}
