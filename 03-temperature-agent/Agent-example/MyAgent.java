import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

// 這是自定義代理類，MyAgent，繼承自 jade.core.Agent
class MyAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("代理 " + getLocalName() + " 已啟動！");
        
        // 3. 添加一個簡單的行為
        addBehaviour(new jade.core.behaviours.OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("代理正在執行任務...");
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("代理 " + getLocalName() + " 正在終止！");
    }
}