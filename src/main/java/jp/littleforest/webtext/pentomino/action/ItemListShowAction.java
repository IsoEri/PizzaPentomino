/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.littleforest.webtext.pentomino.logic.ProductLogic;
import jp.littleforest.webtext.pentomino.logic.impl.IbatisProductLogic;
import jp.littleforest.webtext.pentomino.model.ProductItem;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 商品一覧画面を表示するためのアクションです。<br />
 * 
 * @author y-komori
 */
public class ItemListShowAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ProductLogic productLogic = new IbatisProductLogic();
        List<ProductItem> productList = productLogic.getProductList();

        request.setAttribute("productList", productList);

        return mapping.findForward("show");
    }
}
