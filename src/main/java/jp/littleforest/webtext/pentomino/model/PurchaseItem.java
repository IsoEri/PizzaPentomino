/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.model;

import java.io.Serializable;

/**
 * 購入商品情報を保持するクラスです。<br />
 * 
 * @author y-komori
 */
public class PurchaseItem implements Serializable {
    private static final long serialVersionUID = 653022201097807562L;

    // 商品ID
    private String itemId;

    // 商品名
    private String itemName;

    // 商品価格
    private int price;

    // 注文数
    private int quantity;

    // 小計
    private int subtotal;

    /**
     * {@link PurchaseItem} を構築します。<br />
     * 
     * @param productItem 商品情報オブジェクト
     * @param quantity 個数
     */
    public PurchaseItem(ProductItem productItem, int quantity) {
        this.itemId = productItem.getItemId();
        this.itemName = productItem.getItemName();
        this.price = productItem.getPrice();
        this.quantity = quantity;
        this.subtotal = price * quantity;
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
     * 商品名を取得します。<br />
     * 
     * @return 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品価格を取得します。<br />
     * 
     * @return 商品価格
     */
    public int getPrice() {
        return price;
    }

    /**
     * 注文数を取得します。<br />
     * 
     * @return 注文数
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * 小計を取得します。<br />
     * 
     * @return 小計
     */
    public int getSubtotal() {
        return subtotal;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s %s %d %d %d", itemId, itemName, price,
                quantity, subtotal);
    }
}
