<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans ub = (UserDataBeans) hs.getAttribute("userbeans");
    //セッションをクリア
    hs.invalidate();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= ub.getName()%><br>
        生年月日:<%= ub.getYear() +"年"+ ub.getMonth() +"月"+ub.getDay()+"日"%><br>
        種別:<%= ub.getType()%><br>
        電話番号:<%= ub.getTell()%><br>
        自己紹介:<%= ub.getComment()%><br>
        以上の内容で登録しました。<br>
        <br>
        <%= JumsHelper.getInstance().home() %>
    </body>
</html>
