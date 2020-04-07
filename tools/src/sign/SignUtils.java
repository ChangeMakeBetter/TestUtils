package sign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhengzewang on 2019/12/4.
 * 
 *         给第三方用的代码示例
 */
public class SignUtils {

  private static final String CONTENT_TYPE = "Content-Type";

  public static void main(String[] args) throws Exception {
    //
    String appKey = "931tsgyg";
    String secretKey = "IAGEDKWPOV";
    HttpRequest request = new HttpRequest();
    request.setMethod("post");
    request.setPath("/v1/trade/promotion-deposit-trade/deposit");
//    Map<String, List<String>> queries = new HashMap<>();
//    queries.put("ident_type", Arrays.asList("mobile"));
//    queries.put("ident_code", Arrays.asList("15388951793"));
//    request.setQueries(queries);
    request.getHeaders().put(CONTENT_TYPE, Arrays.asList("application/json;charset=UTF-8"));
    request.setBody("{\"tradeId\":{\"id\":\"999200317175925\",\"namespace\":\"JPOS\"},\"tradeNo\":\"202003170008\",\"channel\":{\"id\":\"-\",\"type\":\"store\"},\"occurredOrgId\":\"1285\",\"memberId\":\"d99fd48ef8234fb7965e98843d1c596b\",\"tranTime\":\"2020-03-17T17:59:25.378Z\",\"amount\":\"1.00\",\"faceAmount\":\"1.00\",\"event\":\"refund_recharge\",\"remark\":\"\",\"operator\":\"0\",\"lines\":[{\"payChannel\":{\"id\":\"2c91855270e7eead0170e7ef01c5003b\",\"name\":\"7\"},\"payAmount\":\"1.00\"}]}");
    System.out.println(sign(request, appKey, secretKey));
  }

  public static class HttpRequest {
    private String method;
    private Map<String, List<String>> headers = new HashMap<>();
    private String body;
    private String path;
    private Map<String, List<String>> queries = new HashMap<>();

    public String getFirstHeader(String key) {
      List<String> values = headers.get(key);
      if (values == null || values.size() == 0) {
        return null;
      }
      return values.get(0);
    }

    public String getMethod() {
      return method;
    }

    public void setMethod(String method) {
      this.method = method;
    }

    public Map<String, List<String>> getHeaders() {
      return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
      this.headers = headers;
    }

    public String getBody() {
      return body;
    }

    public void setBody(String body) {
      this.body = body;
    }

    public String getPath() {
      return path;
    }

    public void setPath(String path) {
      this.path = path;
    }

    public Map<String, List<String>> getQueries() {
      return queries;
    }

    public void setQueries(Map<String, List<String>> queries) {
      this.queries = queries;
    }
  }

  /**
   * 
   * @param request
   * @param appKey
   * @param secretKey
   * @return
   * @throws Exception
   */
  public static String sign(HttpRequest request, String appKey, String secretKey) throws Exception {
    StringBuilder stringToSign = new StringBuilder();

    // VERB
    stringToSign.append(request.getMethod().toUpperCase());
    stringToSign.append("\n");

    String contentType = request.getFirstHeader(CONTENT_TYPE);

    // Content-MD5
    String body = request.getBody();
    if (body != null && !contentType.contains("application/x-www-form-urlencoded")) {
      String md5 = DigestUtils.md5DigestAsHex(body.getBytes()).toUpperCase();
      stringToSign.append(SignatureUtils.newStringByBase64(md5.getBytes("UTF-8")));
    }
    stringToSign.append("\n");

    // Content-Type
    if (contentType != null) {
      stringToSign.append(contentType);
    }
    stringToSign.append("\n");

    // Date
    String dateHeaderName = "Date";
    String dateHeader = request.getFirstHeader(dateHeaderName);
    if (dateHeader != null) {
      long datetime = 1;// TODO 将dateHeader转换成时间戳 遵循 RFC 1123 格式，使用 GMT 标准时间。调用方自己换算下，或者header里不设置Date
      if (datetime < System.currentTimeMillis() - 5000 || datetime > System.currentTimeMillis() + 5000) {
        throw new Exception("Request is expired, please try again later");
      }
      stringToSign.append(dateHeader);
    }
    stringToSign.append("\n");

    // Headers
    List<String> headerKeys = request.getHeaders().keySet().stream().filter(s -> s.startsWith("hd-")).sorted().collect(
        Collectors.toList());
    for (String key : headerKeys) {
      List<String> xHds = request.getHeaders().get(key).stream().sorted().collect(Collectors.toList());
      for (String xhd : xHds) {
        stringToSign.append(key).append(":").append(xhd).append("\n");
      }
    }

    // Url Query 或 Form 参数的 Value 可能有多个，多个的时候如何处理 TODO ?
    stringToSign.append(request.getPath());
    Map<String, List<String>> params = request.getQueries();
    if (StringUtils.isNotBlank(body) && contentType.contains("application/x-www-form-urlencoded")) {
      Map<String, List<String>> formParams = Arrays.asList(body.split("&")).stream().map(s -> s.split("=")).collect(
          Collectors.toMap(s -> s[0], s -> {
            List<String> list = new ArrayList<>();
            list.add(s[1]);
            return list;
          }, (v1, v2) -> {
            v1.addAll(v2);
            return v1;
          }));
      for (String key : params.keySet()) {
        List<String> list = formParams.get(key);
        if (list == null) {
          list = new ArrayList<>();
          formParams.put(key, list);
        }
        list.addAll(params.get(key));
      }
      params = formParams;
    }

    if (params.size() > 0) {
      stringToSign.append("?");
      List<String> sortedKeys = params.keySet().stream().sorted().collect(Collectors.toList());
      int i = 0;
      for (String key : sortedKeys) {
        for (String value : params.get(key).stream().sorted().collect(Collectors.toList())) {
          if (i++ > 0) {
            stringToSign.append("&");
          }
          stringToSign.append(key).append("=").append(value);
        }
      }
    }

    byte[] signBytes = SignatureUtils.hmacSHA1Signature(secretKey, stringToSign.toString());
    String signature = SignatureUtils.newStringByBase64(signBytes);
    return signature;
  }

}
