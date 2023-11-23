package cardserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import org.apache.tapestry.json.JSONObject;

import cardserver.param.CAccountType;
import cardserver.param.CardConverter;
import cardserver.param.MemberInfo;
import cardserver.param.TCardInfoRec;
import cardserver.param.TLoginRequest;
import cardserver.param.TLoginResponse;
import cardserver.param.TQueryCardRequest;
import cardserver.param.TRequestData;
import cardserver.param.TResponseData;
import cardserver.param.TRetCode;
import cardserver.param.TUCN;
import cardserver.param.TWireData;
import cardserver.param.addterminal.TTerminalAddRequest;
import cardserver.param.addterminal.TTerminalAddResponse;

public class CardServerDemo {

  private String configCardserverUrl;
  private String terminalId;
  private String terminalFeature;

  private boolean running = false;
  private boolean connected = false;
  private String sessionId;
  private String enterpriseId;

  private String connectedErrorMsg;
  protected String cookie = "";
  private LoginThread loginThread;

  public CardServerDemo() {
    running = false;
    connected = false;
    connectedErrorMsg = "未连接服务器";
    cookie = "";
  }

  public CardServerDemo(String configCardserverUrl, String terminalId, String terminalFeature) {
    this.configCardserverUrl = configCardserverUrl;
    this.terminalId = terminalId;
    this.terminalFeature = terminalFeature;
    running = false;
    connected = false;
    connectedErrorMsg = "未连接服务器";
    cookie = "";
  }

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  public boolean isConnected() {
    return connected;
  }

  public String getConnectedErrorMsg() {
    return connectedErrorMsg;
  }

  public synchronized void setConnected(boolean b, String sessionId, String message) {
    String s = b ? "成功" : "错误";
    if (connected ^ b) {
      System.out.println("Card Server连接" + s + " " + message);
      connected = b;
      if (!connected) {
        setCookie("");
      }
    }

    if (!connected) {
      connectedErrorMsg = message;
    } else {
      setSessionId(sessionId);
      setEnterpriseId(sessionId);
      connectedErrorMsg = null;
    }
  }

  public void start() {
    if (running) {
      return;
    }
    System.out.println("CardServer starting...");
    connected = false;
    cookie = "";
    loginThread = new LoginThread();
    loginThread.start();
    running = true;
    System.out.println("CardServer Started");
  }

  public void stop() {
    if (!running) {
      return;
    }
    running = false;
    loginThread.terminate();
    synchronized (loginThread) {
      try {
        loginThread.wait();
        System.out.println("loginThread terminated");
      } catch (InterruptedException e) {
      }
    }
    running = false;
    connected = false;
    cookie = "";
    System.out.println("CardServer Stopped");
  }

  public String callCardServer(String requestString) {
    try {
      JSONObject jo = new JSONObject(requestString);
      jo.put(TRequestData.FNSessionId, sessionId);
      jo.put(TWireData.FNTime, CardConverter.toString(new Date()));
      jo.put(TRequestData.FNTerminalId, terminalId);
      jo.put(TRequestData.FNTranTime, CardConverter.toString(new Date()));

      String result = null;
      TRequestData request = new TRequestData(requestString);

      result = requestCardServer(jo.toString());

      TResponseData response = new TResponseData(result);
      response.termId = request.terminalId;

      if (response.retCode.getCode() == TRetCode.InvalidSession.getCode()) {
        setConnected(false, sessionId, TRetCode.InvalidSession.getMessage());
        return response.toString();
      }

      return result;
    } catch (Exception e) {
      System.out.println("CardServer response error:" + e.getMessage());
      TResponseData response = new TResponseData();
      response.retCode = TRetCode.GeneralError;
      setConnected(false, null, response.retCode.getMessage());
      return response.toString();

    }
  }

  private String requestCardServer(String requestString) throws Exception {
    URL url = new URL(configCardserverUrl);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    try {
      int timeout = 3000;
      conn.setConnectTimeout(timeout);
      conn.setReadTimeout(timeout);
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestMethod("POST");
      conn.setUseCaches(false);
      conn.setRequestProperty("Cookie", getCookie());
      conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
      // CARD-3088
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded ; charset=UTF-8");
      final String trace = UUID.randomUUID().toString().replaceAll("-", "");
      conn.setRequestProperty("trace_id", trace);
      System.out.println("trace_id " + trace);
      // write
      System.out.println("host " + url.toString());
      System.out.println("send " + requestString);
      OutputStream os = conn.getOutputStream();
      // guanxiaobao 2011-07-06 JPOS-1373
      byte[] b = ("requestString=" + URLEncoder.encode(requestString, "UTF-8")).getBytes("UTF-8"); // CARD-3088
      os.write(b, 0, b.length);
      os.flush();
      os.close();

      try {
        // cookie & isCompressed
        String key;
        boolean isCompressed = false;
        String contentEncoding = "GBK";

        for (int i = 1; (key = conn.getHeaderFieldKey(i)) != null; i++) {
          if (key.equalsIgnoreCase("set-cookie")) {
            cookie = conn.getHeaderField(key);
            cookie = cookie.substring(0, cookie.indexOf(";"));
            System.out.println("cookie=" + cookie);
          }
          if (key.equalsIgnoreCase("Content-Encoding")) {
            String value = conn.getHeaderField(key).toLowerCase();
            isCompressed = value.indexOf("gzip") >= 0;
          }
          if (key.equalsIgnoreCase("Content-Type")) {
            String type = conn.getHeaderField(key);
            int idx = type.toLowerCase().indexOf("charset=");
            if (idx >= 0) {
              contentEncoding = type.substring(idx + "charset=".length());
            }
          }
        }

        // read
        InputStream in = null;
        try {
          in = isCompressed ? new GZIPInputStream(conn.getInputStream()) : conn.getInputStream();
        } catch (Exception e) {
          StringBuffer sb = new StringBuffer();
          InputStream errorInputStream = conn.getErrorStream();
          if (errorInputStream != null) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            boolean firstLine = true;
            for (String line = rd.readLine(); line != null; line = rd.readLine()) {
              if (firstLine) {
                firstLine = false;
              } else {
                sb.append("\n");
              }
              sb.append(line);
            }
          }
          System.out.println("Call cardserver error:\n" + sb.toString());
          throw e;
        }

        BufferedReader rd = new BufferedReader(new InputStreamReader(in, contentEncoding));
        String tempLine = rd.readLine();
        StringBuffer tempStr = new StringBuffer();
        // String crlf = System.getProperty("line.separator");
        while (tempLine != null) {
          tempStr.append(tempLine);
          // tempStr.append(crlf);
          tempLine = rd.readLine();
        }
        rd.close();
        in.close();
        System.out.println("recv " + tempStr.toString());
        return tempStr.toString();
      } catch (Exception e) {
        throw e;
      }
    } finally {
      conn.disconnect();
    }
  }

  public void registerServer(String regKey) throws Exception {
    TTerminalAddRequest request = new TTerminalAddRequest();
    request.terminalId = terminalId;
    request.terminalType = "server";
    request.terminalRegisterNumber = regKey;
    request.terminalFeature = terminalFeature;
    String rs = callCardServer(request.toString());
    TTerminalAddResponse response = new TTerminalAddResponse(rs);
    if (!response.retCode.IsOK()) {
      throw new Exception(response.retCode.getMessage());
    }
  }

  public String queryMemberInfo(MemberInfo mi) {
    TCardInfoRec ci = new TCardInfoRec();
    ci.media = "BAR";
    ci.cardType = mi.getCardType();
    ci.cardVersion = mi.getCardVersion();
    ci.enterpriseId = getEnterpriseId();
    ci.randomNumber = mi.getCardRandomNumber();
    ci.validDate = mi.getExpire();

    // JPOS-1159
    ci.cardHolder = mi.getCardHolder();
    ci.balance = mi.getBalance();

    TQueryCardRequest request = new TQueryCardRequest();
    request.cardInfo = ci;
    request.cardServerCheck = true;
    request.needMemberInfo = true;
    if (mi.getCodeType() == MemberInfo.CODETYPE_MOBILEPHONENUMBER) {
      request.cardNumberType = CAccountType.ACCOUNTTYPE_MOBILENUM;
      request.mobilePhoneNum = mi.getCode();
    } else if (mi.getCodeType() == MemberInfo.CODETYPE_MEMBERCODE) {
      request.cardNumberType = CAccountType.ACCOUNTTYPE_MEMBERCODE;
      request.accountAccessCode = mi.getCode();
    } else {
      request.cardInfo.cardNumber = mi.getCode();
      request.cardNumberType = CAccountType.ACCOUNTTYPE_CARDNUM;
    }

    request.queryType = mi.queryType;
    // JPOS-7841
    if ((MemberInfo.CCommandHD.equals(mi.getCommand()))) {
      request.command = TQueryCardRequest.CCommandHD;
    }
    if (mi.getStore() != null) {
      request.store = new TUCN(mi.getStore().getCode(), mi.getStore().getName(), mi.getStore().getUuid());
    }
    System.out.println(" queryCard" + request.toString());
    String responseString = callCardServer(request.toString());
    System.out.println(" response:" + responseString);
    return responseString;

  }

  private class LoginThread extends Thread {
    private int count = 1;
    private int interval = 10;
    private boolean terminated = false;

    public LoginThread() {
      super();
      setName("sclogin");
      terminated = false;
    }

    @Override
    public void run() {
      doLogin();
      while (!terminated) {
        if (connected) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            break;
          }
        } else if (count >= interval) {
          count = 1;
          interval = 10;
          TLoginResponse response = doLogin();
          if (response.retCode.IsOK()) {
            System.out.println("login Success");
          }
        } else {
          ++count;
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            break;
          }
        }
      }
    }

    public void terminate() {
      terminated = true;
    }

  }

  public synchronized TLoginResponse doLogin() {
    TLoginRequest request = new TLoginRequest();
    request.terminalId = terminalId;
    request.terminalFeature = terminalFeature;
    System.out.println("try login" + request.toString());
    String responseString = callCardServer(request.toString());
    System.out.println("try login response" + responseString);
    TLoginResponse response = null;
    try {
      response = new TLoginResponse(responseString);
    } catch (ParseException e) {
      response = new TLoginResponse();
      response.retCode = TRetCode.InvalidWireDataFormat;
    }

    if (response.retCode.IsOK()) {
      setConnected(true, response.sessionId, "登录成功");
    } else {
      setConnected(false, null, "登录失败:" + response.retCode.getMessage());
    }

    return response;
  }

}
