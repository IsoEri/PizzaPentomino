/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.littleforest.webtext.pentomino.form.ItemListForm;
import jp.littleforest.webtext.pentomino.logic.CartLogic;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 商品一覧画面でカートへ商品を追加する操作のためのアクションです。<br />
 * 
 * @author y-komori
 */
public class ItemListPageAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // フォームから選択された商品のIDを取り出す
        ItemListForm itemListForm = (ItemListForm) form;
        String[] selectedItems = itemListForm.getSelectedItems();

        // セッションオブジェクトを取得する
        HttpSession session = request.getSession();

        // カートへ商品を追加する
        CartLogic cartLogic = new CartLogic();
        cartLogic.addItems(session, selectedItems);

        itemListForm.reset(mapping, request);
        return mapping.findForward("success");
    }
}
