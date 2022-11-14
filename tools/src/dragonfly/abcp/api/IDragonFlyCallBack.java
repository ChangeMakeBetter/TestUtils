package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public interface IDragonFlyCallBack {

  void onFinish(int code, String subCode, String subMsg, String result);
}
