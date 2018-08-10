package per.yang;

public class DownVisitor implements Visitor {

    @Override
    public void visitor(ThisElement thisElement) {
        System.out.println( "do Down on " + thisElement.thiss() );
    }

    @Override
    public void visitor(ThatElement thatElement) {
        System.out.println( "do Down on " + thatElement.that() );
    }

    @Override
    public void visitor(TheOtherElement theOtherElement) {
        System.out.println( "do Down on " + theOtherElement.theOther() );
    }
}
