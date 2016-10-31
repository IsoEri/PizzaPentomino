/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util.exception;

import java.io.IOException;

/**
 * {@link IOException} をラップするランタイム例外です。<br />
 * 
 * @author y-komori
 */
public class IORuntimeException extends RuntimeException {

    private static final long serialVersionUID = 666823676956611560L;

    /**
     * {@link IORuntimeException} を構築します。<br />
     * 
     * @param ex {@link IOException} オブジェクト
     */
    public IORuntimeException(final IOException ex) {
        super(ex);
    }

    /**
     * メッセージを指定して {@link IORuntimeException} を構築します。<br />
     * 
     * @param message メッセージ
     */
    public IORuntimeException(String message) {
        super(message);
    }
}
