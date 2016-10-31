/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.littleforest.webtext.pentomino.logic.CartLogic;
import jp.littleforest.webtext.pentomino.model.PurchaseItem;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * カート画面を表示するためのアクションです。<br />
 * 
 * @author y-komori
 */
public class CartShowAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // カートから購入商品情報を取り出す
        CartLogic cartLogic = new CartLogic();
        HttpSession session = request.getSession();

        List<PurchaseItem> purchaseItemList = cartLogic
                .getPurchaseItemList(session);

        int total = cartLogic.calcTotal(session);

        // リクエストスコープへ購入商品情報を格納する
        request.setAttribute("purchaseItemList", purchaseItemList);

        // リクエストスコープへ合計金額を格納する
        request.setAttribute("total", Integer.toString(total));

        return mapping.findForward("success");
    }
}
