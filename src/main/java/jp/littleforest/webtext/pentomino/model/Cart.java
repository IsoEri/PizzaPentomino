/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ショッピングカートを表すモデルです。<br />
 * 
 * @author y-komori
 */
public class Cart {
    // 購入商品情報(商品ID と 個数のマップ)
    private Map<String, Integer> cart = new HashMap<String, Integer>();

    /**
     * カートに商品を追加します。<br />
     * 
     * @param itemId 商品ID
     * @param quantity 注文個数
     */
    public void addItem(String itemId, int quantity) {
        Integer currentQt = cart.get(itemId);
        if (currentQt == null) {
            currentQt = new Integer(0);
        }

        cart.put(itemId, new Integer(currentQt.intValue() + quantity));
    }

    /**
     * カートに保存された商品IDの配列を返します。<br />
     * 
     * @return 商品IDの配列
     */
    public String[] getItemIds() {
        Set<String> itemIdSet = cart.keySet();
        String[] result = new String[itemIdSet.size()];
        itemIdSet.<String> toArray(result);
        Arrays.sort(result);
        return result;
    }

    /**
     * 商品IDに対する注文数を返します。<br />
     * 
     * @param itemId 商品ID
     * @return 注文数
     */
    public int getQuantity(String itemId) {
        if (itemId == null) {
            return 0;
        }

        Integer quantity = cart.get(itemId);
        if (quantity != null) {
            return quantity.intValue();
        } else {
            return 0;
        }
    }
}
