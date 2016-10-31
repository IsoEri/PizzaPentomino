<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>ピザ・ペントミノ - 商品一覧</title>
</head>

<body>
<h1>ピザ・ペントミノ - 商品一覧</h1>

<div align="center">
    <h2><bean:write name="<%=jp.littleforest.webtext.pentomino.Constants.USER_INFO_SESSION_KEY %>" property="userName" scope="session"/>さん、お好きなピザを選んでください</h2>
    
    <html:form action="itemListPage">
        <table class="menu">
        <tr>
            <th>商品</th>
            <th>価格</th>
        </tr>
        <logic:iterate id="productItem" name="productList" type="jp.littleforest.webtext.pentomino.model.ProductItem" scope="request">
        <bean:define id="itemId" name="productItem" property="itemId" type="java.lang.String"/>
        <tr>
            <td>
                <html:multibox property="selectedItems" value="<%=itemId %>" />
                <bean:write name="productItem" property="itemName"/>
            </td>
            <td class="price">&yen;<bean:write name="productItem" property="price"/></td>
        </tr>    
        </logic:iterate>
        </table>
        <html:submit value="チェックした商品をカートに入れる" />
    </html:form>

    <html:form action="cartShow">
        <html:submit value="カートの内容を確認して注文へ進む" />
    </html:form>
    
    <html:form action="logout">
        <html:submit value="ログアウト" />
    </html:form>
</div>
</body>
</html:html>
