package cardserver.param.salecard;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.json.JSONArray;

import cardserver.param.CardConverter;
import cardserver.param.TRequestData;

/**
 * 卡发售确认 | 请求
 * <p>
 * 支持多卡发售<br> 支持多种付款方式<br>
 *
 * @author gcr
 */
public final class TBatchSaleCardConfirmRequest extends TRequestData {

  private static final long serialVersionUID = 1L;

  public static final String CCommand = "BatchSaleCardConfirm"; // 命令
  public static final String FNPayRec = "payRec"; // 付款明细
  private static final String FNPrepareOwnerTranId = "prepareOwnerTranId";
  public static final String FNFeeTotal = "feeTotal";
  public static final String FNConsumeCost = "consumeCost";
  public static final String FNOrderFlowNo = "orderFlowNo";
  public static final String FNRetailFlowNo = "retailFlowNo";
  public static final String FNPayAmount = "payAmount";

  /**
   * 付款信息
   */
  public List<TSalePayRec> payRec = new ArrayList<TSalePayRec>();
  /**
   * 充值prepare请求的uuid
   */
  public String prepareOwnerTranId;
  /**
   * 销售单号
   */
  public String orderFlowNo;
  /**
   * 流水号,用于和CRM对账
   */
  public String retailFlowNo;
  /**
   * 总费用
   */
  public BigDecimal feeTotal = BigDecimal.ZERO;
  /**
   * 会员消费金额
   */
  public BigDecimal consumeCost = BigDecimal.ZERO;
  /**
   * 支付金额
   */
  public BigDecimal payAmount = BigDecimal.ZERO;

  public TBatchSaleCardConfirmRequest() {
    super();
    command = CCommand;
  }

  public TBatchSaleCardConfirmRequest(String aString) throws ParseException {
    super(aString);
    if (jo.has(FNPayRec)) {
      JSONArray a = jo.optJSONArray(FNPayRec);
      if (a != null) {
        for (int i = 0; i < a.length(); ++i) {
          payRec.add(new TSalePayRec(a.getJSONObject(i)));
        }
      }
    }
    if (jo.has(FNPrepareOwnerTranId)) {
      prepareOwnerTranId = jo.getString(FNPrepareOwnerTranId);
    }
    if (jo.has(FNFeeTotal)) {
      feeTotal = CardConverter.strToBigDecimal(jo.getString(FNFeeTotal));
    }
    if (jo.has(FNConsumeCost)) {
      consumeCost = CardConverter.strToBigDecimal(jo.getString(FNConsumeCost));
    }
    if (jo.has(FNOrderFlowNo)) {
      orderFlowNo = jo.getString(FNOrderFlowNo);
    }
    if (jo.has(FNRetailFlowNo)) {
      retailFlowNo = jo.getString(FNRetailFlowNo);
    }
    if (jo.has(FNPayAmount)) {
      payAmount = CardConverter.strToBigDecimal(jo.getString(FNPayAmount));
    }
  }

  @Override
  public String toString() {
    super.toString();
    for (int i = 0; i < payRec.size(); ++i) {
      jo.accumulate(FNPayRec, payRec.get(i).toJson());
    }
    jo.put(FNPrepareOwnerTranId, prepareOwnerTranId);
    jo.put(FNFeeTotal, CardConverter.bigDecimalToStr(feeTotal));
    jo.put(FNConsumeCost, CardConverter.bigDecimalToStr(consumeCost));
    jo.put(FNOrderFlowNo, orderFlowNo);
    jo.put(FNRetailFlowNo, retailFlowNo);
    jo.put(FNPayAmount, CardConverter.bigDecimalToStr(payAmount));
    return jo.toString();
  }

}
