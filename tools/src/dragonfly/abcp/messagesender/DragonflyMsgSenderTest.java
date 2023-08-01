package dragonfly.abcp.messagesender;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dragonfly.DragonFlyLibV2;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;

public class DragonflyMsgSenderTest {
  private MyDragonflyMsgSender msgSender;
  private DragonFlyLibV2Stub libStub;

  @Before
  public void setUp() {
    // 初始化 DragonflyMsgSender 和 DragonFlyLibV2Stub
    libStub = new DragonFlyLibV2Stub();
    msgSender = new MyDragonflyMsgSender();
    msgSender.init(libStub);
  }

  @After
  public void tearDown() {
    // 关闭 DragonflyMsgSender
    msgSender.close();
  }

  @Test
  public void testSendMessage() throws InterruptedException {
    // 创建 DragonFlyMessage 对象

    DragonFlyMessage message1 = new DragonFlyMessage("page1", "operateType1", "666");
    DragonFlyMessage message2 = new DragonFlyMessage("page2", "operateType2", "88");

    // 连续发送5条
    for (int i = 0; i < 15; i++) {
      msgSender.receiveMessage(message1);
      Thread.sleep(100); // 等待 0.05 秒
    }

    // 在 0.5 秒内再次发送相同的消息，应该被忽略
    msgSender.receiveMessage(message1);
    Thread.sleep(300); // 等待 0.6 秒

    // 在 0.5 秒内发送不同的消息，应该等待第一条消息执行完成后再发送
    msgSender.receiveMessage(message2);
    Thread.sleep(50); // 等待 0.6 秒

    // 在 0.5 秒内再次发送相同的消息，不该被忽略
    msgSender.receiveMessage(message1);
    Thread.sleep(100); // 等待 0.1 秒

    // 在 0.5 秒内发送不同的消息，应该等待第一条消息执行完成后再发送
    msgSender.receiveMessage(message2);
    Thread.sleep(2000); // 最后一个要等长一点
  }
}

// 用于模拟 DragonFlyLibV2 的测试替身（Stub）
class DragonFlyLibV2Stub extends DragonFlyLibV2 {

  long recordTime;

  @Override
  public void abcpStartService(String appId, String serviceCode, String content, OnAbcpFinish callbackOnFinish,
    OnAbcpProcess callbackOnProcess) {
    // 简单的打印日志，表示方法被调用
    System.out.println(
      "abcpStartService called with content: " + content + ",间隔:" + (System.currentTimeMillis() - recordTime) + "ms");
    recordTime = System.currentTimeMillis();
  }

  // 这里可以添加其他方法的模拟实现，如果有需要的话
}
