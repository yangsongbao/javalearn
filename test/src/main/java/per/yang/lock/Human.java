package per.yang.lock;

/**
 * Created by songbao.yang on 2017/7/2.
 */
public class Human {
    private float height;
    private float weight;

    Human(){

    }

    Human(float height, float weight){
        this.height = height;
        this.weight= weight;
    }

    public void eat(){
        System.out.println("eat eat eat");
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {

        Human mayue = new Human();


    }
}
