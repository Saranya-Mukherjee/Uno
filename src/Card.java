import org.jetbrains.annotations.NotNull;

public class Card {

    int color; //Color of card R=0 G=1 B=2 Y=3 Wild=4 Wild+4=5
    String type; //Type of card. Ignored for wild cards
//    int number; //Number of card if number card
//    char special; //Type of card if special card

    public Card(int color, String type) {
        this.color = color;
        this.type = type;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNumeric(@NotNull Card c) {
        String str = c.type;
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public Card[] findCards(Card[] cards){
        Card top=this;
        int[] pickers= new int[cards.length];
        for(int i=0;i<cards.length;i++){
            pickers[i]=-1;
        }
        int pos=0;
        int ins=0;
        for(Card card : cards){
            if((card.getColor()==4)||(card.getColor()==5)){
                pickers[ins++]=pos;
            }
            else if((card.getColor()==top.getColor())||(card.getType().equals(top.getType()))){
                pickers[ins++]=pos;
            }
            pos++;
        }
        Card[] pick = new Card[ins];
        pos=0;
        for(int i:pickers){
            if(i==-1){
                break;
            }
            pick[pos++]=cards[i];
        }
        return pick;
    }

    public String makeName(){
        String name="";

        switch (this.getColor()){
            case 0:
                name+="red";break;
            case 1:
                name+="green";break;
            case 2:
                name+="blue";break;
            case 3:
                name+="yellow";break;
            case 4:
                name+="wild";return name;
            case 5:
                name+="wild draw 4";return name;
        }
        name+=" ";

        if(this.getType().equals("r")){
            name+="reverse";
        }
        else if(this.getType().equals("d")){
            name+="draw 2";
        }
        else if(this.getType().equals("s")){
            name+="skip";
        }
        else{
            name+=this.getType();
        }

        return name;
    }

}
