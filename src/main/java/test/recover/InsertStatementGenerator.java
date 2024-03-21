package test.recover;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tapestry.json.JSONObject;

import test.recover.entity.Trade;
import test.recover.entity.UCN;
import utils.Converter;

public class InsertStatementGenerator {

  private static List<String> ignoreList = new ArrayList<String>();
  private static List<String> ucnField = new ArrayList<String>();

  static {
    ignoreList.add("serialVersionUID");
    ignoreList.add("products");
    ignoreList.add("payments");
    ucnField.add("filler");
    ucnField.add("store");
  }

  public static String generateInsertStatement(Object obj, String tableName) {
    Class<?> clazz = obj.getClass();
    Field[] fields = clazz.getDeclaredFields();

    StringBuilder sqlBuilder = new StringBuilder();
    sqlBuilder.append("INSERT INTO ").append(tableName).append(" (");

    // 构建列名部分
    for (Field field : fields) {
      if (ignoreList.contains(field.getName())) {
        continue;
      }
      field.setAccessible(true);
      String fieldName = field.getName();
      if (ucnField.contains(field.getName())) {
        sqlBuilder.append(fieldName + "UUID").append(", ");
        sqlBuilder.append(fieldName + "CODE").append(", ");
        sqlBuilder.append(fieldName + "NAME").append(", ");
      } else {
        sqlBuilder.append(fieldName).append(", ");
      }
    }
    sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // 移除末尾的逗号和空格
    sqlBuilder.append(") VALUES (");

    // 构建值部分
    for (Field field : fields) {
      if (ignoreList.contains(field.getName())) {
        continue;
      }
      field.setAccessible(true);
      try {
        Object value = field.get(obj);
        if (value instanceof String) {
          sqlBuilder.append("'").append(value).append("', ");
        } else if (value instanceof Date) {
          sqlBuilder.append("'").append(Converter.toString((Date) value)).append("', ");
        } else if (value instanceof UCN) {
          sqlBuilder.append("'").append(Converter.toString((Date) value)).append("', ");
        } else if (value instanceof List) {
          for (Field field1 : fields) {

          }
        } else {
          sqlBuilder.append(value).append(", ");
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace(); // 处理异常
      }
    }
    sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); // 移除末尾的逗号和空格
    sqlBuilder.append(");");

    return sqlBuilder.toString();
  }

  public static void main(String[] args) {

    String jsonString = "{\"marketUuid\":\"0001\",\"marketCode\":\"0001\",\"marketName\":\"无锡朝阳农产品大市场\",\"posNo\":\"B408\",\"vendorUuid\":\"A65F5CDC53909552E040A8C065020B8C\",\"vendorCode\":\"100054\",\"batch\":\"0000231123002200\",\"details\":[{\"lineNumber\":1,\"goodsUuid\":\"A6265DE2315E88E4E040A8C065023CBE\",\"goodsCode\":\"203101\",\"goodsName\":\"蜜橘\",\"packages\":25,\"quantity\":385.500,\"price\":3.00,\"amount\":1156.50,\"deposit\":0.00,\"packQty\":0,\"tareWeight\":7.500,\"tradeMode\":0,\"stockBatch\":\"-\"}],\"payments\":[]}";
    try {
      JSONObject jsonObject = new JSONObject(jsonString);

      Trade t = new Trade(jsonObject);

      // 打印生成的 SQL 语句
      System.out.println(t.toString());

      String tableName = "person_table";
      String sqlInsert = generateInsertStatement(t, tableName);

      System.out.println(sqlInsert);
    } catch (Exception e) {
      System.out.println("error:" + e.getMessage());
    }
  }
}
