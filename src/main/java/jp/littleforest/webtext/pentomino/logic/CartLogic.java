/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.logic;

import static jp.littleforest.webtext.pentomino.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import jp.littleforest.webtext.pentomino.logic.impl.IbatisProductLogic;
import jp.littleforest.webtext.pentomino.model.Cart;
import jp.littleforest.webtext.pentomino.model.ProductItem;
import jp.littleforest.webtext.pentomino.model.PurchaseItem;

/**
 * ショッピングカートを扱うためのビジネスロジックです。<br />
 * 
 * @author y-komori
 */
public class CartLogic {
    // 商品情報のキャッシュ
    private static Map<String, ProductItem> productItems;

    /**
     * セッションに紐づくショッピングカートへ選択された商品を追加します。<br />
     * 
     * @param session {@link HttpSession} オブジェクト
     * @param productIds 追加する商品IDの配列
     */
    public void addItems(HttpSession session, String[] productIds) {
        if (productIds == null) {
            return;
        }

        Cart cart = retrieveCart(session);
        for (String productId : productIds) {
            cart.addItem(productId, 1);
        }
    }

    /**
     * カートの内容から購入商品のリストを取得します。<br />
     * 
     * @param session {@link HttpSession} オブジェクト
     * @return 購入商品オブジェクトのリスト
     */
    public List<PurchaseItem> getPurchaseItemList(HttpSession session) {
        List<PurchaseItem> result = new ArrayList<PurchaseItem>();
        Cart cart = retrieveCart(session);

        String[] itemIds = cart.getItemIds();
        for (String itemId : itemIds) {
            // 注文個数を取得する
            int quantity = cart.getQuantity(itemId);

            // 購入商品オブジェクトを生成する
            ProductItem productItem = getProductItem(itemId);
            if (productItem != null) {
                PurchaseItem purchaseItem = new PurchaseItem(productItem,
                        quantity);
                result.add(purchaseItem);
            }
        }
        return result;
    }

    /**
     * カートの商品の合計金額を計算して返します。<br />
     * 
     * @param session {@link HttpSession} オブジェクト
     * @return 合計金額
     */
    public int calcTotal(HttpSession session) {
        int total = 0;
        List<PurchaseItem> purchaseItemList = getPurchaseItemList(session);
        for (PurchaseItem item : purchaseItemList) {
            total += item.getSubtotal();
        }
        return total;
    }

    /**
     * セッションからカートを取得します。<br />
     * セッションにカートが存在しない場合、新しく生成します。
     * 
     * @param session セッションオブジェクト
     * @return カートオブジェクト
     */
    private Cart retrieveCart(HttpSession session) {
        Object obj = session.getAttribute(CART_SESSION_KEY);
        if (obj != null) {
            return (Cart) obj;
        } else {
            // セッションにカートが存在しない場合、新しく生成する
            Cart cart = new Cart();
            session.setAttribute(CART_SESSION_KEY, cart);
            return cart;
        }
    }

    /**
     * 商品IDに対応する {@link ProductItem} オブジェクトを返します。<br />
     * 
     * @param itemId 商品ID
     * @return {@link ProductItem} オブジェクト
     */
    private ProductItem getProductItem(String itemId) {
        initProductItems();

        return productItems.get(itemId);
    }

    /**
     * 商品情報のキャッシュを初期化します。<br />
     */
    private void initProductItems() {
        if (productItems != null) {
            return;
        }

        productItems = new HashMap<String, ProductItem>();

        ProductLogic productLogic = new IbatisProductLogic();
        List<ProductItem> productList = productLogic.getProductList();
        for (ProductItem productItem : productList) {
            String itemId = productItem.getItemId();
            productItems.put(itemId, productItem);
        }
    }
}
