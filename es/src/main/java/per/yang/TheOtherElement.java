package per.yang;

/**
 * @author songbao.yang
 */
public class TheOtherElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String theOther() {
        return "TheOther";
    }
}
