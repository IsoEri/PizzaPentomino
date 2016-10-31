/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.model;

import java.io.Serializable;

/**
 * 商品情報を表すクラスです。<br />
 * 
 * @author y-komori
 */
public class ProductItem implements Serializable {
    private static final long serialVersionUID = 2665335486985784409L;

    // 商品ID
    private String itemId;

    // 商品名
    private String itemName;

    // 商品価格
    private int price;

    /**
     * 商品情報を構築します。<br />
     */
    public ProductItem() {
    }

    /**
     * 属性を指定して商品情報を構築します。<br />
     * 
     * @param itemId 商品ID
     * @param itemName 商品名
     * @param price 商品価格
     */
    public ProductItem(String itemId, String itemName, int price) {
        setItemId(itemId);
        setItemName(itemName);
        setPrice(price);
    }

    /**
     * 商品IDを取得します。<br />
     * 
     * @return 商品ID
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 商品IDを設定します。<br />
     * 
     * @param itemId 商品ID
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 商品名を取得します。<br />
     * 
     * @return 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を設定します。<br />
     * 
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 商品価格を取得します。<br />
     * 
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 商品価格を設定します。<br />
     * 
     * @param price 商品価格
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
