import java.util.Random;
public class Card {

    String suit;
    int number;

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public Card() {
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
