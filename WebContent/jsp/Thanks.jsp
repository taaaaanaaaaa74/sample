<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>お買い上げありがとうございました！</title>
		<link rel="stylesheet" type="text/css" href="../css/thanks.css">
	</head>

	<body>
		<div id="contents">
			<center>
				<img src="../images/thanks.png" width="300" height="200">
				<h1>お買い上げありがとうございました！</h1>
					<form action="ThanksServlet" method="POST">

					<input id="btn-edge" type ="submit" value = "買い物を続ける" name="thanks">
					<input id="btn-edge" type = "submit" value = "ログアウト" name="thanks">
				</form>
			</center>
		</div>
	</body>
</html>