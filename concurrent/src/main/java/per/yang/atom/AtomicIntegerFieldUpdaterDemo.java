package per.yang.atom;


import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author songbao.yang
 */
public class AtomicIntegerFieldUpdaterDemo {

    class DemoData{
        public volatile int value1 = 1;
        volatile int value2 = 2;
        volatile int value3 = 3;
        int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName){
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    void doit(){
        DemoData demoData = new DemoData();
        System.out.println("1 ==>" + getUpdater("value1").getAndSet(demoData, 10));
        System.out.println("2 ==>" + getUpdater("value2").incrementAndGet(demoData));
        System.out.println("3 ==>" + getUpdater("value3").decrementAndGet(demoData));
        System.out.println("true ==>" + getUpdater("value4").compareAndSet(demoData, 4, 5));
    }

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        demo.doit();
    }
}
