package test.java8;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/11/27.
 */
public class Java8GrammaTest {
  public static void printValur(String str) {
    System.out.println("print value : " + str);
  }

  public static void exec(IGrammaTest test, int value) {
    System.out.println("value");
    test.doSomething("1", 2);
  }

  //  public static void main(String[] args) {
  //    List<String> al = Arrays.asList("a", "b", "c", "d");
  //    al.forEach(Java8GrammaTest::printValur);
  //    //下面的方法和上面等价的
  //    Consumer<String> methodParam = Java8GrammaTest::printValur; //方法参数
  //    al.forEach(x -> methodParam.accept(x));//方法执行accept
  //
  //    Arrays.asList("1", "2", "3").sort(String::compareTo);
  //    Arrays.asList("1", "2", "3").sort(Comparator.naturalOrder());
  //    Arrays.asList("1", "2", "3").sort((x1, x2) -> x1.compareTo(x2));
  //    Arrays.asList("1", "2", "3").sort(new Comparator<String>() {
  //      @Override
  //      public int compare(String x1, String x2) {
  //        return x1.compareTo(x2);
  //      }
  //    });
  //    Consumer<? super String> consumer = new Consumer<String>() {
  //      @Override
  //      public void accept(String s) {
  //        System.out.println(s);
  //      }
  //    };
  //    Arrays.asList("a", "b", "c").forEach(x -> System.out.println("test:\t" + x));
  //
  //    Arrays.asList("a", "b", "c").forEach(x -> System.out.println("test:\t" + x));
  //
  //    exec((a, b) -> System.out.println(a + b), 30);
  //
  //    List<? super Integer> foo3 = new ArrayList<Number>();
  //
  //    foo3.add(new Integer(1));
  //
  //    // 1. Individual values
  //    Stream stream = Stream.of("a", "b", "c");
  //    List<String> l = (List) stream.filter(e -> e == "b").collect(Collectors.toList());
  //    for (String s : l) {
  //      System.out.println("s" + s);
  //    }
  //    //    // 2. Arrays
  //    //    String [] strArray = new String[] {"a", "b", "c"};
  //    //    stream = Stream.of(strArray);
  //    //    stream = Arrays.stream(strArray);
  //    //    // 3. Collections
  //    //    List<String> list = Arrays.asList(strArray);
  //    //    stream = list.stream();
  //
  //  }

  private void method() {
    Plate<? super Fruit> plate = new Plate<Food>();
    plate.setItem(new Apple());
  }

  public class Food {
  }

  public class Fruit extends Food {
  }

  public class Apple extends Fruit {
    String eat;

    public String getEat() {
      return eat;
    }

    public void setEat(String eat) {
      this.eat = eat;
    }
  }

  public class Plate<T> {
    private T item;

    public T getItem() {
      return item;
    }

    public void setItem(T item) {
      this.item = item;
    }

    public void memberMethod() {
      T member;

    }
  }
}
