<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理フォーム</title>
    </head>
    <body>
        ようこそ　
        <%= request.getAttribute("name")%>
        様
        <br><br>

        <form action="./jdbc13itemserv" method="post">
            商品情報登録はこちら<br><br>
            商品名:
            <input type="text" name="name" required="required"><br>
            個数:
            <input type="number" name="stock" required="required"><br>
            分類:
            <input type="text" name="category" required="required"><br>
            <input type="submit" name="submit">
        </form>
        <br><br><br>
        <form action="./jdbc13stockserv" method="post">
            商品情報一覧はこちら<br>
            <input type="submit" name="submit" value="ページ移動">
        </form>
    </body>
</html>
