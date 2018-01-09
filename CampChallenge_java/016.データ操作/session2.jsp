<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>セッション課題</title>
    </head>
    <body>
        
        <%
            request.setCharacterEncoding("UTF-8");
        //セッションの取得
        HttpSession hs = request.getSession();
          //セッションに書き込み
            hs.setAttribute("name", request.getParameter("txtName"));
            hs.setAttribute("gend", request.getParameter("radioGend"));
            hs.setAttribute("profile", request.getParameter("mulProfile"));
            
        //それぞれセッションを読み出し、String変数に格納
        String n=(String)hs.getAttribute("name");
        String g=(String)hs.getAttribute("gend");
        String p=(String)hs.getAttribute("profile");
        
        //nullの際の値を設定
        if(n == null){
            n = "";
        }
        if(g == null){
            g = "男性";
        }
        if(p == null){
            p = "";
        }
        %>
        <form action="./session2.jsp" method="post">
            名前
            <input type="text" name="txtName" value= <%=n%>>
            <br>性別:　男
            <input type="radio" name="radioGend" value="男性"<%if(g.equals("男性")){%>checked=""<%}%>>
            女
            <input type="radio" name="radioGend" value="女性"<%if(g.equals("女性")){%>checked=""<%}%>>
            <br>趣味
            <textarea name="mulProfile"><%=p%></textarea>
            <input type="submit" name="btnSubmit">
          

        </form>
    </body>
</html>


