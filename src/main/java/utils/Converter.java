/*
 * 2011-03-04 caili
 *   对*Format增加同步
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Converter {
  private static final char[] bcdLookup = {
    '0',
    '1',
    '2',
    '3',
    '4',
    '5',
    '6',
    '7',
    '8',
    '9',
    'a',
    'b',
    'c',
    'd',
    'e',
    'f' };

  private static SimpleDateFormat sdf_yyyyMMddHHmmSSsss_NoSeparator = new SimpleDateFormat("yyMMddHHmmssSSS");
  private static SimpleDateFormat sdf_yyyyMMddHHmmSS_NoSeparator = new SimpleDateFormat("yyMMddHHmmss");
  private static SimpleDateFormat sdf_yMdHms_NoSeparator = new SimpleDateFormat("yyyyMMddHHmmss");
  private static SimpleDateFormat sdf_yMd_NoSeparator = new SimpleDateFormat("yyyyMMdd");
  private static SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
  private static SimpleDateFormat sdf_yyyyMM = new SimpleDateFormat("yyyyMM");
  private static SimpleDateFormat sdf_yyMMdd = new SimpleDateFormat("yyMMdd");
  private static SimpleDateFormat sdf_yyMdHm = new SimpleDateFormat("yy-MM-dd HH:mm");
  private static SimpleDateFormat sdf_yyMd = new SimpleDateFormat("yy-MM-dd");
  private static SimpleDateFormat sdf_yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static SimpleDateFormat sdf_yMdHmsS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  private static SimpleDateFormat sdf_Hm = new SimpleDateFormat("HH:mm");
  private static SimpleDateFormat sdf_Hms = new SimpleDateFormat("HH:mm:ss");
  private static SimpleDateFormat sdf_yMdHmsE = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
  private static SimpleDateFormat sdf_yMd = new SimpleDateFormat("yyyy-MM-dd");
  private static SimpleDateFormat sdf_yMdHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  private static SimpleDateFormat sdf_yMd_Point = new SimpleDateFormat("yyyy.MM.dd");
  private static SimpleDateFormat sdf_yMdHms_Point = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

  private static final DecimalFormat df_price = new DecimalFormat("0.00");
  private static final DecimalFormat df_money = new DecimalFormat("0.00");
  private static final DecimalFormat df_quantity = new DecimalFormat("0.###");
  private static final DecimalFormat df_percent = new DecimalFormat("0.###");
  private static final DecimalFormat df_count = new DecimalFormat("0");

  public static boolean equals(String a, String b) {
    if (a == null) {
      return b == null;
    }

    return a.equals(b);
  }

  public static boolean equals(Date a, Date b) {
    if (a == null) {
      return b == null;
    } else if (b == null) {
      return false;
    } else {
      return a.getTime() == b.getTime();
    }
  }

  public static boolean equals(BigDecimal a, BigDecimal b) {
    if (a == null) {
      return b == null;
    }

    return a.equals(b);
  }

  public static boolean equalsByScale(BigDecimal a, BigDecimal b, int scale, RoundingMode roundingMode) {
    if (a == null) {
      return b == null;
    }

    a = a.setScale(scale, roundingMode);
    b = b == null ? null : b.setScale(scale, roundingMode);
    return a.equals(b);
  }

  public static boolean equals(Integer a, Integer b) {
    if (a == null) {
      return b == null;
    }
    return a.equals(b);
  }

  public static boolean equals(int a, int b) {
    return a == b;
  }

  public static boolean equals(long a, long b) {
    return a == b;
  }

  public static boolean equals(boolean a, boolean b) {
    return a == b;
  }

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static String toString(Date date) {
    synchronized (sdf_yMdHms) {
      return date == null ? null : sdf_yMdHms.format(date);
    }
  }

  public static String toString(Date date, String dateformat) {
    return toString(date, new SimpleDateFormat(dateformat));
  }

  public static String toString(Date date, SimpleDateFormat sdf) {
    if (date == null) {
      return null;
    }
    return sdf.format(date);
  }

  /**
   * HH:mm
   */
  public static Date parse_Hm(String date) throws Exception {
    synchronized (sdf_Hm) {
      return sdf_Hm.parse(date);
    }
  }

  /**
   * HH:mm:ss
   */
  public static String toString_Hms(Date date) {
    synchronized (sdf_Hms) {
      return date == null ? null : sdf_Hms.format(date);
    }
  }

  /**
   * yyyyMMdd
   */
  public static String toString_yyyyMMdd(Date date) {
    synchronized (sdf_yyyyMMdd) {
      return date == null ? null : sdf_yyyyMMdd.format(date);
    }
  }

  /**
   * yyyyMMdd
   */
  public static Date parse_yyyyMMdd(String s) throws ParseException {
    synchronized (sdf_yyyyMMdd) {
      return s == null ? null : sdf_yyyyMMdd.parse(s);
    }
  }

  /**
   * yyyyMM
   */
  public static String toString_yyyyMM(Date date) {
    synchronized (sdf_yyyyMM) {
      return date == null ? null : sdf_yyyyMM.format(date);
    }
  }

  /**
   * yyMMddHHmmss
   */
  public static String toString_yyyyMMddHHmmSS_NoSeparator(Date date) {
    synchronized (sdf_yyyyMMddHHmmSS_NoSeparator) {
      return date == null ? null : sdf_yyyyMMddHHmmSS_NoSeparator.format(date);
    }
  }

  /**
   * yyyyMMddHHmmss
   */
  public static Date parse_yMdHms_NoSeparator(String s) throws ParseException {
    synchronized (sdf_yMdHms_NoSeparator) {
      return s == null ? null : sdf_yMdHms_NoSeparator.parse(s);
    }
  }

  /**
   * yyMMddHHmmssSSS
   */
  public static String toString_yyyyMMddHHmmSSsss_NoSeparator(Date date) {
    synchronized (sdf_yyyyMMddHHmmSSsss_NoSeparator) {
      return date == null ? null : sdf_yyyyMMddHHmmSSsss_NoSeparator.format(date);
    }
  }

  /**
   * yyMMdd
   */
  public static String toString_yyMMdd(Date date) {
    synchronized (sdf_yyMMdd) {
      return date == null ? null : sdf_yyMMdd.format(date);
    }
  }

  /**
   * yyyy-MM-dd HH:mm:ss.SSS
   */
  public static String toString_yMdHmsS(Date date) {
    synchronized (sdf_yMdHmsS) {
      return date == null ? null : sdf_yMdHmsS.format(date);
    }
  }

  /**
   * yyyy-MM-dd HH:mm
   */
  public static String toString_yMdHm(Date date) {
    synchronized (sdf_yMdHm) {
      return date == null ? null : sdf_yMdHm.format(date);
    }
  }

  /**
   * yy-MM-dd HH:mm
   */
  public static String toString_yyMdHm(Date date) {
    synchronized (sdf_yyMdHm) {
      return date == null ? null : sdf_yyMdHm.format(date);
    }
  }

  /**
   * yy-MM-dd HH:mm
   */
  public static Date parse_yyMdHm(String date) throws Exception {
    synchronized (sdf_yyMdHm) {
      return sdf_yyMdHm.parse(date);
    }
  }

  /**
   * yy-MM-dd
   */
  public static String toString_yyMd(Date date) {
    synchronized (sdf_yyMd) {
      return date == null ? null : sdf_yyMd.format(date);
    }
  }

  /**
   * yy-MM-dd
   */
  public static Date parse_yyMd(String date) throws Exception {
    synchronized (sdf_yyMd) {
      return sdf_yyMd.parse(date);
    }
  }

  /**
   * yyyy-MM-dd
   */
  public static String toString_yMd(Date date) {
    synchronized (sdf_yMd) {
      return date == null ? null : sdf_yMd.format(date);
    }
  }

  /**
   * yyyy.MM.dd
   */
  public static String toString_yMd_Point(Date date) {
    synchronized (sdf_yMd_Point) {
      return date == null ? null : sdf_yMd_Point.format(date);
    }
  }

  /**
   * yyyy.MM.dd HH:mm:ss
   */
  public static String toString_yMdHms_Point(Date date) {
    synchronized (sdf_yMdHms_Point) {
      return date == null ? null : sdf_yMdHms_Point.format(date);
    }
  }

  /**
   * yyyyMMdd
   */
  public static String toString_yMd_NoSeparator(Date date) {
    synchronized (sdf_yMd_NoSeparator) {
      return date == null ? null : sdf_yMd_NoSeparator.format(date);
    }
  }

  /**
   * yyyy-MM-dd
   */
  public static Date parse_yMd(String date) throws Exception {
    synchronized (sdf_yMd) {
      return sdf_yMd.parse(date);
    }
  }

  /**
   * HH:mm
   */
  public static String toString_Hm(Date date) {
    synchronized (sdf_Hm) {
      return date == null ? null : sdf_Hm.format(date);
    }
  }

  /**
   * yyyy-MM-dd EEE HH:mm:ss
   */
  public static String toString_yMdHmsE(Date date) {
    synchronized (sdf_yMdHmsE) {
      return date == null ? null : sdf_yMdHmsE.format(date);
    }
  }

  public static String toString(String s) {
    return s;
  }

  public static String toString(Integer n) {
    return n == null ? null : n.toString();
  }

  public static String toString(Long n) {
    return n == null ? null : n.toString();
  }

  public static String toString(long n) {
    return Long.toString(n);
  }

  public static String toStringInt(BigDecimal n) {
    return n == null ? null : Integer.valueOf(n.intValue()).toString();
  }

  public static String toStringLong(BigDecimal n) {
    return n == null ? null : Long.valueOf(n.longValue()).toString();
  }

  public static String toPriceString(BigDecimal n) {
    synchronized (df_price) {
      return n == null ? null : df_price.format(n);
    }
  }

  public static String toMoneyString(BigDecimal n) {
    synchronized (df_money) {
      return n == null ? null : df_money.format(n);
    }
  }

  public static String toQtyString(BigDecimal n) {
    synchronized (df_quantity) {
      return n == null ? null : df_quantity.format(n);
    }
  }

  public static String toPercentString(BigDecimal n) {
    synchronized (df_percent) {
      return n == null ? null : df_percent.format(n);
    }
  }

  public static String toCountString(BigDecimal n) {
    synchronized (df_count) {
      return n == null ? null : df_count.format(n);
    }
  }

  public static String toString(Boolean b) {
    return b == null ? null : b.toString();
  }

  public static String toStringFriendly(Boolean b) {
    return b == null ? "" : (b.booleanValue() ? "是" : "否");
  }

  public static String toString(boolean b) {
    return Boolean.toString(b);
  }

  public static String toString(int n) {
    return Integer.toString(n);
  }

  public static Date toDate(java.sql.Timestamp t) {
    return toDate(t, null);
  }

  public static Date toDate(java.sql.Timestamp t, Date defaultValue) {
    if (t == null) {
      return defaultValue;
    }
    return new Date(t.getTime());
  }

  public static java.sql.Timestamp toTimestamp(Date d) {
    if (d == null) {
      return null;
    }
    return new java.sql.Timestamp(d.getTime());
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

  public static Date date(String s, Date defaultValue, String dateformat) throws Exception {
    if (s == null) {
      return defaultValue;
    }
    s = s.trim();
    if (s.length() == 0) {
      return defaultValue;
    }
    try {
      return new SimpleDateFormat(dateformat).parse(s);
    } catch (Exception e) {
      throw new Exception(s + "不是合法的日期");
    }
  }

  public static Date date(String s, Date defaultValue, String... dateformats) throws Exception {
    for (String dateformat : dateformats) {
      try {
        return date(s, defaultValue, dateformat);
      } catch (Exception e) {
      }
    }
    throw new Exception(s + "不是合法的日期");
  }

  /**
   * yyyy-MM-dd
   */
  public static Date toDate_sdf_yMd(String s) {
    synchronized (sdf_yMd) {
      try {
        return s == null ? null : sdf_yMd.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy.MM.dd HH:mm:ss
   */
  public static Date toDate_sdf_yMdHms_Point(String s) {
    synchronized (sdf_yMdHms_Point) {
      try {
        return s == null ? null : sdf_yMdHms_Point.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy.MM.dd
   */
  public static Date toDate_sdf_yMd_Point(String s) {
    synchronized (sdf_yMd_Point) {
      try {
        return s == null ? null : sdf_yMd_Point.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Integer toInteger(String s) {
    try {
      return s == null ? null : new Integer(s);
    } catch (Exception e) {
      return null;
    }
  }

  public static Integer integer(String s, Integer blankValue) throws Exception {
    if (s == null) {
      return blankValue;
    }
    s = s.trim();
    if (s.length() == 0) {
      return blankValue;
    }
    try {
      return new Integer(s);
    } catch (Exception e) {
      throw new Exception(s + "不是一个合法的整数");
    }
  }

  public static BigDecimal toBigDecimal(String s) {
    try {
      return s == null ? null : new BigDecimal(s);
    } catch (Exception e) {
      return null;
    }
  }

  public static BigDecimal toBigDecimal(String s, BigDecimal defaultValue) {
    try {
      return s == null ? defaultValue : new BigDecimal(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static BigDecimal bigDecimal(String s, int scale, BigDecimal blankValue) throws Exception {
    blankValue = blankValue == null ? null : blankValue.setScale(scale, RoundingMode.HALF_UP);
    if (s == null) {
      return blankValue;
    }
    s = s.trim();
    if (s.length() == 0) {
      return blankValue;
    }
    try {
      return new BigDecimal(s).setScale(scale, RoundingMode.HALF_UP);
    } catch (Exception e) {
      throw new Exception(s + "不是合法的数值");
    }
  }

  public static Boolean toBoolean(String s) {
    try {
      return s == null ? null : new Boolean(s);
    } catch (Exception e) {
      return null;
    }
  }

  public static Boolean toBoolean(String s, Boolean defaultValue) {
    try {
      return s == null ? defaultValue : new Boolean(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static int toInt(String s) {
    try {
      return s == null ? 0 : Integer.parseInt(s);
    } catch (Exception e) {
      return 0;
    }
  }

  public static int toInt(String s, int defaultValue) {
    try {
      return Integer.parseInt(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static long toLong(String s, long defaultValue) {
    try {
      return Long.parseLong(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static boolean toBool(String s) {
    try {
      return s == null ? false : Boolean.parseBoolean(s);
    } catch (Exception e) {
      return false;
    }
  }

  public static BigDecimal negate(BigDecimal d) {
    return d == null ? null : d.negate();
  }

  public static String native2ascii(String str) {
    String tmp;
    StringBuffer sb = new StringBuffer(1000);
    char c;
    int i, j;
    sb.setLength(0);
    for (i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (c > 255) {
        sb.append("\\u");
        j = (c >>> 8);
        tmp = Integer.toHexString(j);
        if (tmp.length() == 1) {
          sb.append("0");
        }
        sb.append(tmp);
        j = (c & 0xFF);
        tmp = Integer.toHexString(j);
        if (tmp.length() == 1) {
          sb.append("0");
        }
        sb.append(tmp);
      } else {
        sb.append(c);
      }
    }
    return (new String(sb));
  }

  public static final String bytesToHexStr(byte[] bcd) {
    StringBuffer s = new StringBuffer(bcd.length * 2);
    for (int i = 0; i < bcd.length; i++) {
      s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
      s.append(bcdLookup[bcd[i] & 0x0f]);
    }
    return s.toString();
  }

  public static final byte[] hexStrToBytes(String s) {
    byte[] bytes;
    bytes = new byte[s.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
    }
    return bytes;
  }

  public static String toString(File file) throws IOException {
    return toString(new FileReader(file));
  }

  public static String toString(File file, String encoding) throws IOException {
    return toString(new InputStreamReader(new FileInputStream(file), encoding));
  }

  public static String toString(Reader reader) throws IOException {
    try {
      StringBuffer sb = new StringBuffer();
      char[] cbuf = new char[2048];
      for (int cread = reader.read(cbuf); cread != -1; cread = reader.read(cbuf)) {
        sb.append(cbuf, 0, cread);
      }
      return sb.toString();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {
      }
    }
  }

  public static String indent(String s, int n) {
    StringBuffer sb = new StringBuffer(n);
    for (int i = 0; i < n; ++i) {
      sb.append(" ");
    }
    return sb.toString() + s.replace("\n", "\n" + sb.toString());
  }

  public static String toString(Set<String> set) {
    StringBuffer sb = new StringBuffer();
    String deli = "";
    sb.append("(");
    for (String s : set) {
      sb.append(deli);
      sb.append(s);
      deli = ",";
    }
    sb.append(")");
    return sb.toString();
  }

  /**
   * 截断s, 返回的字符串的GBK内码字节数为length, 并保证最后是一个完整的字符.
   *
   * @param s
   * @param length
   * @return
   * @throws UnsupportedEncodingException
   */
  public static String truncateGBK(String s, int length) throws UnsupportedEncodingException {
    if (s == null) {
      return s;
    }

    String charsetName = "GBK";
    byte[] b = s.getBytes(charsetName);
    if (b.length <= length) {
      return s;
    }

    int newLen = 0;
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; ++i) {
      byte[] cb = String.valueOf(c[i]).getBytes(charsetName);
      newLen += cb.length;
      if (newLen > length) {
        newLen -= cb.length;
        break;
      }
    }

    return new String(b, 0, newLen, charsetName);
  }

  public static String firstCharToUpperCase(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  public static String firstCharToLowerCase(String s) {
    return s.substring(0, 1).toLowerCase() + s.substring(1);
  }

  public static Object getBeanProperty(Object bean, String propertyName) throws Exception {
    try {
      Method m = bean.getClass().getMethod("get" + Converter.firstCharToUpperCase(propertyName));
      return m.invoke(bean);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

  public static void setBeanProperty(Object bean, String propertyName, Object value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), value.getClass());
    m.invoke(bean, value);
  }

  public static void setBeanPropertyInt(Object bean, String propertyName, int value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), int.class);
    m.invoke(bean, Integer.valueOf(value));
  }

  public static void setBeanPropertyLong(Object bean, String propertyName, long value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), long.class);
    m.invoke(bean, Long.valueOf(value));
  }

  public static void setBeanPropertyFloat(Object bean, String propertyName, float value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), float.class);
    m.invoke(bean, Float.valueOf(value));
  }

  public static void setBeanPropertyDouble(Object bean, String propertyName, double value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), double.class);
    m.invoke(bean, Double.valueOf(value));
  }

  public static void setBeanPropertyBoolean(Object bean, String propertyName, boolean value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), boolean.class);
    m.invoke(bean, Boolean.valueOf(value));
  }

  /**
   * 返回bean中定义的属性, 不包括父类的属性
   */
  public static Field[] getBeanProperties(Object bean, Class<?> cls) {
    Field[] fields = cls.getDeclaredFields();
    List<Field> properties = new ArrayList<Field>(fields.length);
    for (Field field : fields) {
      try {
        Method m = cls.getMethod("get" + Converter.firstCharToUpperCase(field.getName()));
        if (Modifier.isPublic(m.getModifiers())) {
          properties.add(field);
        }
      } catch (NoSuchMethodException e) {
      }
    }
    return properties.toArray(new Field[] {});
  }

  public static Field[] getBeanClassProperties(Class<?> cls) {
    Field[] fields = cls.getDeclaredFields();
    List<Field> properties = new ArrayList<Field>(fields.length);
    for (Field field : fields) {
      try {
        Method m = cls.getMethod("get" + Converter.firstCharToUpperCase(field.getName()));
        if (Modifier.isPublic(m.getModifiers())) {
          properties.add(field);
        }
      } catch (NoSuchMethodException e) {
      }
    }
    return properties.toArray(new Field[] {});
  }

  /**
   * 取得和baseName在同一目录中的资源.
   *
   * @param name
   * @return
   * @throws IOException
   */
  public static URL[] getResources(String baseName) throws IOException {
    String jarFileProtocol = "jar:file:/", diskFileProtocol = "file:/";
    ArrayList<URL> resources = new ArrayList<URL>();
    String url = Converter.class.getResource(baseName).toString();

    if (url.startsWith(jarFileProtocol)) {
      String jar = url.substring(jarFileProtocol.length());
      int i = jar.indexOf("!");
      String jarName = jar.substring(0, i);
      int j = jar.lastIndexOf('/');
      String path = jar.substring(i + 2, j);

      ZipFile zip = new ZipFile(jarName);
      @SuppressWarnings("unchecked")
      Enumeration<ZipEntry> es = (Enumeration<ZipEntry>) zip.entries();
      while (es.hasMoreElements()) {
        ZipEntry e = es.nextElement();
        String name = e.getName();
        i = name.lastIndexOf('/');
        if (i < 0) {
          continue;
        }
        String epath = name.substring(0, i);
        if (path.equals(epath)) {
          resources.add(new URL(jarFileProtocol + jarName + "!/" + name));
        }
      }

    } else if (url.startsWith(diskFileProtocol)) {
      File dir = new File(url.substring(diskFileProtocol.length())).getParentFile();
      for (File file : dir.listFiles()) {
        resources.add(new URL(diskFileProtocol + file.getAbsolutePath().replace('\\', '/')));
      }
    }
    return resources.toArray(new URL[] {});
  }

  /**
   * 设置obj的clazz类中fieldName的值
   *
   * @param obj
   * @param clazz
   */
  public static void inject(Object obj, Class<?> clazz, String fieldName, Object value) throws Exception {
    Field f = null;
    f = clazz.getDeclaredField(fieldName);
    f.setAccessible(true);
    f.set(obj, value);
  }

  public static List<String> breakText(String text, String deli) {
    List<String> list = new ArrayList<String>();
    StringTokenizer st = new StringTokenizer(text, deli);
    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      list.add(s);
    }
    return list;
  }

  public static BigDecimal fenToYuan(long fen) {
    return new BigDecimal(fen).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
  }

  public static long yuanToFen(BigDecimal yuan) {
    return yuan.multiply(new BigDecimal(100)).longValue();
  }

  public static int find0(byte[] b) {
    int i = 0;
    while (i < b.length && b[i] != 0) {
      ++i;
    }
    return i;
  }

  /**
   * 如果传入的字符串为null，则返回""；否则返回字符串本身
   */
  public static String nullEscape(String str) {
    return str == null ? "" : str;
  }

}