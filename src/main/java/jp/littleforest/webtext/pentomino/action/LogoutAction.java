/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.action;

import static jp.littleforest.webtext.pentomino.Constants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ログアウト処理を行うためのアクションです。<br />
 * 
 * @author y-komori
 */
public class LogoutAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // セッションからログイン中のユーザ情報を削除
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(USER_INFO_SESSION_KEY);
            session.removeAttribute(CART_SESSION_KEY);
        }
        return mapping.findForward("success");
    }
}
