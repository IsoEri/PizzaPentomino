<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html:html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel=stylesheet type="text/css" href="css/pentomino.css">
    <title>ピザ・ペントミノ - ログインエラー</title>
</head>

<body>
<div align="center">
    <h1>ピザ・ペントミノ</h1>
    <p>
    ユーザ名またはパスワードが間違っているため、<br />
    ログインできませんでした。
    </p>
    <html:link forward="login">もう一度ログインする</html:link>
</div>
</body>
</html:html>
