<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <form action="./jdbc13loginserv" method="post">
            ユーザーIDとパスワードを入力してください<br><br>
            ID:
            <input type="number" name="id" required="required"><br>
            パスワード:
            <input type="password" name="pass" required="required"><br>
            <input type="submit" name="submit1">
        </form>
        <br><br><br>
        <form action="./jdbc13newuserserv" method="post">
            新規会員登録はこちら<br><br>
            名前:
            <input type="text" name="name" required="required"><br>
            希望するパスワード:
            <input type="password" name="pass" required="required"><br>
            <input type="submit" name="submit2">
        </form>
    </body>
</html>
