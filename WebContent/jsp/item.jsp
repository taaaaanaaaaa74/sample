<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id = "item" scope = "session" class ="nkym.ItemBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品詳細</title>
</head>
	<body>

		<div id="contents">
		<div><h1 class="animation">商品紹介</h1></div>

			<div style="float:left;">
				<img src="../images/<jsp:getProperty name = "item" property = "img"/>" alt="サンプル" width="400" height="400">
			</div>


			<div style="float:right;">
				<table border="3" width="500" height="350">
					<tr>
						<th>商品名</th>
						<td><jsp:getProperty name = "item" property = "name"/></td>
					</tr>
					<tr>
						<th>カテゴリ</th>
						<td><jsp:getProperty name = "item" property = "category"/></td>
					</tr>
					<tr>
						<th>価格</th>
						<td><jsp:getProperty name = "item" property = "price"/></td>
					</tr>
					<tr>
						<th>在庫</th>
						<td><jsp:getProperty name = "item" property = "stock"/></td>
					</tr>
					<tr>
						<th>商品紹介</th>
						<td><jsp:getProperty name = "item" property = "msg"/></td>
					</tr>
				</table>
				<!-- CartServletへ送る -->
				<form action = "CartServlet" method = "post">
					個数
					<select name = "num" class = "btn-right-radius">
						<!-- ItemBeanの在庫と同じ数のオプションを作成 -->
						<% for(int i = 0;i<=item.getStock();i++){%>
						<option value="<%= i %>"><%= i %></option>
						<% }%>
					</select>
					<!-- カート画面へ -->
					<input type="submit" name="<jsp:getProperty name = "item" property = "name"/>" value="カートへ" class="btn-right-radius">
					<!-- 検索結果画面へ -->
					<input type="submit" name = "jump" value="戻る"class="btn-right-radius">
				</form>

			</div>
		</div>
	</body>
</html>