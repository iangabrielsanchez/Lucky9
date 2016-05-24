import java.util.Random;
import java.util.Date;

public class Deck {
    private int remainingCards;
    private int decks;
    private String[][]card;
    
    public Deck(int _decks){
        decks = _decks;
        remainingCards = decks*52;
        card = new String[decks][52];
        initializeDeck();
    }
    
    private void initializeDeck(){
        int counter=1;
        for (int x = 0; x < decks; x++) {
            for (int y = 0; y < 52; y++) {
                if(y<=12){                     //assign suit1(spade)
                    counter = counter>13 ? 1:counter;
                    card[x][y]="spade"+(counter);
                    counter++;
                }
                else if(y>12&&y<=25){
                    counter = counter>13 ? 1:counter;
                    card[x][y]="club"+counter;
                    counter++;
                }
                else if(y>25&&y<=38){
                    counter = counter>13 ? 1:counter;
                    card[x][y]="heart"+counter;
                    counter++;
                }
                else if(y>38&&y<=51){
                    counter = counter>13 ? 1:counter;
                    card[x][y]="diamond"+counter;
                    counter++;
                }
            }
        }
    }
    
    public String cardPick(){
        boolean loop = true;
        int x=0,y=0;
        int min=0,max=0;
        if(remainingCards!=0){
            while(loop){
                new Random(new Date().getTime());
                x = 0 + (int)(Math.random() * decks);
                y = 0 + (int)(Math.random() * 52);
                min = y<min? y : min;
                max = y>max? y : max;
                //System.out.println("x: "+ x + ", y: "+y);
                loop = card[x][y].isEmpty();
            }
            String cardPicked = card[x][y];
            card[x][y]="";
            remainingCards--;
            //System.out.println("Cards Remaining: "+remainingCards);
            return cardPicked;
        }
        else{
            return "";
        }
    }
    
    public int getRemainingCards(){
        return remainingCards;
    }
    public int getDeckCount(){
        return decks;
    }
    
    public static void main(String[]args){
        Deck cards = new Deck(1);
        boolean flag = false;
        String show;
        int c=0;
        while(!flag){
            show = cards.cardPick();
            if(!show.isEmpty()){
                System.out.println(show+"\t"+ ++c);
                
            }
            else
                flag=true;
        }
    }
}