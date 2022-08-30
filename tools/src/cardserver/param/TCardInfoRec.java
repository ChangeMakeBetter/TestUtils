package cardserver.param;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.tapestry.json.JSONObject;

public final class TCardInfoRec implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String FNCardNumber = "cardNumber";
  public static final String FNMedia = "media";
  public static final String FNCardType = "cardType";
  public static final String FNBalance = "balance";
  public static final String FNScore = "score";
  public static final String FNValidDate = "validDate";
  public static final String FNCardFunction = "cardFunction";
  public static final String FNCardHolder = "cardHolder";
  public static final String FNEnterpriseId = "enterpriseId";
  public static final String FNRandomNumber = "randomNumber";
  public static final String FNCardVersion = "cardVersion";
  public static final String FNUnSyncTotal = "unSyncTotal";
  public static final String FNTrackTwoData = "trackTwoData";
  public static final String FNCost = "cost";
  public static final String FNLastAction = "lastAction";
  public static final String FNLastActionTime = "lastActionTime";
  public static final String FNLimitBalance = "limitBalance";
  public static final String FNDepositCount = "depositCount";
  public static final String FNConsumeCount = "consumeCount";
  public static final String FNNoChipBalance = "noChipBalance";
  public static final String FNCVN = "CVN";
  public static final String FNAccountFunction = "accountFunction";
  public static final String FNCardTypeName = "cardTypeName";
  public static final String FNUsepwd = "usepwd";
  public static final String FNSaleDepCode = "saleDepCode";
  public static final String FNSaleDepName = "saleDepName";
  public static final String FNLstUpdTime = "lstUpdTime";
  public static final String FNSaleTime = "saleTime";
  public static final String FNAmount = "amount";
  public static final String FNGiftAmount = "giftAmount";
  public static final String FNState = "state";
  public static final String FNPASSWORD = "password";
  public static final String FNIssueOrgId = "issueOrgId";
  public static final String FNIssueOrgName = "issueOrgName";

  public static final String CARD_FUNCTION_0 = "0000000000";
  public static final String CARD_FUNCTION_1 = "1000000000";
  public static final String CARD_FUNCTION_11 = "1100000000";
  public static final String CARD_FUNCTION_001 = "0010000000";

  public String cardNumber;// 卡号
  public String media;// 卡介质
  public String cardType;// 卡类型
  public String cardTypeName;// 卡类型名称
  public BigDecimal balance;// 余额
  public BigDecimal score;// 积分
  public Date validDate;// 到效期
  public String cardFunction;// 卡功能
  public String cardHolder;// 持卡人
  public String enterpriseId;// 企业标识
  public String randomNumber;// 随机数
  public String cardVersion;// 卡版本
  public BigDecimal unSyncTotal;// 待同步金额
  public String trackTwoData;// 磁卡二轨数据
  public BigDecimal cost;// 卡成本
  public String lastAction;// 最后操作
  public Date lastActionTime;// 最后操作时间
  public BigDecimal limitBalance; // 账户最大金额
  public int depositCount; // 充值计数
  public int consumeCount; // 消费计数
  public boolean noChipBalance = false;// 不用芯片余额
  public String CVN;// CVN码
  public String accountFunction = "0000000000"; // 账户功能
  public boolean usepwd = false; // 是否使用卡支付密码, 默认不用
  public String saleDepCode;// 卡发售门店代码
  public String saleDepName;// 卡发售门店名称
  public Date lstUpdTime; // 最后交易时间
  public Date saleTime; // 售卡时间
  public BigDecimal amount; // 实充余额
  public BigDecimal giftAmount; // 返现余额
  public String state; // 卡状态
  public String password;//密码
  public String issueOrgId;// 发卡组织Id(对应门店code)
  public String issueOrgName;// 发卡组织Name(门店name)

  public TCardInfoRec() {
  }

  public TCardInfoRec(JSONObject jo) {
    if (jo == null) {
      return;
    }
    if (jo.has(FNCardNumber)) {
      cardNumber = jo.optString(FNCardNumber);
    }
    if (jo.has(FNMedia)) {
      media = jo.optString(FNMedia);
    }
    if (jo.has(FNCardType)) {
      cardType = jo.optString(FNCardType);
    }
    if (jo.has(FNBalance)) {
      balance = CardConverter.strToBigDecimal(jo.optString(FNBalance));
    }
    if (jo.has(FNScore)) {
      score = CardConverter.strToBigDecimal(jo.optString(FNScore));
    }
    if (jo.has(FNValidDate)) {
      validDate = CardConverter.strToDateValidate(jo.optString(FNValidDate));
    }
    if (jo.has(FNCardFunction)) {
      cardFunction = jo.optString(FNCardFunction);
    }
    if (jo.has(FNCardHolder)) {
      cardHolder = jo.optString(FNCardHolder);
    }
    if (jo.has(FNEnterpriseId)) {
      enterpriseId = jo.optString(FNEnterpriseId);
    }
    if (jo.has(FNRandomNumber)) {
      randomNumber = jo.optString(FNRandomNumber);
    }
    if (jo.has(FNCardVersion)) {
      cardVersion = jo.optString(FNCardVersion);
    }
    if (jo.has(FNUnSyncTotal)) {
      unSyncTotal = CardConverter.strToBigDecimal(jo.optString(FNUnSyncTotal));
    }
    if (jo.has(FNTrackTwoData)) {
      trackTwoData = jo.optString(FNTrackTwoData);
    }
    if (jo.has(FNCost)) {
      cost = CardConverter.strToBigDecimal(jo.optString(FNCost));
    }
    if (jo.has(FNLastAction)) {
      lastAction = jo.optString(FNLastAction);
    }
    if (jo.has(FNLastActionTime)) {
      lastActionTime = CardConverter.toDate(jo.optString(FNLastActionTime));
    }
    if (jo.has(FNLimitBalance)) {
      limitBalance = CardConverter.strToBigDecimal(jo.optString(FNLimitBalance));
    }
    if (jo.has(FNDepositCount)) {
      depositCount = jo.optInt(FNDepositCount);
    }
    if (jo.has(FNConsumeCount)) {
      consumeCount = jo.optInt(FNConsumeCount);
    }
    if (jo.has(FNNoChipBalance)) {
      noChipBalance = jo.optBoolean(FNNoChipBalance);
    }
    if (jo.has(FNCVN)) {
      CVN = jo.optString(FNCVN);
    }
    if (jo.has(FNAccountFunction)) {
      accountFunction = jo.optString(FNAccountFunction);
    }
    if (jo.has(FNCardTypeName)) {
      cardTypeName = jo.optString(FNCardTypeName);
    }
    if (jo.has(FNUsepwd)) {
      usepwd = jo.optBoolean(FNUsepwd);
    }
    if (jo.has(FNSaleDepCode)) {
      saleDepCode = jo.optString(FNSaleDepCode);
    }
    if (jo.has(FNSaleDepName)) {
      saleDepName = jo.optString(FNSaleDepName);
    }
    if (jo.has(FNLstUpdTime)) {
      lstUpdTime = CardConverter.toDate(jo.optString(FNLstUpdTime));
    }
    if (jo.has(FNSaleTime)) {
      saleTime = CardConverter.toDate(jo.optString(FNSaleTime));
    }
    if (jo.has(FNAmount)) {
      amount = CardConverter.strToBigDecimal(jo.optString(FNAmount));
    }
    if (jo.has(FNGiftAmount)) {
      giftAmount = CardConverter.strToBigDecimal(jo.optString(FNGiftAmount));
    }
    if (jo.has(FNState)) {
      state = jo.optString(FNState);
    }
    if (jo.has(FNPASSWORD)) {
      password = jo.optString(FNPASSWORD);
    }
    if (jo.has(FNIssueOrgId)) {
      issueOrgId = jo.optString(FNIssueOrgId);
    }
    if (jo.has(FNIssueOrgName)) {
      issueOrgName = jo.optString(FNIssueOrgName);
    }
  }

  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    jo.put(FNCardNumber, cardNumber);
    jo.put(FNMedia, media);
    jo.put(FNCardType, cardType);
    jo.put(FNBalance, CardConverter.bigDecimalToStr(balance));
    jo.put(FNScore, CardConverter.bigDecimalToStr(score));
    jo.put(FNValidDate, CardConverter.dateToStrValidate(validDate));
    jo.put(FNCardFunction, cardFunction);
    jo.put(FNCardHolder, cardHolder);
    jo.put(FNEnterpriseId, enterpriseId);
    jo.put(FNRandomNumber, randomNumber);
    jo.put(FNCardVersion, cardVersion);
    jo.put(FNUnSyncTotal, CardConverter.bigDecimalToStr(unSyncTotal));
    jo.put(FNTrackTwoData, trackTwoData);
    jo.put(FNCost, CardConverter.bigDecimalToStr(cost));
    jo.put(FNLastAction, lastAction);
    jo.put(FNLastActionTime, CardConverter.toString(lastActionTime));
    jo.put(FNLimitBalance, CardConverter.bigDecimalToStr(limitBalance));
    jo.put(FNConsumeCount, consumeCount);
    jo.put(FNDepositCount, depositCount);
    jo.put(FNNoChipBalance, noChipBalance);
    jo.put(FNCVN, CVN);
    jo.put(FNAccountFunction, accountFunction);
    jo.put(FNCardTypeName, cardTypeName);
    jo.put(FNUsepwd, usepwd);
    jo.put(FNSaleDepCode, saleDepCode);
    jo.put(FNSaleDepName, saleDepName);
    jo.put(FNLstUpdTime, CardConverter.toString(lstUpdTime));
    jo.put(FNSaleTime, CardConverter.toString(saleTime));
    jo.put(FNAmount, CardConverter.bigDecimalToStr(amount));
    jo.put(FNGiftAmount, CardConverter.bigDecimalToStr(giftAmount));
    jo.put(FNState, state);
    jo.put(FNPASSWORD, password);
    jo.put(FNIssueOrgId, issueOrgId);
    jo.put(FNIssueOrgName, issueOrgName);
    return jo;
  }

  @Override
  public TCardInfoRec clone() {
    TCardInfoRec r = new TCardInfoRec();
    r.cardNumber = cardNumber;
    r.media = media;
    r.cardType = cardType;
    r.balance = balance;
    r.score = score;
    r.validDate = validDate;
    r.cardFunction = cardFunction;
    r.cardHolder = cardHolder;
    r.enterpriseId = enterpriseId;
    r.randomNumber = randomNumber;
    r.cardVersion = cardVersion;
    r.unSyncTotal = unSyncTotal;
    r.trackTwoData = trackTwoData;
    r.cost = cost;
    r.lastAction = lastAction;
    r.lastActionTime = lastActionTime;
    r.limitBalance = limitBalance;
    r.depositCount = depositCount;
    r.consumeCount = consumeCount;
    r.noChipBalance = noChipBalance;
    r.CVN = CVN;
    r.accountFunction = accountFunction;
    r.cardTypeName = cardTypeName;
    r.usepwd = usepwd;
    r.saleDepCode = saleDepCode;
    r.saleDepName = saleDepName;
    r.lstUpdTime = lstUpdTime;
    r.amount = amount;
    r.giftAmount = giftAmount;
    r.state = state;
    r.password = password;
    r.issueOrgId = issueOrgId;
    r.issueOrgName = issueOrgName;
    return r;
  }

  public boolean oneOff() {
    return accountFunction != null && accountFunction.length() == 10
      && accountFunction.substring(0, 1).equals("1");
  }

  public void initCardInfo() {
    this.balance = BigDecimal.ZERO;
    this.score = BigDecimal.ZERO;
    this.cardFunction = "1000000000";
    this.unSyncTotal = BigDecimal.ZERO;
    this.cost = BigDecimal.ZERO;
    this.noChipBalance = false;
  }
}
