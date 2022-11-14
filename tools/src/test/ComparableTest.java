package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import utils.MyConverter;

/**
 * </br>
 * Created by yangxiaohua on 2022/9/22.
 */
public class ComparableTest {

  public static void main(String[] args) {
    List<Date> list = new ArrayList<>();
    Calendar c = Calendar.getInstance();
    c.clear();
    c.set(Calendar.YEAR, 2000);
    c.set(Calendar.MONTH, 1);
    c.set(Calendar.DATE, 10);
    list.add(c.getTime());
    c.clear();
    c.set(Calendar.YEAR, 2000);
    c.set(Calendar.MONTH, 1);
    c.set(Calendar.DATE, 12);
    list.add(c.getTime());
    c.clear();
    c.set(Calendar.YEAR, 1980);
    c.set(Calendar.MONTH, 1);
    c.set(Calendar.DATE, 12);
    list.add(c.getTime());
    sortTime(list);

    for (Date date : list) {
      System.out.println(MyConverter.toString(date));
    }

  }

  private static List<Date> sortTime(List<Date> list) {
    Collections.sort(list, new Comparator<Date>() {
      @Override
      public int compare(Date o1, Date o2) {
        if (o1.getTime() - o2.getTime() > 0) {
          return -1;
        } else if (o1.getTime() - o2.getTime() < 0) {
          return 1;
        } else {
          return 0;
        }
      }
    });
    return list;
  }

}
