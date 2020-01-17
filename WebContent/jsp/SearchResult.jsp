<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- import -->
<%@ page import="java.util.ArrayList"%>
<%@ page import="nkym.SearchBean"%>
<% ArrayList<SearchBean> list = (ArrayList<SearchBean>)session.getAttribute("productList"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="contents">

		<h1>検索</h1>
			<form action="SearchSurvlet" method="post">
			<div id="search">
				<input type="text" name="search">
				<select name="category">
					<option value="食品">食品</option>
						<option value="家電">家電</option>
						<option value="生活用品">生活用品</option>
						<option value="コスメ">コスメ</option>
						<option value="ゲーム">ゲーム</option>
				</select>
				</div>
				<br>
				<input  id="submit_button" type="submit"  name="jump" value="検索">
				</form>
				<form action="ItemServlet" method="post">
				<%if( list.size() == 0) {%>
				<div class="box">
    				<p>！検索結果がありません！</p>
				</div>
				<%} else if(list.size() != 0){%>
				<table border="1" >
					<tr>
						<th>商品名</th>
						<th>価格</th>
						<th>詳細</th>
					</tr>
					<% for(SearchBean search:list) { %>
					<tr>
						<td><%= search.getName() %></td>
						<td><%= search.getPrice() %></td>
						<td><input id="syousai" type = "submit" name="<%= search.getName() %>"  value ="詳細"></td>
					</tr>
					<% }%>
				</table>

				<% }%>
			</form>
		</div>
	</body>
</body>
</html>