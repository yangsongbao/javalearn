package per.yang;

public class UpVisitor implements Visitor {

    @Override
    public void visitor(ThisElement thisElement) {
        System.out.println("do up on " + thisElement.thiss());
    }

    @Override
    public void visitor(ThatElement thatElement) {
        System.out.println("do up on " + thatElement.that());
    }

    @Override
    public void visitor(TheOtherElement theOtherElement) {
        System.out.println("do up on " + theOtherElement.theOther());
    }
}
