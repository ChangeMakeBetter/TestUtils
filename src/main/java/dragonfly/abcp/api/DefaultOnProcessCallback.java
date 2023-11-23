package dragonfly.abcp.api;

import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/10.
 */
public class DefaultOnProcessCallback implements OnAbcpProcess {
  @Override
  public void on_process(int p_arg, int code, String sub_code, String sub_msg, String result) {
    //doNothing
  }
}
