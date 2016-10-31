/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.logic.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.littleforest.webtext.pentomino.Constants;
import jp.littleforest.webtext.pentomino.exception.AppException;
import jp.littleforest.webtext.pentomino.logic.ProductLogic;
import jp.littleforest.webtext.pentomino.model.ProductItem;

/**
 * JDBCアクセスで商品情報を取得する {@link ProductLogic} です。<br />
 * 
 * @author y-komori
 */
public class JdbcProductLogic implements ProductLogic {
    /* (non-Javadoc)
     * @see jp.littleforest.webtext.pentomino.logic.ProductLogic#getProductList()
     */
    public List<ProductItem> getProductList() {
        List<ProductItem> result = new ArrayList<ProductItem>();

        InitialContext ic;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // データソースの取得
            ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup(Constants.DATA_SOURCE);

            // コネクションの取得
            conn = ds.getConnection();

            // SELECT文の発行
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from PRODUCT_ITEM");

            // SELECT結果をProductItemへ詰め直す
            while (rs.next()) {
                String itemId = rs.getString("ITEM_ID");
                String itemName = rs.getString("ITEM_NAME");
                Integer price = rs.getInt("PRICE");

                result.add(new ProductItem(itemId, itemName, price));
            }
        } catch (NamingException ex) {
            throw new AppException(ex);
        } catch (SQLException ex) {
            throw new AppException(ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    // Do nothing.
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    // Do nothing.
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // Do nothing.
                }
            }
        }

        return result;
    }
}
