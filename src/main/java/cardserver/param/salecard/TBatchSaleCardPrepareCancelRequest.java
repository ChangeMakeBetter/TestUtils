package cardserver.param.salecard;

import java.text.ParseException;

import cardserver.param.TRequestData;

/**
 * 卡发售prepare取消 | 请求
 */
public final class TBatchSaleCardPrepareCancelRequest extends TRequestData {

  private static final long serialVersionUID = 1L;

  public static final String CCommand = "BatchSaleCardPrepareCancel"; // 命令
  public static final String FNOldTranId = "oldTranId";

  /**
   * 原交易id
   */
  public String oldTranId;

  public TBatchSaleCardPrepareCancelRequest() {
    super();
    command = CCommand;
  }

  public TBatchSaleCardPrepareCancelRequest(String aString) throws ParseException {
    super(aString);
    if (jo.has(FNOldTranId)) {
      oldTranId = jo.getString(FNOldTranId);
    }
  }

  @Override
  public String toString() {
    super.toString();
    jo.put(FNOldTranId, oldTranId);
    return jo.toString();
  }
}
