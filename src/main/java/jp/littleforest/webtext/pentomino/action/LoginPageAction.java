/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.littleforest.webtext.pentomino.Constants;
import jp.littleforest.webtext.pentomino.form.LoginForm;
import jp.littleforest.webtext.pentomino.logic.LoginLogic;
import jp.littleforest.webtext.pentomino.model.UserInfo;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ログイン処理を行うためのアクションです。<br />
 * 
 * @author y-komori
 */
public class LoginPageAction extends Action {

    /* (non-Javadoc)
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // フォームからパラメータを取り出し
        LoginForm loginForm = (LoginForm) form;
        String user = loginForm.getUser();
        String password = loginForm.getPassword();

        // ユーザ名とパスワードが正しいかどうかチェック
        LoginLogic loginLogic = new LoginLogic();
        String result;
        if (loginLogic.loginCheck(user, password)) {
            HttpSession session = request.getSession();
            UserInfo userInfoBean = new UserInfo();
            userInfoBean.setUserName(user);
            session.setAttribute(Constants.USER_INFO_SESSION_KEY, userInfoBean);
            result = "success";
        } else {
            result = "fail";
        }

        return mapping.findForward(result);
    }
}
