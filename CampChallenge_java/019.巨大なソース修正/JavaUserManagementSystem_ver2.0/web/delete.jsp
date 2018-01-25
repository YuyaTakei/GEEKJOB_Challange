<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>削除確認</h1>
        以下の内容を削除します。よろしいですか？<br>
        ID:<%= udd.getUserID()%><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>

        <form action="DeleteResult" method="POST">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="YES" value="はい"style="width:100px">
        </form><br>
            
        <button type="button" onClick="location.href='ResultDetail?id=<%= udd.getUserID()%>&ac=<%= hs.getAttribute("ac") %>'" 
                value="Jump" style="width:100px">いいえ</button>
        <br><br>
        <%=jh.home()%>
    </body>
</html>
