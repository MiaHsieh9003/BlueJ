import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainContainer {
    public static void main(String[] args) {
        // 1. 初始化 JADE 環境
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        ContainerController container = rt.createMainContainer(p);

        try {
            // 2. 創建並啟動代理
            AgentController agent = container.createNewAgent("MyAgent", MyAgent.class.getName(), null);
            agent.start();  // 呼叫並啟動代理
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

