package cardserver.param;

import java.math.BigDecimal;
import java.util.Date;

public class MemberInfo {

  public static final String CQueryType_forQuery = "queryCard";
  public static final String CQueryType_forSale = "saleCard";

  public static final String CCommand = "queryCard";
  public static final String CCommandHD = "queryCardHD";

  private String code; // in, 代码, 可以是卡号,手机号等
  private int codeType = CODETYPE_SCANNER; // in, 代码类型, 取值见以下定义.

  /**
   * 手机号
   */
  public static final int CODETYPE_MOBILEPHONENUMBER = 11;

  /**
   * 外部会员号
   */
  public static final int CODETYPE_MEMBERXID = 12;

  /**
   * 会员账号
   */
  public static final int CODETYPE_MEMBERCODE = 31;

  // *********************卡号************************//
  /**
   * 磁卡卡号
   */
  public static final int CODETYPE_MSR = 21;

  /**
   * 条码卡号
   */
  public static final int CODETYPE_SCANNER = 22;

  /**
   * IC卡号
   */
  public static final int CODETYPE_SC = 23;

  private String cardType; // in
  private String cardVersion; // in
  private String cardEnterpriseId; // in
  private String cardRandomNumber; // in

  // com.hd123.card.ejb.manager.secure.checkcardinfo.sposValidateIC()要求这些数据
  private String cardHolder; // in
  private BigDecimal balance; // in
  private BigDecimal limitBalance;// in

  private Date expire; // inout;

  // 卡号， 由cardserver返回，一定是明确卡号，不是手机号。也可能是会员号(联华TS场景),
  // 取TQueryCardResponse.memberInfo.code
  private String memberNumber;

  // 会员卡号，取 TQueryCardResponse.cardInfo.cardNumber,一定是卡号,目前给联华便利积分上传用
  private String cardNumber;

  /**
   * 卡功能, 由CardFunction解释
   */
  private String cardFunction; // out,

  /**
   * card 会员等级
   */
  private String memberGrade;

  private boolean isBirthdate = false; // out
  private Date birthday = null; // out

  /**
   * 账户ID
   */
  private String accountUuid;

  private int retCode = RETCODE_NONE; // out
  public static final int RETCODE_OK = 0;
  public static final int RETCODE_ERROR = 1;
  public static final int RETCODE_NONE = 2; // IC卡拔出,或其它卡清除了输入

  /**
   * 系统错误,不能继续进行,需中断
   */
  public static final int RETCODE_SYSTEMERROR = 3;
  private int errorCode; // 服务端错误代码
  private String errorMessage; // 服务端错误信息

  private String memberTypeName;// out

  private String memberName;// out

  private BigDecimal score;// out

  /**
   * 卡成本
   */
  private BigDecimal cost;

  private String saleDepName;
  private String saleDepCode;

  private String lastAction;
  private Date lastActionTime;
  private int depositCount;
  private int consumeCount;

  /**
   * 性别:-1:未知;0:男;1:女
   */
  private int sex = -1;

  private String memberTel;

  private BigDecimal memGradePay;

  private Date memGradeValidate;

  private String memGradeMessage;

  private String memberId;
  private String realMemberId;

  public String queryType = CQueryType_forQuery;

  public Date lastMbrUpGradeTime;

  public Date mbrRegisterTime;

  public String command = CCommand;
  private boolean isSendPassword;

  /**
   * 售卡时间
   */
  private Date saleTime;

  /**
   * 会员渠道
   */
  private String mbrChannel;

  public static final String STATUS_NORMAL = "NORMAL";
  public static final String STATUS_FROZEN = "FROZEN";
  public static final String STATUS_DELETED = "DELETED";
  public static final String STATUS_UNACTIVATED = "UNACTIVATED";

  /**
   * 会员状态, NORMAL("正常"), FROZEN("已冻结"), DELETED("已删除"), UNACTIVATED("未激活")
   */
  public String status;

  private String keyboardInput;

  public String promptMsg;

  public String remark;

  private int initailIdentType;

  private boolean isHandInput = false;

  private BigDecimal cashBackBalance;

  private UCN store;

  private String cardMedia;

  private String cardState;

  /**
   * 身份证号
   */
  private String identityNumber;

  public static boolean equals(String a, String b) {
    if (a == null) {
      return b == null;
    }

    return a.equals(b);
  }

  public MemberInfo() {

  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getCodeType() {
    return codeType;
  }

  public void setCodeType(int codeType) {
    this.codeType = codeType;
  }

  public String getCardFunction() {
    return cardFunction;
  }

  public void setCardFunction(String functions) {
    this.cardFunction = functions;
  }

  public String getMemberTel() {
    return memberTel;
  }

  public void setMemberTel(String memberTel) {
    this.memberTel = memberTel;
  }

  public boolean isBirthdate() {
    return isBirthdate;
  }

  public void setBirthdate(boolean isBirthdate) {
    this.isBirthdate = isBirthdate;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public int getRetCode() {
    return retCode;
  }

  public void setRetCode(int retCode) {
    this.retCode = retCode;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public Date getExpire() {
    return expire;
  }

  public void setExpire(Date expire) {
    this.expire = expire;
  }

  public String getCardVersion() {
    return cardVersion;
  }

  public void setCardVersion(String cardVersion) {
    this.cardVersion = cardVersion;
  }

  public String getCardEnterpriseId() {
    return cardEnterpriseId;
  }

  public void setCardEnterpriseId(String cardEnterpriseId) {
    this.cardEnterpriseId = cardEnterpriseId;
  }

  public String getCardRandomNumber() {
    return cardRandomNumber;
  }

  public void setCardRandomNumber(String cardRandomNumber) {
    this.cardRandomNumber = cardRandomNumber;
  }

  public void setSaleDepName(String saleDepName) {
    this.saleDepName = saleDepName;
  }

  public String getSaleDepName() {
    return saleDepName;
  }

  public String getSaleDepCode() {
    return saleDepCode;
  }

  public void setSaleDepCode(String saleDepCode) {
    this.saleDepCode = saleDepCode;
  }

  public String getCardHolder() {
    return cardHolder;
  }

  public void setCardHolder(String cardHolder) {
    this.cardHolder = cardHolder;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getLimitBalance() {
    return limitBalance;
  }

  public void setLimitBalance(BigDecimal limitBalance) {
    this.limitBalance = limitBalance;
  }

  public String getAccountUuid() {
    return accountUuid;
  }

  public void setAccountUuid(String accountUuid) {
    this.accountUuid = accountUuid;
  }

  public String getQueryType() {
    return queryType;
  }

  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }

  public String getMemberTypeName() {
    return memberTypeName;
  }

  public void setMemberTypeName(String memberTypeName) {
    this.memberTypeName = memberTypeName;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public BigDecimal getScore() {
    return score;
  }

  public void setScore(BigDecimal score) {
    this.score = score;
  }

  public String getMemberGrade() {
    return memberGrade;
  }

  public void setMemberGrade(String memberGrade) {
    this.memberGrade = memberGrade;
  }

  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  public String getLastAction() {
    return lastAction;
  }

  public void setLastAction(String lastAction) {
    this.lastAction = lastAction;
  }

  public Date getLastActionTime() {
    return lastActionTime;
  }

  public void setLastActionTime(Date lastActionTime) {
    this.lastActionTime = lastActionTime;
  }

  public int getDepositCount() {
    return depositCount;
  }

  public void setDepositCount(int depositCount) {
    this.depositCount = depositCount;
  }

  public int getConsumeCount() {
    return consumeCount;
  }

  public void setConsumeCount(int consumeCount) {
    this.consumeCount = consumeCount;
  }

  public int getSex() {
    return sex;
  }

  public void setSex(int sex) {
    this.sex = sex;
  }

  public BigDecimal getMemGradePay() {
    return memGradePay;
  }

  public void setMemGradePay(BigDecimal memGradePay) {
    this.memGradePay = memGradePay;
  }

  public Date getMemGradeValidate() {
    return memGradeValidate;
  }

  public void setMemGradeValidate(Date memGradeValidate) {
    this.memGradeValidate = memGradeValidate;
  }

  public String getMemGradeMessage() {
    return memGradeMessage;
  }

  public void setMemGradeMessage(String memGradeMessage) {
    this.memGradeMessage = memGradeMessage;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getRealMemberId() {
    return realMemberId;
  }

  public void setRealMemberId(String realMemberId) {
    this.realMemberId = realMemberId;
  }

  public String getCodeTypeStr() {
    if (CODETYPE_MOBILEPHONENUMBER == codeType) {
      return "手机号码";
    } else if (CODETYPE_MSR == codeType) {
      return "磁卡";
    } else if (CODETYPE_SCANNER == codeType) {
      return "条码卡";
    } else if (CODETYPE_SC == codeType) {
      return "IC卡";
    }

    return "未知";
  }

  public Date getLastMbrUpGradeTime() {
    return lastMbrUpGradeTime;
  }

  public void setLastMbrUpGradeTime(Date lastMbrUpGradeTime) {
    this.lastMbrUpGradeTime = lastMbrUpGradeTime;
  }

  public Date getMbrRegisterTime() {
    return mbrRegisterTime;
  }

  public void setMbrRegisterTime(Date mbrRegisterTime) {
    this.mbrRegisterTime = mbrRegisterTime;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public boolean isSendPassword() {
    return isSendPassword;
  }

  public void setSendPassword(boolean isSendPassword) {
    this.isSendPassword = isSendPassword;
  }

  public Date getSaleTime() {
    return saleTime;
  }

  public void setSaleTime(Date saleTime) {
    this.saleTime = saleTime;
  }

  public String getMbrChannel() {
    return mbrChannel;
  }

  public void setMbrChannel(String mbrChannel) {
    this.mbrChannel = mbrChannel;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getKeyboardInput() {
    return keyboardInput;
  }

  public void setKeyboardInput(String keyboardInput) {
    this.keyboardInput = keyboardInput;
  }

  public String getPromptMsg() {
    return promptMsg;
  }

  public void setPromptMsg(String promptMsg) {
    this.promptMsg = promptMsg;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public int getInitailIdentType() {
    return initailIdentType;
  }

  public void setInitailIdentType(int initailIdentType) {
    this.initailIdentType = initailIdentType;
  }

  public boolean isHandInput() {
    return isHandInput;
  }

  public void setHandInput(boolean handInput) {
    isHandInput = handInput;
  }

  public String getMemberNumber() {
    return memberNumber;
  }

  public void setMemberNumber(String memberNumber) {
    this.memberNumber = memberNumber;
  }

  public BigDecimal getCashBackBalance() {
    return cashBackBalance;
  }

  public void setCashBackBalance(BigDecimal cashBackBalance) {
    this.cashBackBalance = cashBackBalance;
  }

  public UCN getStore() {
    return store;
  }

  public void setStore(UCN store) {
    this.store = store;
  }

  public String getCardMedia() {
    return cardMedia;
  }

  public void setCardMedia(String cardMedia) {
    this.cardMedia = cardMedia;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardState() {
    return cardState;
  }

  public void setCardState(String cardState) {
    this.cardState = cardState;
  }

  public String getIdentityNumber() {
    return identityNumber;
  }

  public void setIdentityNumber(String identityNumber) {
    this.identityNumber = identityNumber;
  }
}
