package jackpack;

//ArrayListをインポート
import java.util.ArrayList;

//抽象クラス Human を用意
abstract class Human{
    
    //カードの合計値
    abstract public int open();
    //手札としてセットするカード
    abstract public void setCard(ArrayList<Integer> card);
    //ヒットするかどうか
    abstract public boolean checkSum();
    //手札
    ArrayList<Integer> myCards=new ArrayList<Integer>();
}