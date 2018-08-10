package gc;

/**
 * **
 *VM参数:-verbose:gc-Xms20M-Xmx20M-Xmn10M-XX:+PrintGCDetails
 *-XX:SurvivorRatio=8
 * Created by songbao.yang on 2017/5/28.
 */
public class MinorGC {

    public static final int _1MB = 1024 * 1024;

    public static void testAllocation( ) {
        byte[]allocation1, allocation2, allocation3, allocation4;
        allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[2*_1MB];
        allocation4=new byte[4*_1MB];//出现一次Minor GC
    }

    public static void main(String[] args) {
//        testAllocation();
//        int i;
//        i =9;

        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);  //true
        System.out.println(e==f);  //false
        System.out.println(c==(a+b));  //true
        System.out.println(c.equals(a+b)); //true
        System.out.println(g==(a+b));  //true?
        System.out.println(g.equals(a+b)); //fasle

    }
}
