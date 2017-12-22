package timestamp;

import java.util.Calendar;


public class timestamp1 {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2016,0,1,0,0,0);
        System.out.print(c.getTime());
    }
}
