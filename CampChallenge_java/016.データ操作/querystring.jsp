<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
switch(Integer.valueOf(request.getParameter("type"))){
    case 1:
        out.print("雑貨");
        break;
    case 2:
        out.print("生鮮食品");
        break;
    case 3:
        out.print("その他");
        break;
}
//totalとcountにIntegerに値するものが入ってなかったときのtry catch文を書きたい
//あとでやろうね
int i = Integer.valueOf(request.getParameter("total"));
int j = Integer.valueOf(request.getParameter("count"));
out.print("<br>"+"総額:"+i+"円　個数:"+j+"<br>");
out.print("一つあたり"+i/j+"円"+"<br>");
if (i >= 5000){
    out.print(i*0.05+"円分ポイントがつきます");
}else if(i >=3000){
    out.print(i*0.04+"円分ポイントがつきます");
}

%>