package nl.rug.oop.cardgame.model.deck;

import lombok.Data;
import nl.rug.oop.cardgame.util.DefaultStats;
import nl.rug.oop.cardgame.model.card.Card;

import java.util.HashMap;

/**
 * Player's deck hand
 */
@Data
public class DeckHand {

    private HashMap<Integer, Card> deckHand;

    /**
     * Generates a player's deck hand
     */
    public DeckHand() {
        this.deckHand = new HashMap<>();
    }

    /**
     * Adds a card to player's deck hand
     * @param card Takes a card
     */
    public void addCard(DiscardDeck discardDeck, Card card) {
        if (this.deckHand.size() == DefaultStats.MAX_HAND_CARDS) {
            System.out.println("You have too many cards in hand the drawn card is discarded!");
            discardDeck.discard(card);
        }
        else this.deckHand.put(card.getCardNumber(), card);
        System.out.println(card.getCardNumber());
    }

    /**
     * Views the player's deck hand
     */
    public void viewHand() {
        System.out.println("Your hand contains:");
        if (this.deckHand.size() > 0) {
            for (Card card : this.getDeckHand().values()) {
                System.out.println(card.getCardNumber() + ") " + card.getName() + ": Mana Cost -> "
                        + card.getCost());
            }
            System.out.println();
        } else System.out.println("Nothing!");
    }

    /**
     * Removes a card from player's deck hand
     * @param discardDeck discard deck
     */
    public void discardCard(DiscardDeck discardDeck, int key) {
        if (this.deckHand.size() > 0) {
                Card discarded = this.deckHand.get(key);
                discarded.setHandPos(-1);
                this.deckHand.remove(key);
                discardDeck.discard(discarded);
        } else System.out.println("Empty Hand!");
    }


}
