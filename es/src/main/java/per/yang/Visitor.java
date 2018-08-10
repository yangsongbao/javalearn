package per.yang;

public interface Visitor {

    public void visitor(ThisElement thisElement);

    public void visitor(ThatElement thatElement);

    public void visitor(TheOtherElement theOtherElement);
}
