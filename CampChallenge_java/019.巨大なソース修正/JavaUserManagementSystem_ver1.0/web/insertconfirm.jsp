<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <%!
            //フォームの空白確認するためのメソッド
            void formCheck(ArrayList bf, String profile, String blank) {
                if (profile.equals("")) {
                    bf.add(blank);
                }
            }
        %>

        <%

            UserDataBeans ub = (UserDataBeans) hs.getAttribute("userbeans");
            
            ArrayList blankform = new ArrayList();
            
            formCheck(blankform, (String) ub.getName(), "名前");
            formCheck(blankform, (String) ub.getYear(), "年");
            formCheck(blankform, (String) ub.getMonth(), "月");
            formCheck(blankform, (String) ub.getDay(), "日");
            formCheck(blankform, (String) ub.getTell(), "電話番号");
            formCheck(blankform, (String) ub.getComment(), "自己紹介");

            if (blankform.size() == 0) {
        %>
        <h1>登録確認</h1>
        名前:<%= ub.getName()%><br>
        生年月日:<%= ub.getYear() + "年" + ub.getMonth() + "月" + ub.getDay() + "日"%><br>
        種別:<%= ub.getType()%><br>
        電話番号:<%= ub.getTell()%><br>
        自己紹介:<%= ub.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
            <% } else { %>
        <h1>入力が不完全です</h1><br>
        <%
            for (int i = 0; i < blankform.size(); i++) {
                out.print(blankform.get(i) + "　");
            }
        %>
        が入力されていません<br><br>
        <% } %>
        
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%= JumsHelper.getInstance().home()%>
    </body>
</html>
