public class Card {

    Suit suit;
    Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }


    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }
}
