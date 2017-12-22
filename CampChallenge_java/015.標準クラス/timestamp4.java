package timestamp;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class timestamp4 {
    public static void main(String[] args){
        //c1とc2という2つのインスタンスを作成しそれぞれに時間設定
        Calendar c1 = Calendar.getInstance();
        c1.set(2015,0,1,0,0,0);
        Calendar c2 = Calendar.getInstance();
        c2.set(2015,11,31,23,59,59);
        
        //CalendarクラスでgetTimeメソッドを使うとDateオブジェクトを取得出来る
        Date c1date = c1.getTime();
        //DateクラスでのgetTimeメソッドでは時刻値（ミリ秒）を取得出来る
        //時刻値とは1970年1月1日0時0分0秒を起点とした経過ミリ秒
        //今回はlong型で取得して計算に使う
        long c1time = c1date.getTime();
        
        //同様にc2（Dateクラスの取得を省略）の時刻値を取得
        long c2time = c2.getTime().getTime();
        
        //差を減算して表示
        System.out.print(c2time - c1time);
    }
}
