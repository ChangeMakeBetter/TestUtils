package test.thread.thradlocal;

/**
 * </br>
 * Created by yangxiaohua on 2024/7/31.
 */
public class ThreadSession {

  //  public final static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "threadLocal");

  public final static ThreadLocal<String> threadLocal = new ThreadLocal<>();

}
