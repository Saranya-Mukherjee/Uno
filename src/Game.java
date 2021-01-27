import java.util.Random;

public class Game {

    static Card[] cards =new Card[7];
    static String[] types={"0","1","2","3","4","5","6","7","8","9","r","d","s"};


    public static void getCards(){
        Random random=new Random();
        for(int i=0;i<cards.length;i++){
            cards[i]=new Card(random.nextInt(6),types[random.nextInt(types.length)]);
        }
    }

    public static void main(String[] args) {
        getCards();
        for (Card card : cards) {
            System.out.println(card.makeName());
        }

        Card top=new Card(0,"d");
        System.out.println("============================");
        System.out.println("Top: "+top.makeName());
        Card[] found=top.findCards(cards);

        System.out.println("============================");
        for (Card card : found) {
            System.out.println(card.makeName());
        }
    }

}
