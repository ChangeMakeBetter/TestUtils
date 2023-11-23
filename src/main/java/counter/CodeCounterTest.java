package counter;

/**
 * </br>
 * Created by yangxiaohua on 2022/7/26.
 */
public class CodeCounterTest {

  public static void main(String[] args) {

    CodeCounter cc = new CodeCounter();

    String fileName = new String("C:\\Users\\yangxiaohua\\Desktop\\stps\\Step2PanelSettings.java");

    cc.codeCounterRun(fileName);

  }
}
