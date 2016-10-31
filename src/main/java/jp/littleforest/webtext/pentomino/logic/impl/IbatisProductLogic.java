/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.logic.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import jp.littleforest.webtext.pentomino.Constants;
import jp.littleforest.webtext.pentomino.dao.ProductItemDao;
import jp.littleforest.webtext.pentomino.exception.AppException;
import jp.littleforest.webtext.pentomino.logic.ProductLogic;
import jp.littleforest.webtext.pentomino.model.ProductItem;

import com.ibatis.common.resources.Resources;
import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.DaoManagerBuilder;

/**
 * iBATIS で商品情報を取得する {@link ProductLogic} です。<br />
 * 
 * @author y-komori
 */
public class IbatisProductLogic implements ProductLogic {
    /* (non-Javadoc)
     * @see jp.littleforest.webtext.pentomino.logic.ProductLogic#getProductList()
     */
    public List<ProductItem> getProductList() {
        // DAO の取得
        ProductItemDao productItemDao;
        try {
            Reader reader = Resources.getResourceAsReader(Constants.DAO_CONFIG);
            DaoManager daoManager = DaoManagerBuilder.buildDaoManager(reader);
            productItemDao = (ProductItemDao) daoManager
                    .getDao(ProductItemDao.class);
        } catch (IOException ex) {
            throw new AppException(ex);
        }

        // 商品情報一覧の取得
        List<ProductItem> result;
        try {
            result = productItemDao.selectAll();
        } catch (SQLException ex) {
            throw new AppException(ex);
        }

        return result;
    }
}
