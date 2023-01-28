package test.basejava;

/**
 * </br>
 * Created by yangxiaohua on 2022/12/9.
 */
public class Person {

  private String birthday;

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public void setStatusErrorText(String text) {
    System.out.println(getClass().getName());
  }
}
