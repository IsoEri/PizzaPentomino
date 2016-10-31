/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.logic;

/**
 * ログイン処理を行うためのビジネスロジックです。<br />
 * 
 * @author y-komori
 */
public class LoginLogic {
    /**
     * ログイン可否をチェックします。<br />
     * 
     * @param user ユーザ名
     * @param password パスワード
     * @return ログインOKの場合、<code>true</code>
     */
    public boolean loginCheck(final String user, final String password) {
        // パスワードが「webtext」ならばログインを許可する
        if ("webtext".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
