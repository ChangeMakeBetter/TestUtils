package cardserver.param.salecard;

import java.text.ParseException;

import cardserver.param.TResponseData;

/**
 * 卡发售prepare取消 | 响应
 */
public final class TBatchSaleCardPrepareCancelResponse extends TResponseData {

  private static final long serialVersionUID = 1L;

  public TBatchSaleCardPrepareCancelResponse() {
  }

  public TBatchSaleCardPrepareCancelResponse(String aString) throws ParseException {
    super(aString);
  }

  @Override
  public String toString() {
    super.toString();
    return jo.toString();
  }
}
