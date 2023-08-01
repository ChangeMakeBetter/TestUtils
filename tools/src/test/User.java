package test;

/**
 * </br>
 * Created by yangxiaohua on 2023/7/27.
 */
public class User {

  private String name;

  private String balance;

  public User(String name, String balance) {
    this.name = name;
    this.balance = balance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }
}
