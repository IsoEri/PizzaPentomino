/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util;

import java.io.Closeable;
import java.io.IOException;

import jp.littleforest.util.exception.IORuntimeException;

/**
 * ストリームを扱うためのユーティリティクラスです。<br />
 * 
 * @author y-komori
 */
public class StreamUtil {
    private StreamUtil() {

    }

    /**
     * ストリームをクローズします。<br />
     * 
     * @param closeable ストリーム
     * @throws IORuntimeException クローズに失敗した場合
     */
    public static void closeStream(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ex) {
                throw new IORuntimeException(ex);
            }
        }
    }
}
