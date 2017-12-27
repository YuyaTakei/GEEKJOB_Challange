package fileop;
import java.io.*;

public class fileop1 {
    public static void main(String[] args){
        //IOExceptionという例外が発生する可能性があるのでキャッチする必要がある
        try{
            File fp = new File("profile.text");
            //書き込み用インスタンス作成（FileWriterクラス）
            FileWriter fw = new FileWriter(fp);
            //書き込み
            fw.write("武井です。よろしくおねがいします。");
        
            fw.close();
        }
        //例外処理発生時の処理
        //catch(例外クラス 変数名)
        catch(IOException e){
            //エラー内容を表示
            System.out.println(e);
        }
    }
    
}

//例外とは→Throwableクラスを継承したオブジェクトをスローする事で発生する。
//例外としてスローされるクラスは次の三種
//・Exception このクラスがthrowされるソースはコンパイル時に例外処理の実装が強制される
//（今回がこのExceptionクラスを継承したIOExceptionクラス）
//・RuntimeException　例外処理の実装が強制されない
//・Error　処理の継続が難しい致命的な場合であるため例外処理も記述できない