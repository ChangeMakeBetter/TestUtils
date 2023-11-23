package dragonfly.abcp.demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import dragonfly.abcp.api.AbcpInvoke;
import dragonfly.abcp.api.AbcpTask;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;
import dragonfly.abcp.api.DragonFlyConsts;
import dragonfly.abcp.api.IDragonFlyCallBack;

/**
 * </br>
 * Created by yangxiaohua on 2022/9/29.
 */
public class AbcpTaskTemplatePos implements AbcpTask {

  private AbcpTaskTemplatePos() {
  }

  private AbcpTaskTemplatePos(String appId) {
    this.appId = appId;
  }

  private static AbcpTaskTemplatePos instance;

  public static AbcpTaskTemplatePos Instance(String appId) {
    if (instance == null) {
      instance = new AbcpTaskTemplatePos(appId);
    }
    return instance;
  }

  private String appId; // pelase fetch this from abcp server platform!

  @Override
  public void start(String serviceParams, IDragonFlyCallBack callBack) {
    System.out.println("AbcpTaskTemplatePos request:" + serviceParams);
    AbcpInvoke.getInstance().abcpStartService(appId, DragonFlyConsts.SERVICECODE, serviceParams, new OnAbcpFinish() {
      @Override
      public void on_finish(int p_arg, int code, String sub_code, String sub_msg, String result) {
        //TODO
        System.out.printf("AbcpTaskTemplatePos Start finish: [%d:%s] %s %n", code, sub_code, result);
        try {
          byte[] b2 = result.getBytes("GBK");
          System.out.println("GBK_TO_UTF8:" + new String(b2, StandardCharsets.UTF_8));
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
        callBack.onFinish(code, sub_code, sub_msg, result);
      }
    }, new OnAbcpProcess() {
      @Override
      public void on_process(int p_arg, int code, String sub_code, String sub_msg, String result) {
      }
    });

  }

  @Override
  public void stop(String serviceParam, IDragonFlyCallBack callBack) {
    System.out.println("AbcpTaskTemplatePos stop request:" + serviceParam);
    AbcpInvoke.getInstance().abcpStartService(appId, DragonFlyConsts.SERVICECODE, serviceParam, new OnAbcpFinish() {
      @Override
      public void on_finish(int p_arg, int code, String sub_code, String sub_msg, String result) {
        System.out.printf("AbcpTaskTemplatePos pop finish: [%d:%s] %s %n", code, sub_code, result);
        callBack.onFinish(code, sub_code, sub_msg, result);
      }
    }, new OnAbcpProcess() {
      @Override
      public void on_process(int p_arg, int code, String sub_code, String sub_msg, String result) {
        System.out.printf("AbcpTaskTemplatePos pop process: [%d:%s] %n", code, sub_code);
      }
    });
  }

}
