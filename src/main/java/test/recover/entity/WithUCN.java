/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2008，所有权利保留。
 * <p>
 * 项目名：	e0-rumba-common 文件名：	HasUCN.java 模块说明： 修改历史： Apr 26, 2008 - lxm - 创建。
 */
package test.recover.entity;

/**
 * 标记某个实体类具有标准化的uuid+code+name属性的接口。
 *
 * @author lxm
 *
 */
public interface WithUCN {

  /** UUID */
  public String getUuid();

  /** 代码 */
  public String getCode();

  /** 名称 */
  public String getName();

  /**
   * 返回一个友好字符串，例如：<i>名称</i>[<i>代码</i>]。
   *
   * @return
   */
  public String toFriendlyStr();
}
