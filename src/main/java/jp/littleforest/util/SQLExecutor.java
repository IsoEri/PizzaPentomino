/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jp.littleforest.util.db.SQLReader;

/**
 * SQL 実行のためのユーティリティクラスです。<br />
 * 
 * @author y-komori
 */
public class SQLExecutor {
    private SQLExecutor() {

    }

    /**
     * ストリームからSQLを読み込んで実行します。<br />
     * 
     * セミコロンで区切られた複数のSQLが記述されている場合、順番に実行します。行中にある -- 以降はコメントとして読み飛ばします。
     * 
     * @param con データベースコネクション
     * @param stream SQL を読み込むための入力ストリーム
     * @return 総更新行数
     * @throws IOException 入出力エラーが発生した場合
     * @throws SQLException SQL実行に失敗した場合
     */
    public static int executeSQL(final Connection con, final InputStream stream)
            throws IOException, SQLException {
        return executeSQL(con, stream, null);
    }

    /**
     * エンコーディングを指定したストリームからSQLを読み込んで実行します。<br />
     * 
     * セミコロンで区切られた複数のSQLが記述されている場合、順番に実行します。行中にある -- 以降はコメントとして読み飛ばします。
     * 
     * @param con データベースコネクション
     * @param stream SQL を読み込むための入力ストリーム
     * @param encoding SQL のエンコーディング
     * @return 総更新行数
     * @throws IOException 入出力エラーが発生した場合
     * @throws SQLException SQL実行に失敗した場合
     */
    public static int executeSQL(final Connection con,
            final InputStream stream, final String encoding)
            throws IOException, SQLException {
        if (con == null) {
            throw new IllegalArgumentException("connection can't be null");
        }
        if (stream == null) {
            throw new IllegalArgumentException("stream can't be null");
        }

        InputStreamReader isr;
        if (encoding != null) {
            isr = new InputStreamReader(stream, encoding);
        } else {
            isr = new InputStreamReader(stream);
        }
        int updateCount = 0;
        SQLReader reader = new SQLReader(isr);
        List<String> sqls = null;
        try {
            sqls = reader.readSql();
        } catch (IOException ex) {
            isr.close();
            throw ex;
        }

        for (String sql : sqls) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                if (!stmt.execute(sql)) {
                    updateCount += stmt.getUpdateCount();
                }
            } catch (SQLException ex) {
                if (stmt != null) {
                    stmt.close();
                }
                throw ex;
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return updateCount;
    }
}
