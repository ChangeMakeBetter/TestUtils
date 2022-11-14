package dragonfly.upload;

import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayOpenOperationOpenbizmockBizQueryModel;
import com.alipay.api.request.AlipayCommerceIotReceiptSendRequest;
import com.alipay.api.response.AlipayCommerceIotReceiptSendResponse;

/**
 * </br>
 * Created by yangxiaohua on 2022/10/11.
 */
public class AliSdkTest {

  public static void main(String[] args) {
    try {
      // 1. 创建AlipayClient实例
      AlipayClient alipayClient = new DefaultAlipayClient(getClientParams());
      // 2. 创建使用的Open API对应的Request请求对象
      AlipayCommerceIotReceiptSendRequest request = getRequest();
      // 3. 发起请求并处理响应
      AlipayCommerceIotReceiptSendResponse response = alipayClient.certificateExecute(request);
      if (response.isSuccess()) {
        System.out.println("调用成功。");
      } else {
        System.out.println("调用失败，原因：" + response.getMsg() + "，" + response.getSubMsg());
      }
    } catch (Exception e) {
      System.out.println("调用遭遇异常，原因：" + e.getMessage());
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private static CertAlipayRequest getClientParams() {
    CertAlipayRequest certParams = new CertAlipayRequest();
    certParams.setServerUrl("https://openapi.alipay.com/gateway.do");
    //请更换为您的AppId
    certParams.setAppId("2019091767145019");
    //请更换为您的PKCS8格式的应用私钥
    certParams.setPrivateKey(
      "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNOanhMtPvwInLNTw/Is+HCxxE0+Fq9zKmBTGoCzHV1kqxbJpfpJyNvseP8panUtMWxupiWoxdNKB7d3SmtdONpDEZJxZlGrnZwDw3J7kbk+IfDlf23LWt8mW3RyV5hxSjrZ0yMl2+6ejpzQFuyI9budmjokBEC9AU04fpTZSkmrl6VddnIp0X60k2bJuwsml9iXm5/v7qvgUi1DSYzNy7JwWfmLHnA9KP0To+XFTN6Lwp3eBCP6PzeJBuPt0kzBSVo0GnHkM1dDB1jon4mCchHyfhxPfl2JH4rlbOyXk+MGJ87msgeMIO4ZjVIYwQWyxNIt7XwfY9UaphxaVSF/UdAgMBAAECggEAGjA8QWeEh6wjoUww7OBOrZMw3c6QuZ43hTPnXmsdBbNkTHyAMAY9hceACECLEWI5hLrEUhLKfqo4rEydlCCZp2VwOWLXM05+clPEltHF8Mg+oVWumDebdTNDC3alC2EyQZv7T4ipe7Kyn1CF2H5Wn0Laig6XbkbmgkYrqObbDp7eq7PEvvCcM7WRKk6uBcL9QhLH0Vq0i4ZcXqVNEqAw25WAh8I1tDDckJc7Cz/60d7AEH0eSSvydnOIlrCt9MwW5vD//V3bWM4Uax2BNwQgudW4ykY8L6Lq97ly4rbsKml2N15WfWxJDO2xeD5bFEKUGHN1CZr3z4GgtuSodJCenQKBgQDnjLXvYtGMib65SP1rpRpGoXOrFiLQOq0d1a/2ySWF3yx5CBrjlk8c6HGeLbDAy2fs2bHkvqOtmbH1BMUygcGRMeS60j2HUf3o15RV9Ut93VrfkVWwXq/RMpDy6ixhvwVhXYN1fGglKwZ64z3z3pvj5Xv6bDjHFeUIRIEy0jeNLwKBgQCcI0nThukgz4WVo4ATHTREinrAde2Ktv+Rxz1mEUPMUjUmIJYa2yx3xu7LYzOSHfsMy9FuCX3ugZaZgu/Y5/bIKlhHoSrIWEyb5KFS8jAKJG8awE8f+Jc5lnqGlU8SCK/DJ15dpIMRmvot2aBJKt3BjDVtXFkbDFjOggMjoNzHcwKBgD8obmfBeI7w84juk9FM04H4f+hmvVA28Ql2Q+z4qLd/TE4nG86ALUwhSvxuUgwEb3B3YMKYDWVIyvWeO3uvUPEdvtoGhqnmf2+HffqEUfce7a6Vod3dte9F76uSnFB9HiaUr0rYiD+7IKVcXoWqbrMW4V5JLqN/IV3D8cm+9VAZAoGAK3hPp4qaAT6FjIG2uJua37JGNqsedU45nRaBa5dG7u28Sl8sK1H18Wr7NLjrtLSQHqHoLuCJpQuDKD4iFJuQQ242ocqnJJwgyA5BM9ylr00xeZss7FPDlo7kke+j0fuFI6okRaH1s8MYAAfk7jn2/1nPziC11if72ZKs2RCCJy0CgYAl+Xcx9hOfziRN7D3oMkpNEL5efrlX/rkCR2tBD9TZ7jFxYNE6qwyw+9CPnFUp2D8OOawf4AkVEehsbrTXv1SocUc9G2nFRZffmhpWz35NXrx1qkHkvRKcVRkrHBf9UT6ILp8Dq2wLyrkF838CvaLB6njDgXDGZwl3aivHQT7ohg==");
    //请更换为您使用的字符集编码，推荐采用utf-8
    certParams.setCharset("utf-8");
    certParams.setFormat("json");
    certParams.setSignType("RSA2");
    //请更换为您的应用公钥证书文件路径
    //    certParams.setCertPath("/home/foo/appCertPublicKey_2019091767145019.crt");
    //请更换您的支付宝公钥证书文件路径
    //    certParams.setAlipayPublicCertPath("/home/foo/alipayCertPublicKey_RSA2.crt");
    //更换为支付宝根证书文件路径l
    //    certParams.setRootCertPath("/home/foo/alipayRootCert.crt");
    return certParams;
  }

  private static AlipayCommerceIotReceiptSendRequest getRequest() {
    // 初始化Request，并填充Model属性。实际调用时请替换为您想要使用的API对应的Request对象。
    AlipayCommerceIotReceiptSendRequest request = new AlipayCommerceIotReceiptSendRequest();
    AlipayOpenOperationOpenbizmockBizQueryModel model = new AlipayOpenOperationOpenbizmockBizQueryModel();
    model.setBizNo("test");
    request.setBizModel(model);
    return request;
  }
}
