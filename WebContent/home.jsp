<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>ホーム画面</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/home.css">
</head>
<body>
	<header id="header">
		<div class="cmpName" ><a href='<s:url action="GoHomeAction"/>' class="releaseLink">AI.inc</a></div>
		<s:if test="#session.user_id != null">
			<a href='<s:url action="LogoutAction" />' class="logInOut" >ログアウト</a>
		</s:if>
		<s:else>
			<a href='<s:url action="LoginAction" />' class="logInOut" >ログイン</a>
		</s:else>
	</header>
	<div id="main">
		<div class="ccComp">
			<h1 id="title">休日はAIとともに</h1>
			<p id="catchcopy">人付き合いに疲れた休日はAIと過ごしませんか</p>
		</div>
		<img alt="AI内蔵新型マイク付きヘッドホン" src="./images/home.png" class="mainImage">
		<div class="nextPage">
			<s:form action="HomeAction">
				<s:submit value="商品購入→"/>
			</s:form>
		</div>
	</div>

</body>
</html>