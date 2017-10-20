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
	<title>MyPage画面</title>
	<style type="text/css">
	/* ========TAG LAYOUT======== */
		body {
		   margin:0;
		   padding:0;
		   line-height:1.6;
		   letter-spacing:1px;
		   font-family:Verdana, Helvetica, sans-serif;
		   font-size:12px;
		   color:#333;
		   background:#fff;
		}

		table {
			text-align:center;
			margin:0 auto;
		}

	/* ========ID LAYOUT======== */
		#top {
		   width:780px;
		   margin:30px auto;
		   border:1px solid #333;
		}

		#header {
		   width: 100%;
		   height: 80px;
		   background-color: black;
		}

		#main {
		   width: 100%;
		   height: 500px;
		   text-align: center;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear:both;
		}

		#text-right {
			display: inline-block;
			text-align: right;
		}
	</style>
</head>
<body>
	<div id="header">
	 	<div id="pr">
		</div>
	</div>
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
			<div id="text-right">
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>