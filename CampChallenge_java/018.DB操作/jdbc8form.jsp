<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
    </head>
    <body>
        <form action="./jdbc8serv" method="post">
            検索したい名前を入力してください<br>
            <input type="text" name="name" value="">
            <input type="submit" name="submit">
        </form>
    </body>
</html>
