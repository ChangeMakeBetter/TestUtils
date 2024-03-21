//
// DO NOT MODIFIY!!! This file is created by CodeAssist
//
package test.recover.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.recover.entity.TradeProductLine;

public class DaoTradeProductLine {
  static public String getTableName() {
    return "wxcyTradeProdLine";
  }

  static public int insert(Connection conn, TradeProductLine bean) throws SQLException {
    if (bean.getUuid() == null) {
      bean.setUuid(java.util.UUID.randomUUID().toString());
    }
    String sql = "insert into " + getTableName() + "(" + //
      "uuid,location,packages,owner,traceCode,serviceCharge,line,productUuid,amount,productCode,weightType,price,packQty,inputprice,productName,sname,invQty,packagePrice,tareWeight,invBatch,scode,quantity,deposit"
      + ") values (" + //
      "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
      + ")";
    PreparedStatement stm = conn.prepareStatement(sql);
    int i = 1;
    stm.setString(i++, bean.getUuid());
    stm.setString(i++, bean.getLocation());
    stm.setBigDecimal(i++, bean.getPackages());
    stm.setString(i++, bean.getOwner().getUuid());
    stm.setString(i++, bean.getTraceCode());
    stm.setBigDecimal(i++, bean.getServiceCharge());
    stm.setInt(i++, bean.getLine());
    stm.setString(i++, bean.getProductUuid());
    stm.setBigDecimal(i++, bean.getAmount());
    stm.setString(i++, bean.getProductCode());
    stm.setString(i++, bean.getWeightType());
    stm.setBigDecimal(i++, bean.getPrice());
    stm.setBigDecimal(i++, bean.getPackQty());
    stm.setBigDecimal(i++, bean.getInputprice());
    stm.setString(i++, bean.getProductName());
    stm.setString(i++, bean.getSname());
    stm.setBigDecimal(i++, bean.getInvQty());
    stm.setBigDecimal(i++, bean.getPackagePrice());
    stm.setBigDecimal(i++, bean.getTareWeight());
    stm.setString(i++, bean.getInvBatch());
    stm.setString(i++, bean.getScode());
    stm.setObject(i++, bean.getQuantity());
    stm.setBigDecimal(i++, bean.getDeposit());
    int rowsAffected = stm.executeUpdate();
    stm.close();
    return rowsAffected;
  }

}