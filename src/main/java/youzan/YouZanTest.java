package youzan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * </br>
 * Created by yangxiaohua on 2020/10/26.
 */
public class YouZanTest {

  private void test() throws Exception {
    //    DefaultYZClient yzClient = new DefaultYZClient();
    //    TokenParameter tokenParameter = TokenParameter.code()
    //      .clientId("填写您的clinetId")
    //      .clientSecret("填写您的clientSecret")
    //      .code("填写您获取到的code")
    //      .build();
    //    OAuthToken codeToken = yzClient.getOAuthToken(tokenParameter);
    //
    //    YouzanItemGet kdtItemGet = new YouzanItemGet();
    //    //3.为 api 设置参数
    //    YouzanItemGetParams kdtItemGetParams = new YouzanItemGetParams();
    //    kdtItemGetParams.setItemId(365439338L);
    //    kdtItemGet.setAPIParams(kdtItemGetParams);
    //
    //    //Token方式API调用
    //    //4.创建 Auth 验证方式对象
    //    Token token = new Token("your-token");
    //    //5.使用 YZClient 调用 api
    //    try {
    //      YouzanItemGetResult youzanItemGetResult = yzClient.invoke(kdtItemGet, token, YouzanItemGetResult.class);
    //      System.out.println(youzanItemGetResult.getSuccess());
    //    } catch (SDKException e) {
    //      e.printStackTrace();
    //    }

  }

  public static void main(String[] args) {
    String s = "5/24/22 9:34";
    System.out.println(isDateFormat(s));

  }

  // 检查是否是日期格式 "M/d/yy"
  private static boolean isDateFormat(String input) {
    SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
    sdf.setLenient(false); // 设置严格模式，不允许自动纠正
    try {
      Date date = sdf.parse(input);
      System.out.println(date);
      return true;
    } catch (ParseException e) {
      return false;
    }
  }
}
