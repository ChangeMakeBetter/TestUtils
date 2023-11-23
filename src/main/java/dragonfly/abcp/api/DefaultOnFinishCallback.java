package dragonfly.abcp.api;

import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;

/**
 * 默认回调</br> Created by yangxiaohua on 2022/10/10.
 */
public class DefaultOnFinishCallback implements OnAbcpFinish {
  @Override
  public void on_finish(int p_arg, int code, String sub_code, String sub_msg, String result) {
    //doNothing
  }
}
