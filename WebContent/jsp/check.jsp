<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="nkym.CartBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="logic" class="nkym.Logic" scope="session"/>
<% ArrayList<CartBean> list = (ArrayList<CartBean>)session.getAttribute("list"); %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>購入確認</title>
		<link rel="stylesheet" type="text/css" href="../css/check.css" />
	</head>

	<body>
		<div id="contents">
			<h1>購入してよろしいでしょうか？？</h1>
				<table width="300">
					<tr>
					<% for(CartBean cart:list) { %>
						<th align="center">商品名</th>
						<td align="center"><%= cart.getName() %></td>
					</tr>

					<tr>
						<th align="center">金額</th>
						<td align="center"><%= cart.getPrice() %></td>
					</tr>

					<tr>
						<th align="center">数量</th>
						<td align="center"><%= cart.getNum() %></td>
					</tr>


					<tr>
						<th align="center">消費税</th>
						<td align="center"><%= logic.getTax() %></td>
					</tr>

					<tr>
						<th align="center">合計金額</th>
						<td align="center"><%= logic.getSum() %></td>
					</tr>
					<% } %>

				</table>

				<div id="button">
					<form action="CheckServlet" method="POST">
					<a href="#"><input class="btn-circle-border-double" type="submit" value="はい" name="check"></a>
					<a href="#"><input class="btn-circle-border-double" type="submit" value="いいえ" name="check"></a>

					</form>
				</div>
			</div>
		</div>
	</body>
</html>