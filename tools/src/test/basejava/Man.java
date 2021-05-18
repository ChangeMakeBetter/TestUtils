package test.basejava;

/**
 * </br>
 * Created by yangxiaohua on 2021/5/7.
 */
public class Man {
  private String name;
  private int age;

  public Man(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Man{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
