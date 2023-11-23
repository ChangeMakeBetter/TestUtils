package dragonfly.abcp.api;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/9.
 */
public interface DragonFlyConsts {

  // 组件代码
  String SERVICECODE = "BPaaSTemplatePosV1";

  //执行器.固定值
  String BPAASEXECUTOR = "dragonfly";

  //业务展示页
  String PAGE_SKU = "sku"; //展示商品
  String PAGE_OPENCARD = "opencard"; //会员开卡，登录
  String PAGE_FACEVERIFY = "faceVerify"; //刷脸
  String PAGE_TOAST = "toast"; //弹框
  String PAGE_PAYRESULT = "payResult"; //支付结果页
  String PAGE_ALL = "all"; //顶部第一个页面

  //业务动作
  String OPER_SHOW = "show";
  String OPER_VERIFY = "verify";
  String OPER_UPDATE = "update";
  String OPER_POP = "pop"; //退出页面

  // 开卡模式
  String CALLBACKTYPE_SPI = "SPI"; //新版开卡方式
  String CALLBACKTYPE_OPENAPI = "OPENAPI"; //旧版开卡方式

  //响应码
  int CODE_SUCCESS = 1000;
  String SUBCODE_SUCCESS = "E00000";

  //支付
  int PAYSTATUS_PAYING = 1;
  int PAYSTATUS_FAILED = 2;
  String DYNAMICIDTYPE = "outer_pay";
  String PAYFAILEDCODE_OTHER = "2001"; // 支付失败code。jpos暂时无法区分。先传个其他
}

