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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<title>BuyItemConfirm画面</title>
	<link rel="stylesheet" href="./css/common.css">
	<link rel="stylesheet" href="./css/buyItem.css">
	<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>
</head>
<body>
	<header id="header">
		<div class="cmpName" ><a href='<s:url action="GoHomeAction"/>' class="releaseLink">AI.inc</a></div>
		<s:if test="#session.user_id != null">
			<a href='<s:url action="LogoutAction" />' class="logInOut" >ログアウト</a>
		</s:if>
		<s:else>
			<jsp:forward page="login.jsp" />
		</s:else>
	</header>
	<div id="main">
		<div id="top">
			<p>Confirm Item</p>
		</div>
		<div>
			<s:form>
				<tr>
					<td>商品タイプ</td>
					<td><s:property value="itemType(getItemType())" /></td>
				</tr>
				<tr>
					<td>会話レベル</td>
					<td>Lv.<s:property value="getTalkable()"/></td>
				</tr>
				<tr>
					<td>声色</td>
					<td><s:property value="gender(getVoiceGender())" /></td>
				</tr>
				<tr>
					<td>名前</td>
					<td><s:property value="getAiName()" /></td>
				</tr>
				<tr>
					<td>連絡</td>
					<td><s:property value="yesNo(getTellable())" /></td>
				</tr>
				<tr>
					<td>カレンダー</td>
					<td><s:property value="yesNo(getSchedulable())" /></td>
				</tr>
				<tr>
					<td>アラーム</td>
					<td><s:property value="yesNo(getAlarmable())" /></td>
				</tr>
				<tr>
					<td>リマインダー</td>
					<td><s:property value="yesNo(getRemindable())" /></td>
				</tr>
				<tr>
					<td>マップ</td>
					<td><s:property value="yesNo(getMapable())" /></td>
				</tr>
				<tr>
					<td>ボードゲーム</td>
					<td><s:property value="boardgame(getSkillBoardgame())" /></td>
				</tr>
				<tr>
					<td>購入個数</td>
					<td><s:property value="getCount()" />個</td>
				</tr>
				<tr>
					<td>支払い方法</td>
					<td><s:property value="getPay()" /></td>
				</tr>
				<tr>
					<td>合計金額</td>
					<td><s:property value="getTotalPrice()" />円</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('HomeAction')" /></td>
					<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')" /></td>
				</tr>
			</s:form>
		</div>
	</div>
</body>
</html>