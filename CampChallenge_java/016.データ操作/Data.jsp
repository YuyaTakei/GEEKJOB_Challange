<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// 受け取るパラメータの文字コード
request.setCharacterEncoding("UTF-8");
// 受け取った名前を表示
out.print("名前　");
out.print(request.getParameter("txtName")+"<br>");
// 性別
out.print("性別　");
out.print(request.getParameter("radioGend")+"<br>");
// 趣味
out.print("趣味　");
out.print(request.getParameter("mulProfile")+"<br>");
%>