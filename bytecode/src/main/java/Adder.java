/**
 * Created by songbao.yang on 2018/3/17.
 */
public class Adder {
    private String province;
    private String city;

    public Integer add(Integer a, Integer b) {
        System.out.println("-------------" + a + b);
        return a + b;
    }
    public void string(Adder adder){
        System.out.println(adder.toString());
    }

    @Override
    public String toString() {
        return "Adder{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
