/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * 選択された商品の一覧を保持するためのアクションフォームBeanです。<br />
 * 
 * @author y-komori
 */
public class ItemListForm extends ActionForm {

    private static final long serialVersionUID = 5067407054491876193L;

    // 選択された商品IDの配列
    private String[] selectedItems;

    /**
     * 選択された商品IDの配列を取得します。<br />
     * 
     * @return 選択された商品IDの配列
     */
    public String[] getSelectedItems() {
        return selectedItems;
    }

    /**
     * 選択された商品IDの配列を設定します。<br />
     * 
     * @param selectedItems 選択された商品IDの配列
     */
    public void setSelectedItems(String[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    /* (non-Javadoc)
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        selectedItems = null;
    }

}
