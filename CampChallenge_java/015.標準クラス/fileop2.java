package fileop;
import java.io.*;

public class fileop2 {
    public static void main(String[] args){
        try{
            File fp = new File("profile.text");
            //FileReader作成
            FileReader fr = new FileReader(fp);
            //BufferedReader作成(FileReaderに被せて、拡張する形で利用する)
            BufferedReader br = new BufferedReader(fr);
            //1行読み出し
            System.out.print(br.readLine());
        
            br.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}