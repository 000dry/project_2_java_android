import java.util.ArrayList;

public class Dealer {

    Deck deck;
    String name;
    ArrayList<Card> hand;

    public Dealer(String name, Deck deck){
        this.name = name;
        this.deck = deck;
        this.hand = new ArrayList<>();
    }


    public Deck getDeck() {
        return this.deck;
    }

    public void dealCard(Player player) {
        Card card = deck.removeCard();
        player.acceptCard(card);
    }

    public int checkCardValue(Player player) {
       Card playersHand = player.getHand().get(0);
       int value = playersHand.getRank().getValue();
       return value;
    }

    public String compareCards(Player player1, Player player2) {
        if(checkCardValue(player1) > checkCardValue(player2)) {
            return "The winner is player 1";
        } else {
            return "The winner is player 2";
        }
    }


}

