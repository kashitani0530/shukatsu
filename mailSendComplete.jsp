<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<!-- <meta http-equiv="refresh" content="3;URL='HomeAction'"/>--> <!-- 3秒後、自動的にホーム画面へ遷移 -->
<title>決済完了画面</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>決済完了画面</h1>
<div class="success">
<div>
	<img class = "kusa" src= "images/kusa.svg">
	<img class = "ushi" src= "images/ushi.svg">
	<img class = "kusa" src= "images/kusa.svg">
</div>
<p>決済が完了しました。


</div>

<s:form action="MailSendAction">
<h3>詳細をメールにてお知らせする場合はこちら</h3><br>
<s:submit value="詳細メールを受け取る" class="submit_btn" />
</s:form>

</div>

	<s:include value="footer.jsp" />

</body>
</html>