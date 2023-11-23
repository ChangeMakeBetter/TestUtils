package cardserver.param;

import java.io.Serializable;

import org.apache.tapestry.json.JSONObject;

public class TRetCode implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String FNCode = "code";
  public static final String FNMessage = "message";
  private int code;
  private String message;

  public TRetCode() {
    super();
  }

  public TRetCode(int aCode, String aMessage) {
    this();
    this.code = aCode;
    this.message = aMessage;
  }

  public TRetCode(JSONObject jo) {
    if (jo == null) {
      return;
    }
    if (jo.has(FNCode)) {
      code = jo.optInt(FNCode);
    }
    if (jo.has(FNMessage)) {
      message = jo.optString(FNMessage);
    }
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(FNCode, code);
    jo.put(FNMessage, message);
    return jo;
  }

  public boolean IsOK() {
    return code == OK.code;
  }

  public boolean IsNoResponse() {
    return getCode() == NoResponse.getCode();
  }

  public static TRetCode createGeneralError(Exception e) {
    return createGeneralError(e.getMessage());
  }

  public static TRetCode createGeneralError(String msg) {
    return new TRetCode(GeneralError.code, msg);
  }

  @Override
  public TRetCode clone() {
    return new TRetCode(code, message);
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  /**
   * 系统相关
   */
  public static final TRetCode OK = new TRetCode(96960, "OK");
  public static final TRetCode FAILURE = new TRetCode(-1, "操作失败");
  public static final TRetCode NoResponse = new TRetCode(-7014, "服务未响应");
  public static final TRetCode InvalidSession = new TRetCode(2, "Invalid session");
  public static final TRetCode CardServerUnavailable = new TRetCode(3, "卡服务器不可用");
  public static final TRetCode InvalidWireDataFormat = new TRetCode(5, "请求的数据格式错误");
  public static final TRetCode GeneralError = new TRetCode(6, "其它错误");
  public static final TRetCode NotImplemented = new TRetCode(501, "功能未实现");

  /**
   * 充值卡相关
   */
  public static final TRetCode imprestCardStateOk = new TRetCode(400, "充值卡状态正常");
  public static final TRetCode invalidImprestCard = new TRetCode(401, "充值卡不是本系统发行卡");
  public static final TRetCode imprestCardInBlacklist = new TRetCode(402, "充值卡是黑卡");
  public static final TRetCode imprestCardSaled = new TRetCode(403, "充值卡已发售");
  public static final TRetCode imprestCardUnsaled = new TRetCode(404, "充值卡未发售");
  public static final TRetCode imprestCardExpired = new TRetCode(405, "充值卡过到效期");
  public static final TRetCode imprestCardNotEnoughMoney = new TRetCode(406, "充值卡余额不足");
  public static final TRetCode imprestCardNotExist = new TRetCode(407, "充值卡不存在");
  public static final TRetCode imprestCardPasswordError = new TRetCode(408, "充值卡密码不正确");
  public static final TRetCode imprestCardPasswordErrorLimited = new TRetCode(409, "密码次数超限");
  public static final TRetCode imprestCardLimited = new TRetCode(410, "充值卡受限");

  /**
   * 交易相关
   */
  public static final TRetCode tranExist = new TRetCode(300, "交易存在");
  public static final TRetCode oldTranNotExist = new TRetCode(301, "原交易不存在");
  public static final TRetCode tranAmountOverrun = new TRetCode(302, "交易金额超限");
  public static final TRetCode tranCanceled = new TRetCode(303, "交易已取消");
  public static final TRetCode tranProcessing = new TRetCode(304, "交易进行中");
  public static final TRetCode UnknownCommand = new TRetCode(1, "Unknown command"); // 也代表交易类型不存在

  /*** 卡机设备相关 */
  public static final TRetCode deviceOk = new TRetCode(304, "卡机状态正常");
  public static final TRetCode deviceNoCard = new TRetCode(304, "卡机内无卡");
  public static final TRetCode readCardFail = new TRetCode(304, "读卡失败");
  public static final TRetCode writeCardFail = new TRetCode(304, "写卡失败");
  public static final TRetCode deviceFail = new TRetCode(-2, "Device return fail"); // 也代表卡机没有初始化

  /*** 储值卡相关 */
  public static final TRetCode cardStateOk = new TRetCode(100, "卡状态正常");
  public static final TRetCode invalidCard = new TRetCode(101, "不是本系统发行卡");
  public static final TRetCode cardSaled = new TRetCode(103, "卡已发售");
  public static final TRetCode cardUnsaled = new TRetCode(104, "卡未发售");
  public static final TRetCode cardExpired = new TRetCode(105, "卡过到效期");
  public static final TRetCode cardNotExist = new TRetCode(107, "卡不存在");
  public static final TRetCode cardPasswordError = new TRetCode(108, "交易密码不正确");
  public static final TRetCode cardReissue = new TRetCode(109, "卡已补发");
  public static final TRetCode cardPasswordErrorLimited = new TRetCode(110, "密码次数超限");
  public static final TRetCode cardLimited = new TRetCode(111, "受限卡");
  public static final TRetCode UnknownMedia = new TRetCode(4, "未知的介质类型");
  public static final TRetCode InBlackList = new TRetCode(31, "黑卡");
  public static final TRetCode NoEnoughMoney = new TRetCode(41, "余额不足");
  public static final TRetCode returnAmountError = new TRetCode(63, "退货金额大于消费金额");
  public static final TRetCode unSyncAmountError = new TRetCode(64, "待同步金额为0");
  public static final TRetCode needPasswordError = new TRetCode(65, "支付码已过期,请输入密码");

  /**
   * 会员相关
   */
  public static final TRetCode memberStateOk = new TRetCode(600, "会员状态正常");
  public static final TRetCode NotFountMember = new TRetCode(51, "没找到会员");
  public static final TRetCode memberAlreadyHaveCard = new TRetCode(61, "会员已关联卡");

  /**
   * 终端相关
   */
  public static final TRetCode terminalStateOk = new TRetCode(20, "终端状态正常");
  public static final TRetCode TerminalInvalidRegisterNumber = new TRetCode(21, "Invalid register number");
  public static final TRetCode TerminalAlreadExists = new TRetCode(22, "Terminal with the same ID already exists");
  public static final TRetCode TerminalNotRegister = new TRetCode(23, "Terminal not registered");
  public static final TRetCode TerminalExpired = new TRetCode(24, "Terminal expired");
  public static final TRetCode TerminalFeatureError = new TRetCode(25, "Terminal feature error");
  public static final TRetCode TerminalDisabled = new TRetCode(26, "终端被禁用");
  public static final TRetCode TerminalFuntionDisabled = new TRetCode(27, "终端禁用该功能");

  /**
   * 用户相关
   */
  public static final TRetCode UserNotRegister = new TRetCode(11, "Invalid user");
  public static final TRetCode UserPasswordError = new TRetCode(12, "密码错误");
  public static final TRetCode UserAlreadyExists = new TRetCode(13, "User with the same ID already exists");

}
