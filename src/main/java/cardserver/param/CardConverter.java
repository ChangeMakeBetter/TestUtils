package cardserver.param;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardConverter {

  private static SimpleDateFormat sdf_yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static SimpleDateFormat sdfValidate = new SimpleDateFormat("yyyy-M-d");

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static String toString(Date date) {
    synchronized (sdf_yMdHms) {
      return date == null ? null : sdf_yMdHms.format(date);
    }
  }

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static Date toDate(String s) {
    synchronized (sdf_yMdHms) {
      try {
        return s == null ? null : sdf_yMdHms.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static BigDecimal strToBigDecimal(String aString) {
    if (aString == null) {
      return null;
    }
    try {
      return new BigDecimal(aString);
    } catch (Exception e) {
      return null;
    }
  }

  public static Date strToDateValidate(String aString) {
    if (aString == null) {
      return null;
    }
    try {
      return sdfValidate.parse(aString);
    } catch (Exception e) {
      return null;
    }
  }

  public static String bigDecimalToStr(BigDecimal aBigDecimal) {
    if (aBigDecimal == null) {
      return "";
    }
    return aBigDecimal.toString();
  }

  public static String dateToStrValidate(Date aDate) {
    if (aDate == null) {
      return "";
    }
    return sdfValidate.format(aDate);
  }

}
