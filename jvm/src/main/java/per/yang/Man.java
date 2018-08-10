package per.yang;

/**
 *
 * @author songbao.yang
 * @date 2018/1/21
 */
public class Man {

    private String className;
    private String methodName;

    public Man(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
