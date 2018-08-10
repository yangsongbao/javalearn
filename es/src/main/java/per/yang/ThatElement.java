package per.yang;

/**
 * @author songbao.yang
 */
public class ThatElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
    public String that() {
        return "That";
    }
}
