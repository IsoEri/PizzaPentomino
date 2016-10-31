/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.logic;

import java.util.List;

import jp.littleforest.webtext.pentomino.model.ProductItem;

/**
 * 商品情報を扱うためのビジネスロジックのインタフェースです。<br />
 * 
 * @author y-komori
 */
public interface ProductLogic {
    /**
     * 商品情報のリストを返します。<br />
     * 
     * @return 商品情報のリスト
     */
    public List<ProductItem> getProductList();
}
