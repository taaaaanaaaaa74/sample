
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<!-- 送信先 -->
<!-- actionにはweb.xmlで書いたパス -->
<form method="post" action="Login">

<h1>ログイン</h1>
<br>



<table>
<!-- 名前 -->
<tr><td>名前 </td><td><input type="text" name="name"></td></tr>

<!-- パスワード -->
<tr><td>パスワード</td><td><input type="password" name="pass"></td></tr>

</table>


<input type="submit" value="ログイン">

</form>
</body>
</html>