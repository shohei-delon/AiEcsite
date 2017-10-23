<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html">
<html>
<head>
	<meta charset=UTF-8>
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>Login画面</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/memberIn.css" >
</head>
<body>
	<header id="header">
		<div class="cmpName" ><a href='<s:url action="GoHomeAction"/>' class="releaseLink">AI.inc</a></div>
		<div class="session">
			<s:if test="#session.user_id != null">
				<a href='<s:url action="MyPageAction" />' class="myPage">マイページ</a>
				<a href='<s:url action="LogoutAction" />' class="logInOut" >ログアウト</a>
			</s:if>
			<s:else>
				<a href='<s:url action="GoHomeAction" />' class="home" >ホーム</a>
				<a href='<s:url action="UserCreateAction" />' class="new" >新規登録</a>
				<a href='<s:url action="LoginAction" />' class="logInOut" >ログイン</a>
			</s:else>
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>
		<div>
			<h3>商品を購入する際にはログインをお願いします。</h3>
			<table>
				<s:form action="LoginAction">
					<tr>
						<td class="labelComp"><label>ログインID:</label></td>
						<td><input type="text" name="loginUserId" value="" /></td>
					</tr>
					<tr>
						<td class="labelComp"><label>ログインPASS:</label></td>
						<td><input type="password" name="loginPassword" value=""></td>
					</tr>
					<s:submit value="ログイン"/>
				</s:form>
			</table>
			<br/>
			<div id="text-link">
				<p>新規ユーザー登録は<a href='<s:url action="UserCreateAction" />'>こちら</a></p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
</body>
</html>