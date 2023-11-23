package cardserver.param;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

public final class TQueryCardRequest extends TRequestData {
  private static final long serialVersionUID = 1L;

  public static final String FNNeedMemberTags = "needMemberTags";
  public static final String FNQueryBusType = "queryBusType";

  public static final String CCommand = "queryCard";
  public static final String CCommandHD = "queryCardHD";
  public static final String FNCardInfo = "cardInfo";
  public static final String FNAccountType = "accountType";
  public static final String FNSendPassword = "sendPassword";
  public static final String FNTranType = "TranType";
  public static final String FNAccountAccessCode = "accountAccessCode";
  public static final String CQueryType_forQuery = "queryCard";
  public static final String FNQueryType = "queryType";
  public static final String FNNeedMemberInfo = "needMemberInfo";
  public static final String FNPayPassword = "payPassword";
  public static final String FNCheckPayPassword = "checkPayPassword";
  public static final String FNVerifyCVN = "verifyCVN";

  public static final String CSMediaIc = "IC";
  public static final String CSMediaMag = "MAG";
  public static final String CSMediaBar = "BAR";

  public static final int CIAccountType_CardNum = 0;
  public static final int CIAccountType_MobileNum = 1;
  public static final int CIAccountType_MemberId = 2;

  public static final String CFeeType_ReportLoss = "ReportLoss";
  public static final String CFeeType_SaleCard = "SaleCard";
  public static final String CFeeType_RelatCard = "RelatCard";

  public static final String FNCardServerCheck = "cardServerCheck";
  public static final String FNCardNumberType = "accountType";

  public static final String FNMustQueryNCardServer = "mustQueryNCardServer";

  public TCardInfoRec cardInfo = new TCardInfoRec();

  /**
   * @deprecated {@link #FNAccountType}
   */
  @Deprecated
  public static final String FNMobilePhoneNum = "mobilePhoneNum";
  /**
   * @deprecated {@link #FNAccountType}
   */
  @Deprecated
  public static final String FNMemberId = "memberId";
  /**
   * @deprecated {@link #FNAccountType}
   */
  @Deprecated
  public static final String FNIsMobilePhoneNum = "isMobilePhoneNum";
  /**
   * @deprecated {@link #accountType}
   */
  @Deprecated
  public String isMobilePhoneNum; // 是否为手机号 0 or null---卡号 1---手机号 2---会员ID
  // 3---身份证号
  /**
   * @deprecated {@link #accountAccessCode}
   */
  @Deprecated
  public String mobilePhoneNum; // 手机号
  /**
   * @deprecated {@link #accountAccessCode}
   */
  @Deprecated
  public String memberId; // 会员号

  public String queryType = CQueryType_forQuery; // 查询业务类型，默认为普通查询(老cardServer跟实体卡查询校验这卡状态有关)
  public boolean needMemberInfo = false; // 是否返回会员信息,默认否

  public String accountAccessCode;// 帐户标识代码
  public String sendPassword; // 是否发送消费密码 0---不发送 1---发送
  public String tranType;// 交易类型(老cardServer跟发送密码相关)

  public String payPassword; // 支付密码
  public boolean checkPayPassword = false; // 是否验证密码
  public boolean verifyCVN = false;

  public boolean cardServerCheck;

  // 关于accountType和cardNumberType的问题：
  // jpos使用的是cardNumberType，但是cardserver-api是没有cardNumberType这个字段的。
  // 此类在toString时，“accountType” key最终传值的是cardNumberType。
  // 因此，为了降低jpos的改动风险，以后使用csp-api时，queryCard统一将cardNumberType赋值与accountType一样

  /**
   * @deprecated 此字段在toString时被cardNumberType覆盖了。因此只需要给cardNumberType传值即可
   */
  @Deprecated
  public int accountType = CAccountType.getDefault();

  /**
   * 账户类型
   *
   * @see CAccountType 账户类型常量
   */
  public int cardNumberType = CAccountType.getDefault();

  /**
   * crm3服务,是否必须在线查询
   */
  public boolean mustQueryNCardServer = false;

  public TQueryCardRequest() {
    super();
    command = CCommand;
  }

  public TQueryCardRequest(String aString) throws ParseException {
    super(aString);
    if (jo.has(FNIsMobilePhoneNum)) {
      isMobilePhoneNum = jo.optString(FNIsMobilePhoneNum);
      accountType = getAccountType();
    }
    if (jo.has(FNMobilePhoneNum)) {
      mobilePhoneNum = jo.optString(FNMobilePhoneNum);
    }
    if (jo.has(FNMemberId)) {
      memberId = jo.optString(FNMemberId);
    }

    if (jo.has(FNQueryType)) {
      queryType = jo.optString(FNQueryType);
    }
    if (jo.has(FNNeedMemberInfo)) {
      needMemberInfo = jo.optBoolean(FNNeedMemberInfo);
    }
    if (jo.has(FNCardInfo)) {
      cardInfo = new TCardInfoRec(jo.getJSONObject(FNCardInfo));
    }
    if (jo.has(FNTranType)) {
      tranType = jo.optString(FNTranType);
    }
    if (jo.has(FNSendPassword)) {
      sendPassword = jo.optString(FNSendPassword);
    }
    if (jo.has(FNAccountType)) {
      accountType = jo.optInt(FNAccountType);
      if ((CAccountType.isCardNum(accountType) || CAccountType.isOneDimensionalCode(accountType))
        && cardInfo.cardNumber != null) {
        accountAccessCode = cardInfo.cardNumber.trim();
      } else if (CAccountType.isMobileNum(accountType)) {
        accountAccessCode = mobilePhoneNum;
      } else if (CAccountType.isMemberCode(accountType)) {
        accountAccessCode = memberId;
      }
    }
    if (jo.has(FNAccountAccessCode)) {
      accountAccessCode = jo.optString(FNAccountAccessCode);
      if (CAccountType.isCardNum(accountType)) {
        cardInfo.cardNumber = accountAccessCode;
      } else if (CAccountType.isMobileNum(accountType)) {
        mobilePhoneNum = accountAccessCode;
      } else if (CAccountType.isMemberCode(accountType)) {
        memberId = accountAccessCode;
      }
    }
    if (jo.has(FNPayPassword)) {
      payPassword = jo.optString(FNPayPassword);
    }
    if (jo.has(FNCheckPayPassword)) {
      checkPayPassword = jo.optBoolean(FNCheckPayPassword);
    }
    if (jo.has(FNVerifyCVN)) {
      verifyCVN = jo.optBoolean(FNVerifyCVN);
    }

    if (jo.has(FNNeedMemberTags)) {
      needMemberTags = jo.optBoolean(FNNeedMemberTags, false);
    }
    if (jo.has(FNQueryBusType)) {
      queryBusType = jo.optString(FNQueryBusType);
    }

    if (jo.has(FNCardServerCheck)) {
      cardServerCheck = jo.optBoolean(FNCardServerCheck);
    }
    if (jo.has(FNCardNumberType)) {
      cardNumberType = jo.optInt(FNCardNumberType);
    }
    if (jo.has(FNMustQueryNCardServer)) {
      mustQueryNCardServer = jo.optBoolean(FNMustQueryNCardServer);
    }
  }

  public boolean needSendSMS() {
    // 原有代码逻辑
    // return CAccountType.isMobileNum(accountType) && accountAccessCode != null
    // && !"".equals(accountAccessCode.trim()) && "1".equals(sendPassword);

    // jpos Override的逻辑
    return StringUtils.isNotBlank(mobilePhoneNum)
      && StringUtils.equalsIgnoreCase("1", sendPassword);
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNIsMobilePhoneNum, getsAccountType());
    jo.put(FNMobilePhoneNum, mobilePhoneNum);
    jo.put(FNMemberId, memberId);
    jo.put(FNNeedMemberInfo, needMemberInfo);
    jo.put(FNQueryType, queryType);
    jo.put(FNTranType, tranType);
    jo.put(FNCardInfo, cardInfo.toJson());
    jo.put(FNSendPassword, sendPassword);
    jo.put(FNAccountType, accountType);
    jo.put(FNAccountAccessCode, accountAccessCode);
    jo.put(FNPayPassword, payPassword);
    jo.put(FNCheckPayPassword, checkPayPassword);
    jo.put(FNVerifyCVN, verifyCVN);

    jo.put(FNNeedMemberTags, needMemberTags);
    jo.put(FNQueryBusType, queryBusType);

    jo.put(FNCardServerCheck, cardServerCheck);
    jo.put(FNCardNumberType, cardNumberType);
    jo.put(FNMustQueryNCardServer, mustQueryNCardServer);
    return jo.toString();
  }

  private int getAccountType() {
    if (isMobilePhoneNum == null || "".equals(isMobilePhoneNum)) {
      return CAccountType.getDefault();
    } else {
      return Integer.parseInt(isMobilePhoneNum);
    }
  }

  private String getsAccountType() {
    return Integer.valueOf(accountType).toString();
  }

  public boolean needMemberTags = false;

  public String queryBusType;

}
