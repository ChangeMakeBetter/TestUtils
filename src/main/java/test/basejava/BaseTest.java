package test.basejava;

/**
 * TestUtils<br> Created by yangxiaohua on 2020/4/20.
 */
public class BaseTest {

  public static void main(String[] args) {
    BasePayResponse res = new BasePayResponse();
    ReturnData<BasePayResponse> rd = new ReturnData<>();
    res.setValue("New Value");
    rd.setData(res);

    // 此时 res 的值已经在 handlePayResponse 函数内修改

    BasePayResponse res2 = new BasePayResponse();
    handlePayRes2(rd, res2);

    System.out.println(res2.getValue());
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
