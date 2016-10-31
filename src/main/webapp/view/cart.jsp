<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<jsp:useBean id="total" type="java.lang.String" scope="request" />

<html:html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>ピザ・ペントミノ - カート一覧</title>
</head>

<body>
<h1>ピザ・ペントミノ - カート一覧</h1>

<div align="center">
    <h2><bean:write name="<%=jp.littleforest.webtext.pentomino.Constants.USER_INFO_SESSION_KEY %>" property="userName" scope="session"/>さんのカート内の商品は以下の通りです</h2>
    
    <html:form action="complete">
        <table class="menu">
        <tr>
            <th>品名</th>
            <th>単価</th>
            <th>注文数</th>
            <th>金額</th>
        </tr>
        <logic:iterate id="purchaseItem" name="purchaseItemList" type="jp.littleforest.webtext.pentomino.model.PurchaseItem" scope="request">
        <tr>
            <td><bean:write name="purchaseItem" property="itemName"/></td>
            <td class="price"><bean:write name="purchaseItem" property="price"/></td>
            <td class="price"><bean:write name="purchaseItem" property="quantity"/>個</td>
            <td class="price">&yen;<bean:write name="purchaseItem" property="subtotal"/></td>
        </tr>    
        </logic:iterate>
        <tr>
            <th colspan="3" align="right">合計金額</th>
            <td class="price">&yen;<%=total %></td>
        </tr>
        </table>
        <html:submit value="この内容で注文する" />
    </html:form>

    <html:form action="itemListShow">
        <html:submit value="注文をやりなおす" />
    </html:form>
</div>
</body>
</html:html>
