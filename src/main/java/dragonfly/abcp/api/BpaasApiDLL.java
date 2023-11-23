package dragonfly.abcp.api;

import com.sun.jna.Callback;
import com.sun.jna.Library;

/**
 * </br>
 * Created by yangxiaohua on 2021/3/8.
 */
public interface BpaasApiDLL extends Library {
  void abcp_init(int p_arg, String app_id, String app_version, String json_param, OnAbcpProcess on_process,
    OnAbcpFinish on_finish);

  void abcp_start_service(int p_arg, String app_id, String service_code, String json_param, OnAbcpProcess on_process,
    OnAbcpFinish on_finish);

  void iotsdk_get_biztid(int p_arg, int mode, BztidCallback callback);

  interface OnAbcpProcess extends Callback {
    void on_process(int p_arg, int code, String sub_code, String sub_msg, String result);
  }

  interface OnAbcpFinish extends Callback {
    void on_finish(int p_arg, int code, String sub_code, String sub_msg, String result);
  }

  interface BztidCallback extends Callback {
    void callback(int p_arg, String biztid);
  }

}
