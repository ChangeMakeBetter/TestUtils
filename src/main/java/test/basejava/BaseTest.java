package test.basejava;

/**
 * TestUtils<br> Created by yangxiaohua on 2020/4/20.
 */
public class BaseTest {

  public static void main(String[] args) {

    PersonCaller pc = new PersonCaller(new Man("yangxiaohua", 18));

    Man manCopy = pc.getMan();
    manCopy.setName("yangxiaohua2");

    System.out.println(manCopy.getName());
    System.out.println(pc.getMan().getName());
  }

  static class ReturnData<T> {
    private T data;

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }
  }

  static class BasePayResponse {
    private String value;

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }

  static void handlePayRes2(ReturnData<BasePayResponse> rd, BasePayResponse res) {
    res = rd.getData();
  }

}
