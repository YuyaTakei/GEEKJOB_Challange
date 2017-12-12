<%@page import="org.mypackage.sample.ResultData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
        %>
    </head>
    <body>
        <%
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日'E'曜日'k'時'mm'分'ss'秒'");
            if(data !=null){
                out.print("<h1>あなたの"+sdf.format(data.getD())+"の運勢は、"+data.getLuck()+"です！</h1>");
            }
        %>
    </body>
</html>
