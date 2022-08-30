package cardserver.param;

public class SposException extends Exception {
  private static final long serialVersionUID = 1L;
  private int code;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public SposException() {
    super();
  }

  public SposException(String message) {
    super(message);
  }

  public SposException(Exception e) {
    super(e);
  }

  public SposException(TRetCode code) {
    super(code.getMessage());
    this.code = code.getCode();
  }


  public SposException(int code, String message) {
    super(message);
    this.code = code;
  }
}
