/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util.exception;

import jp.littleforest.util.StringUtil;

/**
 * 指定されたリソースが見つからなかった場合にスローされる例外です。<br />
 * 
 * @author y-komori
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7785577366972156016L;

    /**
     * パスと原因例外を指定して {@link ResourceNotFoundException} を構築します。<br />
     * 
     * @param path パス
     * @param cause 原因例外
     */
    public ResourceNotFoundException(final String path, final Throwable cause) {
        super(createMessage(path), cause);
    }

    /**
     * リソースのパスを指定して {@link ResourceNotFoundException} を構築します。<br />
     * 
     * @param path リソースのパス
     */
    public ResourceNotFoundException(final String path) {
        super(createMessage(path));
    }

    private static String createMessage(final String path) {
        return StringUtil.nullToEmpty(path) + "is not found.";
    }
}
