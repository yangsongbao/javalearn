package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * Created by songbao.yang on 2017/5/28.
 * java.lang.OutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List list = new ArrayList();
        while (true){
            list.add(new OOMObject());
        }
    }
}
