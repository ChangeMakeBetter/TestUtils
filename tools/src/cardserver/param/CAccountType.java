package cardserver.param;

public final class CAccountType {

  public static final int ACCOUNTTYPE_CARDNUM = 0; // 卡号
  public static final int ACCOUNTTYPE_MOBILENUM = 1; // 手机号
  public static final int ACCOUNTTYPE_MEMBERCODE = 2; // 会员号
  public static final int ACCOUNTTYPE_IDCARD = 3; // 身份证号
  public static final int ACCOUNTTYPE_MEMBERID = 4;// 会员外部号
  public static final int ACCOUNTTYPE_ONEDIMENSIONALCODE = 5;// 一维码/二维码或动态识别码
  public static final int ACCOUNTTYPE_CLOUDMBRCODE = 6;// 鼎立云会员码
  public static final int ACCOUNTTYPE_FACERECOGNITION = 7;// 人脸识别类型
  public static final int ACCOUNTTYPE_WEIXINOPENID = 8;// 微信openid
  public static final int ACCOUNTTYPE_ALIPAYOPENID = 9;// 支付宝openid
  public static final int ACCOUNTTYPE_MAGBAR = 10; // 磁条，只在振华威海华联卡场景下传入

  public static final String CARDNUM_CAPTION = "卡号";
  public static final String MOBILENUM_CAPTION = "手机号";
  public static final String MEMBERCODE_CAPTION = "会员号";
  public static final String IDCARD_CAPTION = "身份证";
  public static final String MEMBERXID_CAPTION = "会员外部号";
  public static final String ONEDIMENSIONALCODE_CAPTION = "一维码或动态识别码";
  public static final String CLOUDMBRCODE_CAPTION = "鼎立云会员码";
  public static final String FACERECOGNITION_CAPTION = "人脸识别类型";
  public static final String WEIXINOPENID_CAPTION = "微信openid";
  public static final String ALIPAYOPENID_CAPTION = "支付宝openid";
  public static final String MAGBAR_CAPTION = "磁条";
  public static final String UNKOWN_CAPTION = "未知";

  public static String getCaption(int accountAccessCodeType) {
    if (0 == accountAccessCodeType) {
      return CARDNUM_CAPTION;
    } else if (1 == accountAccessCodeType) {
      return MOBILENUM_CAPTION;
    } else if (2 == accountAccessCodeType) {
      return MEMBERCODE_CAPTION;
    } else if (3 == accountAccessCodeType) {
      return IDCARD_CAPTION;
    } else if (4 == accountAccessCodeType) {
      return MEMBERXID_CAPTION;
    } else if (5 == accountAccessCodeType) {
      return ONEDIMENSIONALCODE_CAPTION;
    } else if (6 == accountAccessCodeType) {
      return CLOUDMBRCODE_CAPTION;
    } else if (7 == accountAccessCodeType) {
      return FACERECOGNITION_CAPTION;
    } else if (8 == accountAccessCodeType) {
      return WEIXINOPENID_CAPTION;
    } else if (9 == accountAccessCodeType) {
      return ALIPAYOPENID_CAPTION;
    } else if (10 == accountAccessCodeType) {
      return MAGBAR_CAPTION;
    } else {
      return "UNKOWN_CAPTION";
    }
  }

  public static boolean isCardNum(int accountType) {
    return ACCOUNTTYPE_CARDNUM == accountType;
  }

  public static boolean isMobileNum(int accountType) {
    return ACCOUNTTYPE_MOBILENUM == accountType;
  }

  public static boolean isMemberCode(int accountType) {
    return ACCOUNTTYPE_MEMBERCODE == accountType;
  }

  public static boolean isIDCard(int accountType) {
    return ACCOUNTTYPE_IDCARD == accountType;
  }

  public static boolean isMemberXID(int accountType) {
    return ACCOUNTTYPE_MEMBERID == accountType;
  }

  public static boolean isOneDimensionalCode(int accountType) {
    return ACCOUNTTYPE_ONEDIMENSIONALCODE == accountType;
  }

  public static boolean isCloudMbrCode(int accountType) {
    return ACCOUNTTYPE_CLOUDMBRCODE == accountType;
  }

  public static boolean isFaceRecognition(int accountType) {
    return ACCOUNTTYPE_FACERECOGNITION == accountType;
  }

  public static boolean isWeixinOpenid(int accountType) {
    return ACCOUNTTYPE_WEIXINOPENID == accountType;
  }

  public static boolean isAlipayOpenid(int accountType) {
    return ACCOUNTTYPE_ALIPAYOPENID == accountType;
  }

  public static boolean isMagBar(int accountType) {
    return ACCOUNTTYPE_MAGBAR == accountType;
  }

  public static int getDefault() {
    return ACCOUNTTYPE_CARDNUM;
  }

  public static boolean isValid(int accountType) {
    return ACCOUNTTYPE_CARDNUM <= accountType && accountType <= ACCOUNTTYPE_ALIPAYOPENID;
  }

}
