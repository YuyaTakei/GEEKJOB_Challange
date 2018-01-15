<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
    </head>
    <body>
        <form action="./jdbc10serv" method="post">
            データベースから削除するIDを入力してください<br>
            <input type="number" name="id" required="required"><br>
            
            <input type="submit" name="submit">
        </form>
    </body>
</html>
