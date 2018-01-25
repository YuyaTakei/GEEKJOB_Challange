
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
        削除しました。<br><br>
    <button type="button" onClick="location.href='SearchResult?<%= hs.getAttribute("resultQuery")%>'" value="Jump">検索結果画面へ戻る</button>
    <br><br>
    <%=jh.home()%>
    </body>
</html>
