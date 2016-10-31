/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.util;

import java.io.InputStream;

import jp.littleforest.util.exception.ResourceNotFoundException;

/**
 * リソースを扱うためのユーティリティクラスです。<br />
 * 
 * @author y-komori
 */
public class ResourceUtil {
    private ResourceUtil() {

    }

    /**
     * 指定されたクラスのパッケージを表すリソースパスを返します。<br />
     * 
     * @param clazz パッケージのリソースパスを取得するクラス
     * @return リソースパス
     */
    public static String getPackagePath(final Class<?> clazz) {
        if (clazz != null) {
            return "/" + clazz.getPackage().getName().replace('.', '/');
        } else {
            return "";
        }
    }

    /**
     * 指定されたクラスと同じパッケージにあるリソースの絶対パスを返します。<br />
     * 
     * @param clazz クラス
     * @param name リソース名
     * @return 絶対パス
     */
    public static String getAbsolutePath(final Class<?> clazz, final String name) {
        String prefix = getPackagePath(clazz);
        if (!"".equals(prefix)) {
            return prefix + "/" + name;
        } else {
            return name;
        }
    }

    /**
     * 指定された名前のルートパッケージに存在するリソースを入力ストリームとして取得します。<br />
     * クラスローダはコンテクストクラスローダを使用します。
     * 
     * @param name リソース名
     * @throws ResourceNotFoundException リソースが見つからなかった場合
     * @return 入力ストリーム
     */
    public static InputStream getResourceAsStream(final String name) {
        String path = getAbsolutePath(null, name);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream in = loader.getResourceAsStream(name);
        if (in != null) {
            return in;
        } else {
            throw new ResourceNotFoundException(path);
        }
    }
}
