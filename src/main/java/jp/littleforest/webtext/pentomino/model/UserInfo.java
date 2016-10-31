/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.model;

import java.io.Serializable;

/**
 * ログイン中のユーザ情報を保持するためのクラスです。<br />
 * 
 * @author y-komori
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -995968529508654626L;

    // ユーザ名
    private String userName;

    /**
     * ユーザ名を取得します。<br />
     * 
     * @return ユーザ名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザIDを設定します。<br />
     * 
     * @param userName ユーザID
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
