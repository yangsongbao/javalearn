/**
 * @author songbao.yang
 */
public class AgentBinder {

    public static void main(String[] args) throws Exception {

        String pid = "10600";
        String path = "D:\\project\\Learn\\javalearn\\agent\\target\\agent-jar-with-dependencies.jar";
        new AgentAttacher().loadAgent(pid, path, "yangsongbao");
    }
}
