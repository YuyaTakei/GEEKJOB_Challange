<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans ub = new UserDataBeans();
    if (hs.getAttribute("userbeans") != null) {
        ub = (UserDataBeans) hs.getAttribute("userbeans");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            名前:
            <input type="text" name="name" 
                   <%
                       if (ub.getName() == null || ub.getName().isEmpty()) { %> 
                   value=""
                   <% } else {%> 
                   value='<%=(String) ub.getName()%><%}%>'>
            <br><br>

            生年月日:
            <select name="year">
                <option value="">----</option>
                <%
                    for (int i = 1950; i <= 2010; i++) {%>
                <option <% if (ub.getYear() != null && !ub.getYear().isEmpty() && Integer.parseInt(ub.getYear()) == i) { %> selected <%}%> value="<%=i%>"> <%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <%
                    for (int i = 1; i <= 12; i++) {%>
                <option <% if (ub.getMonth() != null && !ub.getMonth().isEmpty() && Integer.parseInt(ub.getMonth()) == i) { %> selected <%}%> value="<%=i%>"><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <%
                    for (int i = 1; i <= 31; i++) {%>
                <option <% if (ub.getDay() != null && !ub.getDay().isEmpty() && Integer.parseInt(ub.getDay()) == i) { %> selected <%}%> value="<%=i%>"><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            種別:
            <br>
            <input type="radio" name="type" value="1" 
                   <%
                       if (ub.getType() == 1 || ub.getType() == 0) { %> checked <%}%>>エンジニア<br>
            <input type="radio" name="type" value="2"
                   <%
                       if (ub.getType() == 2) { %> checked <%}%>>営業<br>
            <input type="radio" name="type" value="3"
                   <%
                       if (ub.getType() == 3) { %> checked <%}%>>その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" 
                   <%
                       if (ub.getTell() == null || ub.getTell().isEmpty()) { %> 
                   value=""
                   <% } else {%> 
                   value=<%=(String) ub.getTell()%> <%}%>>
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%
                if (ub.getComment() == null || ub.getComment().isEmpty()) {
                } else {%><%=(String) ub.getComment()%><%}%></textarea>
            <br><br>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
