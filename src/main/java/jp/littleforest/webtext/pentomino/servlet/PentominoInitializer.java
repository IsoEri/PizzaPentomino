/**
 * Copyright 2010 Yusuke Komori. All rights reserved.
 */
package jp.littleforest.webtext.pentomino.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jp.littleforest.webtext.pentomino.logic.DBInitializer;

/**
 * ピザ・ペントミノ用のデータベースを準備するためのサーブレットです。<br />
 * 
 * @author y-komori
 */
public class PentominoInitializer extends HttpServlet {

    private static final long serialVersionUID = -4163413787978633823L;

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            DBInitializer.initialize();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
