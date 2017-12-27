package charastrings;

public class charastrings2 {
    public static void main(String[] args){
           String mail = "123456@gmail.com";
           //@が何番目かを取得
           int num = mail.indexOf("@");
           //↑の変数番目以降（つまり@以降）の文字列を取得
           System.out.println(mail.substring(num));
    }
 
}
