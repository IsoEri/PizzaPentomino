/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.form;

import org.apache.struts.action.ActionForm;

/**
 * ログイン画面の情報を保持するためのアクションフォームBeanです。<br />
 * 
 * @author y-komori
 */
public class LoginForm extends ActionForm {
    private static final long serialVersionUID = -946009213656428494L;

    private String user;

    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
