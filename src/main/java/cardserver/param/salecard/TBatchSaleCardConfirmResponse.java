package cardserver.param.salecard;

import java.text.ParseException;

import cardserver.param.TResponseData;

/**
 * 卡发售确认 | 响应
 */
public final class TBatchSaleCardConfirmResponse extends TResponseData {

  private static final long serialVersionUID = 1L;

  public TBatchSaleCardConfirmResponse() {
  }

  public TBatchSaleCardConfirmResponse(String aString) throws ParseException {
    super(aString);
  }

  @Override
  public String toString() {
    super.toString();
    return jo.toString();
  }

}
