import java.util.Arrays;

public class Hand extends Card{

    private Card playerHand[];

    public Card[] getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Card[] playerHand) {
        this.playerHand = playerHand;
    }

    public static boolean checkDuplicates(Card[] playerHand1, Card[] playerHand2){
        boolean check = true;
        for (Card testCard1 :
                playerHand1) {
            for (Card testCard2 :
                    playerHand2) {
                if (testCard1 == testCard2){
                    check = false;
                }
            }
        }
        return check;
    }

    private static int[] countCards(Card[] playerHand){
        int[] countArray = new int[13];
        for (int i = 0; i < playerHand.length; i++){
            int card = playerHand[i].getNumber();
            countArray[card]++;
        }
        Arrays.sort(countArray);
        return countArray;
    }
    public static int handScore(Card[] playerHand){
        int score = 0;

        if (Hand.hasFlush(playerHand) && Hand.hasStraight(playerHand) && playerHand[0].getNumber() == 8) {
            score = 23;
        }
        else if (Hand.hasFlush(playerHand) && Hand.hasStraight(playerHand)){
            score = 22;
        }
        else if (hasFourOfAKind(playerHand)){
            score = 21;
        }
        else if (hasFullHouse(playerHand)){
            score = 20;
        }
        else if (hasFlush(playerHand)){
            score = 19;
        }
        else if (hasStraight(playerHand)){
            score = 18;
        }
        else if (hasThreeOfAKind(playerHand)){
            score = 17;
        }
        else if (hasTwoPair(playerHand)){
            score = 15;
        }
        else if(hasPair(playerHand)){
            score = 14;
        }
        else{
            score = playerHand[4].getNumber();
        }
        return score;
    }
    private static boolean hasFlush(Card[] playerHand){
        boolean flush = true;
        for (int flushCheck = 1; flushCheck < playerHand.length; flushCheck++){
            String test = playerHand[0].getSuit();
            if(test != playerHand[flushCheck].getSuit()){
                flush = false;
                break;
            }
        }
        return flush;
    }
    private static boolean hasStraight(Card[] playerHand){
        boolean straight = false;
        for (int straightCheck = 1; straightCheck < playerHand.length; straightCheck++){
            if (playerHand[straightCheck].getNumber() == playerHand[straightCheck - 1].getNumber() + 1){
                straight = true;
            }
        }
        return straight;
    }
    private static boolean hasFourOfAKind(Card[] playerHand){
        boolean fourOfAKind = false;
        int repeat = 0;
        for (int i = 0; i < playerHand.length; i++){
            int testCard = playerHand[i].getNumber();
            for (int j = 0; j < playerHand.length; j++){
                if (testCard == playerHand[j].getNumber()){
                    repeat++;
                }
            }
        }
        if (repeat == 4){
            fourOfAKind = true;
        }
        return fourOfAKind;
    }
    private static boolean hasFullHouse(Card[] playerHand){
        boolean fullHouse = false;
        int[] cardCountArray = countCards(playerHand);
        if (cardCountArray[4] == 3 && cardCountArray[3] == 2){
            fullHouse = true;
        }
        return fullHouse;
    }
    private static boolean hasThreeOfAKind(Card[] playerHand){
        boolean threeOfAKind = false;
        int[] cardCountArray = countCards(playerHand);
        if (cardCountArray[4] == 2 && cardCountArray[3] == 2){
            threeOfAKind = true;
        }
        return threeOfAKind;
    }
    private static boolean hasTwoPair(Card[] playerHand){
        boolean twoPair = false;
        int[] cardCountArray = countCards(playerHand);
        if (cardCountArray[12] == 2 && cardCountArray[11] == 2){
            twoPair = true;
        }
        return twoPair;
    }
    private static boolean hasPair(Card[] playerHand){
        boolean pair = false;
        int[] cardCountArray = countCards(playerHand);
        if (cardCountArray[12] == 2){
            pair = true;
        }
        return pair;
    }
}