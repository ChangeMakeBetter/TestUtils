package json.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanglulu
 */

public class TestRequest {
  private String memberId;
  private int count;
  private BigDecimal amount;
  private Date tranTime;
  private List<Student> studentList = new ArrayList<Student>();
  private List<String> couponCodes = new ArrayList<String>();
  private boolean showMember = true;

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Date getTranTime() {
    return tranTime;
  }

  public void setTranTime(Date tranTime) {
    this.tranTime = tranTime;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }

  public List<String> getCouponCodes() {
    return couponCodes;
  }

  public void setCouponCodes(List<String> couponCodes) {
    this.couponCodes = couponCodes;
  }

  public boolean isShowMember() {
    return showMember;
  }

  public void setShowMember(boolean showMember) {
    this.showMember = showMember;
  }


}
