<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
    </head>
    <body>
        <form action="./jdbc11serv" method="post">
            データを上書きするIDを入力してください<br>
            <input type="number" name="id" min="1" required="required"><br><br>
            上書きする内容を入力してください<br>
            名前:<br>
            <input type="text" name="name" required="required"><br>
            電話番号:<br>
            <input type="text" name="tel" required="required"><br>
            年齢(半角数字):<br>
            <input type="number" name="age" min="0" required="required"><br>
            生年月日(西暦・1234-56-78のような形で):<br>
            <input type="text" name="birthday" required="required"><br>
            
            <input type="submit" name="submit">
        </form>
    </body>
</html>
