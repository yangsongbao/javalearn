package oom;

/** -Xss128k
 * Created by songbao.yang on 2017/5/28.
 * java.lang.StackOverflowError
 */
public class JavaVMStackSOF {

    public int stackLenght = 1;
    public void stackLeak() {
        stackLenght++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {

        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try{
            javaVMStackSOF.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length：" + javaVMStackSOF.stackLenght);
            throw e;
        }
    }
}
