//
// DO NOT MODIFIY!!! This file is created by CodeAssist
//
package test.recover.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import test.recover.entity.TradePaymentLine;

public class DaoTradePaymentLine {
  static public String getTableName() {
    return "wxcyTradePayLine";
  }

  static public int insert(Connection conn, TradePaymentLine bean) throws SQLException {
    if (bean.getUuid() == null) {
      bean.setUuid(java.util.UUID.randomUUID().toString());
    }
    String sql = "insert into " + getTableName() + "(" + //
      "uuid,owner,line,payterm,amount,payResponse,cardNum"
      + ") values (" + //
      "?,?,?,?,?,?,?"
      + ")";
    PreparedStatement stm = conn.prepareStatement(sql);
    int i = 1;
    stm.setString(i++, bean.getUuid());
    stm.setString(i++, bean.getOwner().getUuid());
    stm.setInt(i++, bean.getLine());
    stm.setString(i++, bean.getPayterm());
    stm.setBigDecimal(i++, bean.getAmount());
    stm.setString(i++, bean.getPayResponse());
    stm.setString(i++, bean.getCardNum());
    int rowsAffected = stm.executeUpdate();
    stm.close();
    return rowsAffected;
  }

  static public int[] insertBatch(Connection conn, List<TradePaymentLine> beanList)
    throws SQLException {
    String sql = "insert into " + getTableName() + "(" + //
      "uuid,owner,line,payterm,amount,payResponse,cardNum"
      + ") values (" + //
      "?,?,?,?,?,?,?"
      + ")";
    PreparedStatement stm = conn.prepareStatement(sql);
    for (TradePaymentLine bean : beanList) {

      if (bean.getUuid() == null) {
        bean.setUuid(java.util.UUID.randomUUID().toString());
      }

      int i = 1;

      stm.setString(i++, bean.getUuid());
      stm.setString(i++, bean.getOwner().getUuid());
      stm.setInt(i++, bean.getLine());
      stm.setString(i++, bean.getPayterm());
      stm.setBigDecimal(i++, bean.getAmount());
      stm.setString(i++, bean.getPayResponse());
      stm.setString(i++, bean.getCardNum());

      stm.addBatch();
    }

    final int[] rowsAffected = stm.executeBatch();
    stm.close();
    return rowsAffected;
  }

}