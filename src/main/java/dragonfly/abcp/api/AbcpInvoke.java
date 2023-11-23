package dragonfly.abcp.api;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.tuple.Pair;

import com.sun.jna.Native;
import dragonfly.abcp.api.BpaasApiDLL.BztidCallback;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpFinish;
import dragonfly.abcp.api.BpaasApiDLL.OnAbcpProcess;

public class AbcpInvoke {
  private static Integer msSeedId = Integer.valueOf(256);
  private static Lock msLock = new ReentrantLock();
  private static Map<Integer, Pair<OnAbcpProcess, OnAbcpFinish>> msMapAbcpReponse = new HashMap<Integer, Pair<OnAbcpProcess, OnAbcpFinish>>();

  //////////////////////////////////////////
  public static final String libFilePath = "C:\\opt\\ant-abcp\\bpaas_api.dll";

  public static final int COMMAND_TINY_APP = 100;

  private static int loadCount = 0;
  private static AbcpInvoke instance = null;
  private BpaasApiDLL dll = null;

  public synchronized static AbcpInvoke getInstance() {
    if (instance == null) {
      instance = new AbcpInvoke();
    }
    return instance;
  }

  private File getDiskDllFile() {
    return new File(libFilePath);
  }

  public void init() throws Exception {
    File libFile = getDiskDllFile();
    if (!libFile.exists()) {
      throw new Exception("动态库文件不存在:" + libFile.getAbsolutePath());
    }

    if (loadCount == 0) {
      Native.setProtected(true);
      try {
        dll = (BpaasApiDLL) Native
          .loadLibrary(libFile.getAbsolutePath(),
            BpaasApiDLL.class);
      } catch (Throwable e) {
        System.out.println(e.getMessage());
        throw new Exception(e.getMessage());
      }
      System.out.println("Loaded:" + libFile.getAbsoluteFile());
    } else {
      System.out.println("Already loaded: " + libFile.getAbsolutePath());
    }
    ++loadCount;
  }

  public void abcpInit(String appId, String appVersion, String json, OnAbcpFinish callbackOnFinish,
    OnAbcpProcess callbackOnProcess) {
    if (loadCount <= 0) {
      callbackOnFinish.on_finish(0, 3, "E69001", "[java] source.jni load failed!", "");
      return;
    }
    msLock.lock();
    Integer seedId = msSeedId++;
    //    msMapAbcpReponse.put(seedId, Pair.of(callbackOnProcess, callbackOnFinish));
    msLock.unlock();

    try {
      dll.abcp_init(seedId, appId, appVersion, json, callbackOnProcess, callbackOnFinish);
    } catch (Throwable e) {
      callbackOnFinish.on_finish(seedId, 3, "E69001", e.getMessage(), "");
      System.out.printf("## ERROR ## %s %n", e.getMessage());
    }
  }

  public void abcpStartService(String appId, String serviceCode, String json, OnAbcpFinish callbackOnFinish,
    OnAbcpProcess callbackOnProcess) {
    if (loadCount <= 0) {
      callbackOnFinish.on_finish(0, 3, "E69001", "[java] source.jni load failed!", "");
      return;
    }
    msLock.lock();
    Integer seedId = msSeedId++;
    //    msMapAbcpReponse.put(seedId, Pair.of(callbackOnProcess, callbackOnFinish));
    msLock.unlock();

    try {
      dll.abcp_start_service(seedId, appId, serviceCode, json, callbackOnProcess, callbackOnFinish);
    } catch (Throwable e) {
      callbackOnFinish.on_finish(0, 3, "E69001", e.getMessage(), "");
      System.out.printf("## ERROR ## %s %n", e.getMessage());
    }
  }

  public void getBiztid(BztidCallback bztidCallback) {
    if (loadCount <= 0) {
      bztidCallback.callback(0, "");
      return;
    }
    msLock.lock();
    Integer seedId = msSeedId++;
    msLock.unlock();

    try {
      dll.iotsdk_get_biztid(seedId, 0, bztidCallback);
    } catch (Throwable e) {
      bztidCallback.callback(0, "");
      System.out.printf("## ERROR ## %s %n", e.getMessage());
    }
  }

}