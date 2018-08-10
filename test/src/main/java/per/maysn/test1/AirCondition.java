package per.maysn.test1;

/**
 * Created by songbao.yang on 2017/7/9.
 */

public class AirCondition {
    private float power;
    private float volume;
    private int direction;
    private static int test = 9;

    static {
        System.out.println("static test = " + test);
        System.out.println("静态代码块执行");
    }

    public AirCondition(){
        System.out.println("constructor test = " +  test);
        System.out.println("默认构造函数执行");
    }

    public AirCondition(float power, float volume, int direction){

    }

    public void changeMode(int mode){
        if (mode == 1){
            power = 5.0f;
            volume = 3.0f;
            direction = 1;
        } else {
            power = 2.5f;
            volume = 5;
            direction = 2;
        }
    }

    @Override
    public String toString() {
        return "AirCondition{" +
                "power=" + power +
                ", volume=" + volume +
                ", direction=" + direction +
                '}';
    }

    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        System.out.println(airCondition);
    }
}
