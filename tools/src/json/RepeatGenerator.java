package json;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/12/23.
 */
public class RepeatGenerator {

  public static void main(String[] args) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 250; i++) {
      result.append(buildTemplate());
    }
    System.out.println(result.toString());
  }

  private static String buildTemplate() {
    String a = String.valueOf((int) (10000 * Math.random() - 1));
    String b = String.valueOf((int) (10000 * Math.random() - 1));
    String template = "{ \"PacketTicket\": \"02c22258-2e5a-47e0-946f-ec856937" + a + "\","
      + "\"TicketID\": \"3aeae2ca-046a-4bcb-9806-aa4c00a4" + b
      + "\"},\n";
    return template;
  }
}
