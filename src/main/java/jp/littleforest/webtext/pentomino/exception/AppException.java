/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.exception;

/**
 * ピザ・ペントミノのビジネスロジックで発生した例外を表すクラスです。<br />
 * 
 * @author y-komori
 */
public class AppException extends RuntimeException {

    private static final long serialVersionUID = -4086079961471455447L;

    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
