/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.logic;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.littleforest.util.ResourceUtil;
import jp.littleforest.util.SQLExecutor;
import jp.littleforest.util.StreamUtil;
import jp.littleforest.webtext.pentomino.Constants;

/**
 * ピザペントミノ用のデータベースを初期化するためのクラスです。<br />
 * 
 * @author y-komori
 */
public class DBInitializer {

    public static void initialize() throws ClassNotFoundException,
            SQLException, IOException, NamingException {
        Connection conn = getConnection();

        executeSql(conn, "createtable.sql");
        executeSql(conn, "insertdata.sql");

        conn.close();
    }

    private static Connection getConnection() throws NamingException,
            SQLException {
        InitialContext ic;
        ic = new InitialContext();
        DataSource ds = (DataSource) ic.lookup(Constants.DATA_SOURCE);
        return ds.getConnection();
    }

    private static void executeSql(Connection conn, String fileName)
            throws IOException, SQLException {
        InputStream is = null;
        try {
            is = ResourceUtil.getResourceAsStream(fileName);
            SQLExecutor.executeSQL(conn, is);
        } finally {
            StreamUtil.closeStream(is);
        }
    }
}
