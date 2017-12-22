package timestamp;

import java.util.Calendar;
import java.text.SimpleDateFormat;


public class timestamp3 {
    public static void main(String[] args){
        //インスタンスを取得して2016年11月4日10時0分0秒を設定
        Calendar c = Calendar.getInstance();
        c.set(2016,10,4,10,0,0);
        //SimpleDateFormat
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");
        
        System.out.print(sdf.format(c.getTime()));
    }
}
