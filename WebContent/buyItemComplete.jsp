<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta charset="utf-8">
	<title>BuyItemComplate画面</title>
	<link rel="stylesheet" href="./css/common.css">
	<link rel="stylesheet" href="./css/buyItem.css">
</head>
<body>
	<header id="header">
		<div class="cmpName" ><a href='<s:url action="GoHomeAction"/>' class="releaseLink">AI.inc</a></div>
		<div class="session">
			<s:if test="#session.user_id != null">
				<a href='<s:url action="GoHomeAction" />' class="home">ホーム</a>
				<a href='<s:url action="MyPageAction" />' class="myPage">マイページ</a>
				<a href='<s:url action="LogoutAction" />' class="logInOut" >ログアウト</a>
			</s:if>
			<s:else>
				<% application.getRequestDispatcher("/login.jsp").forward(request, response); %>
			</s:else>
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>BuyItemComplate</p>
		</div>
		<div class="completeMessage">
			<p>購入手続きが完了致しました。</p>
			<div>
				<a href='<s:url action="MyPageAction" />'>マイページ</a><span>から購入履歴の確認が可能です。</span>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>

</body>
</html>