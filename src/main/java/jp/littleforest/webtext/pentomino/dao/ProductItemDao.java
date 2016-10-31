/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.dao;

import java.sql.SQLException;
import java.util.List;

import jp.littleforest.webtext.pentomino.model.ProductItem;

import com.ibatis.dao.client.Dao;

/**
 * 商品テーブルにアクセスするための DAO です。
 * 
 * @author y-komori
 */
public interface ProductItemDao extends Dao {
    /**
     * 商品一覧を取得します。<br />
     * 
     * @return 商品のリスト
     */
    public List<ProductItem> selectAll() throws SQLException;
}
