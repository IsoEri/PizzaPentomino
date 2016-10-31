/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util.db;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ストリームから SQL を文単位で読み込むクラスです。<br />
 * 
 * @author y-komori
 */
public class SQLReader {
    private final InputStreamReader reader;

    private int ch = -1; // 読込対象文字

    private int nextCh = -1; // 1文字先読み用バッファ

    public SQLReader(final InputStreamReader reader) {
        if (reader == null) {
            throw new IllegalArgumentException("reader can't be null");
        }

        this.reader = reader;
    }

    /**
     * 入力ストリームから SQL 文を読み込みます。<br />
     * 
     * SQL はセミコロンで区切られます。SQL コメントは無視されます。<br />
     * SQL コメントは1行コメントと、複数行コメントの両方をサポートします。
     * 
     * @return 読み込んだ SQL のリスト
     * @throws IOException 入出力エラーが発生した場合
     */
    public List<String> readSql() throws IOException {
        List<String> result = new ArrayList<String>();
        StringBuilder sql = new StringBuilder(1024);
        int commentDepth = 0;

        for (;;) {
            read();
            if (ch == -1) {
                // ストリームの終端に達した
                break;
            }
            if (ch == '\n' || ch == '\r') {
                // 改行の読み飛ばし
                continue;
            }

            if (commentDepth > 0) {
                // コメント中の場合
                if (ch == '/' && nextCh == '*') {
                    commentDepth++;
                    continue;
                }
                if (ch == '*' && nextCh == '/') {
                    commentDepth--;
                    read(); // '/' を読み飛ばす
                    continue;
                }
            } else {
                if (ch == '-' && nextCh == '-') {
                    skipToLineEnd();
                    continue;
                } else if (ch == '/' && nextCh == '*') {
                    commentDepth++;
                    continue;
                } else if (ch == ';') {
                    result.add(sql.toString());
                    sql = new StringBuilder(1024);
                    continue;
                }

                sql.append((char) ch);
            }
        }
        return result;
    }

    private void skipToLineEnd() throws IOException {
        for (;;) {
            read();
            if (ch == -1 || ch == '\n' || ch == '\r') {
                return;
            }
        }
    }

    private void read() throws IOException {
        if (ch == -1) {
            ch = reader.read();
        } else {
            ch = nextCh;
        }
        nextCh = reader.read();
    }
}
