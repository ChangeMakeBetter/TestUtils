//
// DO NOT MODIFIY!!! This file is created by CodeAssist
//
package test.recover.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import test.recover.entity.Trade;
import utils.Converter;

public class DaoTrade {
  static public String getTableName() {
    return "wxcyTrade";
  }

  static public int insert(Connection conn, Trade bean) throws SQLException {

    String sql = "insert into " + getTableName() + "(" + //
      "uuid,traceCode,vendorUuid,serviceCharge,actualPay,batchNum,goodsTotal,shouldPay,posNo,flowNo,boReceivedTime,filldate,storeName,storeUuid,storeCode,vendorCode,vendorName,cardBalance,multiTradeId,fillerName,fillerUuid,fillerCode,weightAmount,bizEntityName,deposit,memberName,memberCode,patchno,bizEntityCode"
      + ") values (" + //
      "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
      + ")";
    PreparedStatement stm = conn.prepareStatement(sql);
    int i = 1;
    stm.setString(i++, bean.getUuid());
    stm.setString(i++, bean.getTraceCode());
    stm.setString(i++, bean.getVendorUuid());
    stm.setBigDecimal(i++, bean.getServiceCharge());
    stm.setBigDecimal(i++, bean.getActualPay());
    stm.setString(i++, bean.getBatchNum());
    stm.setBigDecimal(i++, bean.getGoodsTotal());
    stm.setBigDecimal(i++, bean.getShouldPay());
    stm.setString(i++, bean.getPosNo());
    stm.setString(i++, bean.getFlowNo());
    stm.setTimestamp(i++, Converter.toTimestamp(bean.getBoReceivedTime()));
    stm.setTimestamp(i++, Converter.toTimestamp(bean.getFilldate()));
    if (bean.getStore() != null) {
      stm.setString(i++, bean.getStore().getName());
      stm.setString(i++, bean.getStore().getUuid());
      stm.setString(i++, bean.getStore().getCode());
    } else {
      stm.setObject(i++, null);
      stm.setObject(i++, null);
      stm.setObject(i++, null);
    }
    stm.setString(i++, bean.getVendorCode());
    stm.setString(i++, bean.getVendorName());
    stm.setBigDecimal(i++, bean.getCardBalance());
    stm.setString(i++, bean.getMultiTradeId());
    if (bean.getFiller() != null) {
      stm.setString(i++, bean.getFiller().getName());
      stm.setString(i++, bean.getFiller().getUuid());
      stm.setString(i++, bean.getFiller().getCode());
    } else {
      stm.setObject(i++, null);
      stm.setObject(i++, null);
      stm.setObject(i++, null);
    }
    stm.setBigDecimal(i++, bean.getWeightAmount());
    stm.setString(i++, bean.getBizEntityName());
    stm.setBigDecimal(i++, bean.getDeposit());
    stm.setString(i++, bean.getMemberName());
    stm.setString(i++, bean.getMemberCode());
    stm.setString(i++, bean.getPatchno());
    stm.setString(i++, bean.getBizEntityCode());

    //    int rowsAffected = stm.executeUpdate();
    System.out.println(stm.toString());
    stm.close();
    return 0;
  }

  static public int[] insertBatch(Connection conn, List<Trade> beanList)
    throws SQLException {
    String sql = "insert into " + getTableName() + "(" + //
      "uuid,traceCode,vendorUuid,serviceCharge,actualPay,batchNum,goodsTotal,shouldPay,posNo,flowNo,boReceivedTime,filldate,storeName,storeUuid,storeCode,vendorCode,vendorName,cardBalance,multiTradeId,fillerName,fillerUuid,fillerCode,weightAmount,bizEntityName,deposit,memberName,memberCode,patchno,bizEntityCode"
      + ") values (" + //
      "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
      + ")";
    PreparedStatement stm = conn.prepareStatement(sql);
    for (Trade bean : beanList) {

      int i = 1;

      stm.setString(i++, bean.getUuid());
      stm.setString(i++, bean.getTraceCode());
      stm.setString(i++, bean.getVendorUuid());
      stm.setBigDecimal(i++, bean.getServiceCharge());
      stm.setBigDecimal(i++, bean.getActualPay());
      stm.setString(i++, bean.getBatchNum());
      stm.setBigDecimal(i++, bean.getGoodsTotal());
      stm.setBigDecimal(i++, bean.getShouldPay());
      stm.setString(i++, bean.getPosNo());
      stm.setString(i++, bean.getFlowNo());
      stm.setTimestamp(i++, Converter.toTimestamp(bean.getBoReceivedTime()));
      stm.setTimestamp(i++, Converter.toTimestamp(bean.getFilldate()));
      if (bean.getStore() != null) {
        stm.setString(i++, bean.getStore().getName());
        stm.setString(i++, bean.getStore().getUuid());
        stm.setString(i++, bean.getStore().getCode());
      } else {
        stm.setObject(i++, null);
        stm.setObject(i++, null);
        stm.setObject(i++, null);
      }
      stm.setString(i++, bean.getVendorCode());
      stm.setString(i++, bean.getVendorName());
      stm.setBigDecimal(i++, bean.getCardBalance());
      stm.setString(i++, bean.getMultiTradeId());
      if (bean.getFiller() != null) {
        stm.setString(i++, bean.getFiller().getName());
        stm.setString(i++, bean.getFiller().getUuid());
        stm.setString(i++, bean.getFiller().getCode());
      } else {
        stm.setObject(i++, null);
        stm.setObject(i++, null);
        stm.setObject(i++, null);
      }
      stm.setBigDecimal(i++, bean.getWeightAmount());
      stm.setString(i++, bean.getBizEntityName());
      stm.setBigDecimal(i++, bean.getDeposit());
      stm.setString(i++, bean.getMemberName());
      stm.setString(i++, bean.getMemberCode());
      stm.setString(i++, bean.getPatchno());
      stm.setString(i++, bean.getBizEntityCode());

      stm.addBatch();
    }

    final int[] rowsAffected = stm.executeBatch();
    stm.close();
    return rowsAffected;
  }

}