/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino;

/**
 * 定数を保持するクラスです。<br />
 * 
 * @author y-komori
 */
public class Constants {
    /** ログイン中のユーザ情報を保持するためのセッションキー */
    public static final String USER_INFO_SESSION_KEY = "USER_INFO_SESSION_KEY";

    /** カート情報を保存するためのセッションキー */
    public static final String CART_SESSION_KEY = "CART_SESSION_KEY";

    /** データソースの JNDI ルックアップ名 */
    public static final String DATA_SOURCE = "java:comp/env/jdbc/pentominoDB";

    /** iBATIS 用 Dao Config */
    public static final String DAO_CONFIG = "dao.xml";
}
