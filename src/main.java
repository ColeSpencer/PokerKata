public final class main {

    public static void main(String args[]){
        Card firstPlayerHand[] = new Card[5];
        Card secondPlayerHand[] = new Card[5];
        boolean b = false;
        while (!b){
            firstPlayerHand = Deck.dealHand();
            secondPlayerHand = Deck.dealHand();
            if (Hand.checkDuplicates(firstPlayerHand, secondPlayerHand)){
                b = true;
            }
        }
        int firstPlayerScore = Hand.handScore(firstPlayerHand);
        int secondPlayerScore = Hand.handScore(secondPlayerHand);
        System.out.println("Player One Hand:");
        for (int i = 0; i < firstPlayerHand.length; i++){
            System.out.print(firstPlayerHand[i].getNumber() + " of " + firstPlayerHand[i].getSuit() + " ");
        }
        System.out.println();
        System.out.println("Player Two Hand:");
        for (int i = 0; i < secondPlayerHand.length; i++){
            System.out.print(secondPlayerHand[i].getNumber() + " of " + secondPlayerHand[i].getSuit() + " ");
        }
        System.out.println();

        if (firstPlayerScore > secondPlayerScore){
            System.out.println("Player 1 wins!");
        }
        else if (secondPlayerScore < firstPlayerScore){
            System.out.println("Player 2 wins!");
        }
        else{
            System.out.println("It's a tie.");
        }
    }

}
