import java.util.Arrays;
import java.util.Random;

public class Deck extends Card{

    private static Card dealCard(){
        String[] suitArray = {"Clubs", "Spades", "Diamonds", "Hearts"};
        int suitIndex = new Random().nextInt(4);
        String suit = suitArray[suitIndex];
        int[] numberArray = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        int numberIndex = new Random().nextInt(13);
        int number = numberArray[numberIndex];
        return new Card(suit, number);
    }
    public static Card[] dealHand(){
        Card playerHand[] = new Card[5];
        for (int i = 0; i<5; i++){
            playerHand[i] = dealCard();
        }
        return playerHand;
    }
}