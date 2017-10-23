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
	<meta charset="utf-8">
	<title>MyPage画面</title>
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
				<a href='<s:url action="LoginAction" />' class="logInOut" >ログイン</a>
			</s:else>
		</div>
	</header>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div>
			<s:if test="myPageList == null">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ご購入情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>AI名</th>
						<th>商品タイプ</th>
						<th>会話レベル</th>
						<th>声色</th>
						<th>連絡</th>
						<th>カレンダー</th>
						<th>アラーム</th>
						<th>リマインダー</th>
						<th>マップ</th>
						<th>ボードゲーム</th>
						<th>値段</th>
						<th>購入個数</th>
						<th>支払い方法</th>
						<th>購入日</th>
					</tr>
					<s:iterator value="myPageList">
					<tr>
						<td><s:property value="aiName" /></td>
						<td><s:property value="itemType" /></td>
						<td>Lv.<s:property value="talkable" /></td>
						<td><s:property value="voiceGender" /></td>
						<td><s:property value="tellable" /></td>
						<td><s:property value="schedulable" /></td>
						<td><s:property value="alarmable" /></td>
						<td><s:property value="remindable" /></td>
						<td><s:property value="mapable" /></td>
						<td><s:property value="skillBoardgame" /></td>
						<td><s:property value="totalPrice" /><span>円</span></td>
						<td><s:property value="count" /><span>個</span></td>
						<td><s:property value="pay" /></td>
						<td><s:property value="insertDate" /></td>
					</tr>
					</s:iterator>
				</table>
			</s:elseif>
		</div>
	</div>
</body>
</html>