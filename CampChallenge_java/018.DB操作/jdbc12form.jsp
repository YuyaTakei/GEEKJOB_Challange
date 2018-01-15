<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
    </head>
    <body>
        <form action="./jdbc12serv" method="post">
            検索したい情報(名前or年齢or生年月日)を入力してください<br>
            <input type="text" name="info" required="required">
            <input type="submit" name="submit">
        </form>
    </body>
</html>
