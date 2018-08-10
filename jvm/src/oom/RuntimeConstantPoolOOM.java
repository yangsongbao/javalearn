package oom;

import java.util.ArrayList;

/**
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author songbao.yang
 * @date 2017/5/28
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        String base = "string";
        while (true){
            String str = base + base;
            base = str;
            strings.add(str.intern());
        }
    }
}
