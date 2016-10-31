<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>ピザ・ペントミノ - ログイン</title>
</head>
<body>
    <h1>ピザ・ペントミノへようこそ！</h1>

    <html:form action="loginPage" styleClass="login">
        <table class="login" align="center">
	    <tr>
	        <td>ユーザ名</td>
	        <td><html:text property="user" size="16"  value=""/></td>
	    </tr>
	    <tr>
	        <td>パスワード</td>
	        <td><html:password property="password" size="16" value=""/></td>
	    </tr>
	    </table>
	    
	    <html:submit value="ログイン" />
	</html:form>

</body>
</html>
