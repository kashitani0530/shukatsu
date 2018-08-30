<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定確認</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>パスワード再設定確認画面</h1>
<s:form action="ResetPasswordCompleteAction">

	<table class="leaf"></table>

	<table class="vertical-list-table">
	<tr>
		<th scope="row"><s:label value="ログインID"/></th>
		<td><s:property value="#session.loginId"/></td>
	</tr>
	<tr>
		<th scope="row"><s:label value="新しいパスワード"/></th>
		<td><s:property value="#session.concealedPassword"/></td>
	</tr>
	</table>
	<div class="submit_btn_box">
	<s:submit value="再設定" class="submit_btn" />
	</div>
</s:form>
<div id="piston"></div>
	</div>
<s:include value="footer.jsp"/>
</body>
</html>