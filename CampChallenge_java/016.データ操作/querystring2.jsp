<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = Integer.valueOf(request.getParameter("num"));
    //素数iを用意
    int i = 2;
    //周回数を記録する変数h
    int h = 0;
    
    out.print("元の値:" + num + "　素因数:");
    //1になるまで処理をループする
    while (num != 1) {
        //iで割り切れるならば割る
        if (num % i == 0) {
            num = num / i;
            //表示される数字が二個目以降ならば数字の前にカンマを表示する
            if (h > 0) {
                out.print(",");
            }
            out.print(i);
            h++;
        //iで割れないならばiに+1する（2から順番に処理しているので素数以外になっても問題にならない）
        } else {
            i++;
        }
        //2桁の素数が余る場合それを表示し、numを1にしてループ終了
        if (i > 10 && num / i == 1) {
            num = num / i;
            out.print("　余った値:" + i);
        }
    }

%>