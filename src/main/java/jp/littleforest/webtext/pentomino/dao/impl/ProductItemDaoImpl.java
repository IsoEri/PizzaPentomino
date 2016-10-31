/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.dao.impl;

import java.sql.SQLException;
import java.util.List;

import jp.littleforest.webtext.pentomino.dao.ProductItemDao;
import jp.littleforest.webtext.pentomino.model.ProductItem;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

/**
 * {@link ProductItemDao} の実装クラスです。<br />
 * 
 * @author y-komori
 */
public class ProductItemDaoImpl extends SqlMapDaoTemplate implements
        ProductItemDao {

    public ProductItemDaoImpl(DaoManager daoManager) {
        super(daoManager);
    }

    /* (non-Javadoc)
     * @see jp.littleforest.webtext.pentomino.dao.ProductItemDao#selectAll()
     */
    @Override
    public List<ProductItem> selectAll() throws SQLException {
        return getSqlMapExecutor().queryForList("selectAll");
    }
}
