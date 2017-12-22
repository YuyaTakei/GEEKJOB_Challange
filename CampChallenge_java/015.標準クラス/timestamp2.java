package timestamp;

import java.util.Date;
import java.text.SimpleDateFormat;


public class timestamp2 {
    public static void main(String[] args){
        //今日の日付
        Date now = new Date();
        //SimpleDateFormat
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy年MM月dd日 HH時:mm分:ss秒");
        
        System.out.print(sdf.format(now));
    }
}
