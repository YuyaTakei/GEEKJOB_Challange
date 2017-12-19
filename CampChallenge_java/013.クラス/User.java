package jackpack;

import java.util.ArrayList;
import java.util.Random;

public class User extends Human {

    public int open() {
        int sum = 0;
        for (int i = 0; i < myCards.size(); i++) {
            sum += myCards.get(i);
        }
        return sum;
    }

    public void setCard(ArrayList<Integer> card) {
        myCards.addAll(card);
        //myCardsに1が含まれ、openが11以下の時、1を11に置き換える
        if(this.Search(1)!= -1 && this.open() <= 11){
            this.myCards.set(Search(1),11);
        //myCardsに11が含まれ、バストしているときは11を1に置き換える
        }else if(this.Search(11) != -1 && this.open() > 21){
            this.myCards.set(Search(11),1);
        }
    }

    public boolean checkSum() {
        if (this.open() < 17) {
            return true;
        }
        return false;
    }

    //1または11を探す為のリニアサーチメソッド
    public int Search(int num) {
        int discover = -1;
        for (int i = 0; i < myCards.size(); i++) {
            if (myCards.get(i) == num) {
                discover = i;
                return discover;
            }
        }
        return discover;
    }

}
