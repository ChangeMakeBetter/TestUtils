/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2008，所有权利保留。
 * <p>
 * 项目名：	rumba-ejb 文件名：	UCN.java 模块说明： 修改历史： Mar 27, 2008 - lxm - 创建。
 */
package test.recover.entity;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * uuid + code + name
 * <p>
 * <p>
 * 设计此类，既可以被嵌入到持久化对象(PO)作为其一部分，也可以被单独使用(POJO)。
 *
 * @author lxm
 */
public class UCN implements Serializable, WithUCN {

  private static final long serialVersionUID = 300100L;

  /**
   * 将toFriendlyStr格式出来的字符串反向解析回UCN。<br /> 由于字符串中只有code和name，因此解析出的uuid==null。<br /> 如果无法解析，返回null。
   */
  public static UCN fromFriendlyStr(String string) {
    if (string == null || string.isEmpty()) {
      return null;
    }
    Pattern pattern = Pattern.compile("^(.+)\\[(.+)\\]$");
    Matcher matcher = pattern.matcher(string);
    if (!matcher.matches()) {
      return null;
    }
    return new UCN(null, matcher.group(2), matcher.group(1));
  }

  /**
   * 将toFriendlyStr格式出来的字符串反向解析回UCN。再取得code。<br /> 如果无法解析，返回null。
   */
  public static String getCodeFromFriendlyStr(String string) {
    UCN ucn = fromFriendlyStr(string);
    if (ucn == null) {
      return null;
    } else {
      return ucn.getCode();
    }
  }

  /**
   * 构造函数
   */
  public UCN() {
    super();
  }

  /**
   * 根据指定的实体对象创建UCN对象。
   *
   * @param entity
   */
  public UCN(WithUCN entity) {
    super();
    this.uuid = entity.getUuid();
    this.code = entity.getCode();
    this.name = entity.getName();
  }

  public UCN(String uuid, String code, String name) {
    super();
    this.uuid = uuid;
    this.code = code;
    this.name = name;
  }

  /**
   * 取得标记当前对象用户友好且简短字符串。
   *
   * @return
   */
  @Override
  public String toFriendlyStr() {
    return null;
  }

  private String uuid;
  private String code;
  private String name;

  /**
   * UUID
   */
  @Override
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /**
   * 代码
   */
  @Override
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  /**
   * 名称
   */
  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
