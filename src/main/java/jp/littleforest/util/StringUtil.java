/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util;

/**
 * 文字列に関するユーティリティクラスです。<br />
 * 
 * @author y-komori
 */
public class StringUtil {
    private StringUtil() {

    }

    /**
     * 文字列が {@code null} または空文字列なら {@code true} を返します。
     * 
     * @param text 文字列
     * @return 文字列が {@code null} または空文字列なら {@code true}
     */
    public static final boolean isEmpty(final String text) {
        return text == null || text.length() == 0;
    }

    /**
     * 文字列が {@code null} または空文字列でないなら {@code true} を返します。
     * 
     * @param text 文字列
     * @return 文字列が {@code null} または空文字列でないなら {@code true}
     */
    public static final boolean isNotEmpty(final String text) {
        return !isEmpty(text);
    }

    /**
     * 文字列を指定回数繰り返します。<br />
     * 
     * @param str 文字列
     * @param times 繰り返し回数(0以上)
     * @return 繰り返した文字列
     */
    public static String repeatChar(final String str, final int times) {
        if (str == null || times < 0) {
            return null;
        }

        StringBuffer buf = new StringBuffer(str.length() * times);
        for (int i = 0; i < times; i++) {
            buf.append(str);
        }

        return buf.toString();
    }

    /**
     * 文字列が {@code null} であった場合、空文字列を返します。<br />
     * 
     * @param str 文字列
     * @return 変換後の文字列
     */
    public static String nullToEmpty(final String str) {
        return str == null ? "" : str;
    }

    /**
     * 改行を含む文字列を改行毎に分けて配列として返します。<br />
     * 
     * @param str 文字列
     * @return 改行毎にわけた文字列の配列。元の文字列が {@code null} の場合は、要素 0 の配列
     */
    public static String[] splitToArray(String str) {
        if (str == null) {
            return new String[] {};
        }
        return str.split("(\r\n|\n)");
    }

    /**
     * 文字列中の改行を取り除きます。<br />
     * 
     * @param str 文字列
     * @return 改行を取り除いた文字列
     */
    public static String eliminateLF(String str) {
        if (str != null) {
            str = str.replace("\n", "");
            return str.replace("\r", "");
        } else {
            return null;
        }
    }
}
