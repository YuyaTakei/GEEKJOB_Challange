package jackpack;

import java.util.ArrayList;
import java.util.Random;

//Humanを継承するクラス Dealer を用意
public class Dealer extends Human {

    //cardsというArrayListを用意
    ArrayList<Integer> cards = new ArrayList<Integer>();

    //初期処理でcardsに全てのカードを持たせる
    public Dealer() {
        for (int j = 0; j <= 4; j++) {
            for (int i = 1; i < 13; i++) {
                //10以上ならば全て10として扱う
                if (i >= 10) {
                    cards.add(10);
                } else {
                    cards.add(i);
                }
            }
        }
    }

    //dealという公開メソッドを用意
    public ArrayList<Integer> deal() {

        //戻し値用のArrayList randealを用意
        ArrayList<Integer> randeal = new ArrayList<Integer>();

        //cardsから二枚ランダムで抜き出し↑randealに入れる
        Random rand = new Random();
        int r = rand.nextInt(cards.size());
        int card1 = cards.get(r);
        cards.remove(r);
        randeal.add(card1);

        Random dom = new Random();
        int d = dom.nextInt(cards.size());
        int card2 = cards.get(d);
        cards.remove(d);
        randeal.add(card2);

        //dealにrandealを返す
        return randeal;
    }

    public ArrayList<Integer> hit() {
        ArrayList<Integer> ranhit = new ArrayList<Integer>();
        //cardsからランダムで抜き出し↑ranhitに入れる
        Random rand = new Random();
        int r = rand.nextInt(cards.size());
        int card1 = cards.get(r);
        cards.remove(r);
        ranhit.add(card1);
        //hitにranhitを返す
        return ranhit;
    }

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
        if(myCards.indexOf(1) != -1 && this.open() <= 11){
            this.myCards.set(myCards.indexOf(1),11);
        //myCardsに11が含まれ、バストしているときは11を1に置き換える
        }else if(myCards.indexOf(11) != -1 && this.open() > 21){
            this.myCards.set(myCards.indexOf(11),1);
        }
    }

    public boolean checkSum() {
        if (this.open() < 17) {
            return true;
        }
        return false;
    }
    
}
