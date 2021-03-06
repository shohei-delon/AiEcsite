<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- formのラベルで囲む作業 -->
	<meta charset=UTF-8>
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>BuyItem画面</title>
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
			<p>Customize Item</p>
		</div>
		<div>
		<s:form action="BuyItemAction">
			<table class="formTable">
				<tr>
					<td colspan="2">
						<s:if test="message !=''">
							<s:property value="message" escape="false" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2"><h3>基本情報</h3></td>
				</tr>
				<tr>
					<td class="formLeft"><span>商品名</span></td>
					<td class="formRight">
						<p>AI機能付きイヤホンorヘッドホン</p>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>商品タイプ</span></td>
					<td class="formRight">
						<select name="itemType">
							<option value="1" selected="selected">ヘッドホン</option>
							<option value="2">Bluetoothヘッドホン</option>
							<option value="3">イヤホン</option>
							<option value="4">Bluetoothイヤホン</option>
							<option value="5">独立型Bluetoothイヤホン</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>会話レベル</span></td>
					<td class="formRight itemTypeRight">
						<label for="talkableNo">
							<input type="radio" name="talkable" value="0" checked="checked" id="talkableNo">
							Lv.0(いらない)
						</label><br>
						<label for="talkable1">
							<input type="radio" name="talkable" value="1" id="talkable1">
							Lv.1(日常会話)
						</label><br>
						<label for="talkable2">
							<input type="radio" name="talkable" value="2" id="talkable2">
							Lv.2(単純計算能力)
						</label><br>
						<label for="talkable3">
							<input type="radio" name="talkable" value="3" id="talkable3">
							Lv.3(百科事典能力)
						</label><br>
						<label for="talkable4">
							<input type="radio" name="talkable" value="4" id="talkable4">
							Lv.4(最近のニュース)
						</label><br>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>声色</span></td>
					<td class="formRight">
						<label for="voiceGender0">
							<input type="radio" name="voiceGender" value="0" id="voiceGender0" checked="checked">男性
						</label>
						<label for="voiceGender1">
							<input type="radio" name="voiceGender" value="1" id="voiceGender1">女性
						</label>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>名前</span></td>
					<td class="formRight">
						<input type="text" name="aiName" maxlength="10" placeholder="AIに名前をつけましょう">
					</td>
				</tr>
				<tr>
					<td colspan="2"><h3>可能技能</h3></td>
				</tr>
				<tr>
					<td class="formLeft"><span>連絡</span></td>
					<td class="formRight">
						<label for="tellable0">
							<input type="radio" name="tellable" value="0" id="tellable0" checked="checked">できない
						</label>
						<label for="tellable1">
							<input type="radio" name="tellable" value="1" id="tellable1">できる
						</label>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>カレンダー</span></td>
					<td class="formRight">
						<label for="schedulable0">
							<input type="radio" name="schedulable" value="0" id="schedulable0" checked="checked">できない
						</label>
						<label for="schedulable1">
							<input type="radio" name="schedulable" value="1" id="schedulable1">できる
						</label>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>アラーム</span></td>
					<td class="formRight">
						<label for="alarmable0">
							<input type="radio" name="alarmable" value="0" id="alarmable0" checked="checked">できない
						</label>
						<label for="alarmable1">
							<input type="radio" name="alarmable" value="1" id="alarmable1">できる
						</label>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>リマインダー</span></td>
					<td class="formRight">
						<label for="remindable0">
							<input type="radio" name="remindable" value="0" id="remindable0" checked="checked">できない
						</label>
						<label for="remindable1">
							<input type="radio" name="remindable" value="1" id="remindable1">できる
						</label>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>マップ</span></td>
					<td class="formRight">
						<label for="mapable0">
							<input type="radio" name="mapable" value="0" id="" checked="checked">できない
						</label>
						<label for="mapable1">
							<input type="radio" name="mapable" value="1" id="">できる
						</label>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>ボードゲーム</span></td>
					<td class="formRight">
					<label for="skillBoardgame1">
						<input type="checkbox" name="skillBoardgame" value="1" id="skillBoardgame1">将棋
					</label>
					<label for="skillBoardgame2">
						<input type="checkbox" name="skillBoardgame" value="2" id="skillBoardgame2">チェス<br>
					</label>
					<label for="skillBoardgame3">
						<input type="checkbox" name="skillBoardgame" value="3" id="skillBoardgame3">囲碁
					</label>
					<label for="skillBoardgame4">
						<input type="checkbox" name="skillBoardgame" value="4" id="skillBoardgame4">オセロ
					</label>

					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>購入個数</span></td>
					<td class="formRight">
						<select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="formLeft"><span>支払い方法</span></td>
					<td>
						<label for="pay1">
							<input type="radio" name="pay" value="1" id="pay1" checked="checked">現金払い
						</label>
						<label for="pay2">
							<input type="radio" name="pay" value="2" id="pay2">クレジットカード
						</label>
					</td>
				</tr>
				<tr><td><s:submit value="購入" /></td></tr>
			</table>
		</s:form>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction" />' class="linked">こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction" />' class="linked">こちら</a></p>
			</div>
		</div>
	</div>
</body>
</html>