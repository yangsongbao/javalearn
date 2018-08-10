package per.yang;

/**
 * @author songbao.yang
 */
public class VisitorDemo {
    public static Element[] list = { new ThisElement(), new ThatElement(), new TheOtherElement() };

    public static void main(String[] args) {
        UpVisitor upVisitor = new UpVisitor();
        DownVisitor downVisitor = new DownVisitor();

        for (int i = 0; i < list.length; i++) {
            list[i].accept(upVisitor);
        }

        for (int i = 0; i < list.length; i++) {
            list[i].accept(downVisitor);
        }
    }

}
