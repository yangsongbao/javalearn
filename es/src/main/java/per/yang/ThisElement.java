package per.yang;

/**
 * @author songbao.yang
 */
public class ThisElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String thiss() {
        return "This";
    }
}
