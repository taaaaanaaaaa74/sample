<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="nkym.CartBean"%>
<!DOCTYPE html>
<jsp:useBean id="logic" class="nkym.Logic" scope="session"/>
<% ArrayList<CartBean> list = (ArrayList<CartBean>)session.getAttribute("list"); %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>カート</title>
	</head>
	<body>
		<div id ="contents">
			<h1><span class="roll">カート</span></h1>
					<table>
						<tr>
			 				<th align ="center">商品名</th>
			 				<th align ="center">単価</th>
							<th align ="center">数量</th>
						</tr>
						<% for(CartBean cart:list) { %>
						<tr>
				 			<td align ="center"><%= cart.getName() %></td>
				 			<td align ="center"><%= cart.getPrice() %></td>
				 			<td align ="center"><%= cart.getNum() %></td>
						</tr>
						<% } %>
						<tr>
			 				<td colspan="2" align="center">消費税</td>
			 				<td align="center"><%= logic.getTax()  %></td>
						</tr>
						<tr>
			 				<td colspan="2" align="center">合計金額</td>
			 				<td align="center"><%= logic.getSum() %></td>
					</table>

			<form action = "CartServlet" method = "post">
				<div id ="button">
					<input type = "submit" value = "買い物を続ける" name = "jump">
					<input type = "submit" value = "購入" name = "jump">
				</div>
			</form>

		</div>
	</body>
</html>