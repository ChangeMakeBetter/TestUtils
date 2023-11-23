/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2019，所有权利保留。
 * 项目名：	jpos-test
 * 文件名：	JsonUtil.java
 * 模块说明：
 * 修改历史：
 * 2019-05-14 - zhanglulu - 创建。
 */
package json;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import json.entity.TestRequest;

/**
 * @author zhanglulu
 */

public class JsonUtil {
  public static void main(String[] args) {
    Field[] fields = TestRequest.class.getDeclaredFields();
    System.out.println(buildToJson(fields, false,true));
    System.out.println(buildParseJson(fields, false,true));
  }

  public static String buildToJson(Field[] fields, boolean appendSuper,boolean firstCharUppercase) {
    StringBuilder sb = new StringBuilder();
    if (appendSuper) {
      sb.append("@Override\n");
    }
    sb.append("public JSONObject toJson(){ \n");
    if (appendSuper) {
      sb.append("JSONObject jo = super.toJson();\n");
    } else {
      sb.append("JSONObject jo = new JSONObject();\n");
    }
    for (Field field : fields) {
      // if ((field.getModifierList() == null) ||
      // (PsiUtil.getAccessLevel(field.getModifierList()) == 1)) {
      if (!ignoreField(field.getName())) {
        String typeName = field.getType().toString();
        typeName = getBoxedTypeName(typeName);
        if (typeName.toLowerCase().contains("list")) {
          Matcher matcher = Pattern.compile("(.*<)(.*)(>.*)").matcher(field.getGenericType().toString());
          String generic = "Object";
          if (matcher.find()) {
            generic = getBoxedTypeName(matcher.group(2));
          }
          sb.append(String.format("for(%s %s : %s) { \n", new Object[] {
              generic,
              field.getName().substring(0, 1),
              field.getName() }));
          sb.append(String.format("jo.accumulate(\"%s\",%s);\n", new Object[] {
            firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName(),
              field.getName().substring(0, 1) + ".toJson()" }));

          sb.append("}\n");
        } else if (typeName.equals(getBoxedTypeName(BigDecimal.class.getName()))) {
          String value = "";
          if (field.getName().toLowerCase().contains("qty")) {
            value = String.format("Converter.toQtyString(%s)", new Object[] { field.getName() });
          } else {
            value = String.format("Converter.toMoneyString(%s)", new Object[] { field.getName() });
          }
          sb.append(String.format("jo.put(\"%s\",%s);\n", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName(), value }));
        } else if (typeName.equals(getBoxedTypeName(Date.class.getName()))) {
          String value = String.format("Converter.toString(%s)", new Object[] { field.getName() });
          sb.append(String.format("jo.put(\"%s\",%s);\n", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName(), value }));
        } else {
          sb.append(String.format("jo.put(\"%s\",%s);\n", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName(), field.getName() }));
        }
      }
    }
    sb.append("return jo;}");
    return sb.toString();
  }

  public static String buildParseJson(Field[] fields, boolean appendSuper,boolean firstCharUppercase) {
    String methodPrefix = "set";
    StringBuilder sb = new StringBuilder();
    if (appendSuper) {
      sb.append("@Override\n");
    }
    sb.append("public void parseJson(String jsonStr) throws Exception { \n");
    if (appendSuper) {
      sb.append("JSONObject jo = super.parseJson(jsonStr);\n");
    } else {
      sb.append("JSONObject jo = new JSONObject(jsonStr);\n");
    }
    for (Field field : fields) {
      // if ((field.getModifierList() == null) ||
      // (PsiUtil.getAccessLevel(field.getModifierList()) == 1)) {
      if (!ignoreField(field.getName())) {
        String typeName = field.getType().toString();
        typeName = getBoxedTypeName(typeName);
        sb.append(String.format("if(jo.has(\"%s\")) { \n", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName()}));
        if (typeName.toLowerCase().contains("list")) {
          Type gtype = field.getGenericType();
          Class c = (Class) ((ParameterizedType) gtype).getActualTypeArguments()[0];
          String generic = "Object";
          if (c != null) {
            generic = getBoxedTypeName(c.toString());
          }
          sb.append(String.format("JSONArray ja = jo.optJSONArray(\"%s\");\n", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName()}));
          sb.append(String.format("if (ja != null && ja.length() > 0) {\n"));
          sb.append(String.format("%s.clear();\n", new Object[] { field.getName() }));
          sb.append(String.format("for(int i = 0; i < ja.length(); i++) { \n"));
          if (c.getClassLoader() != null) {
            sb.append(String.format("%s.add(new %s(ja.getJSONObject(i)));\n", new Object[] { field.getName(), generic }));
          } else {
            sb.append(String.format("%s.add(ja.get%s(i));\n", new Object[] {
                field.getName(),
                firstCharToUpperCase(generic) }));
          }

          sb.append("}\n");
          sb.append("}\n");
          sb.append("}\n");
        } else if (typeName.equals(getBoxedTypeName(BigDecimal.class.getName()))) {
          String value = String
              .format("Converter.toBigDecimal(jo.optString(\"%s\"))", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName() });
          sb.append(String.format(methodPrefix + firstCharToUpperCase(field.getName()) + "(%s);\n",
              new Object[] { value }));
          sb.append("}\n");
        } else if (typeName.equals(getBoxedTypeName(Date.class.getName()))) {
          String value = String.format("Converter.toDate(jo.optString(\"%s\"))", new Object[] { firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName() });
          sb.append(String.format(methodPrefix + firstCharToUpperCase(field.getName()) + "(%s);\n",
              new Object[] { value }));
          sb.append("}\n");
        } else {
          sb.append(String.format(methodPrefix + firstCharToUpperCase(field.getName()) + "(jo.opt%s(\"%s\"));\n",
              new Object[] { firstCharToUpperCase(typeName), firstCharUppercase ? firstCharToUpperCase(field.getName()): field.getName() }));
          sb.append("}\n");
        }
      }
    }
    sb.append("}");
    return sb.toString();
  }

  static final String ignoreField = "tableName;logger;messagePrefix;serialVersionUID";

  private static boolean ignoreField(String fieldName) {
    try {
      String ignoreFieldNames = ignoreField;
      List<String> names = Arrays.asList(ignoreFieldNames.split(";"));
      return names.contains(fieldName);
    } catch (RuntimeException e) {
    }
    return false;
  }

  private static String getBoxedTypeName(String fieldNameStr) {
    if (fieldNameStr.lastIndexOf(".") > 0) {
      return fieldNameStr.substring(fieldNameStr.lastIndexOf(".") + 1);
    } else {
      return fieldNameStr;
    }
  }

  private static String firstCharToUpperCase(String fieldStr) {
    return fieldStr.substring(0, 1).toUpperCase() + fieldStr.substring(1);

  }

  //TODO
}