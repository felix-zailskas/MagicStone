package nl.rug.oop.cardgame.model.deck;

import lombok.Data;
import nl.rug.oop.cardgame.model.card.Card;

import java.util.ArrayList;

/**
 * Deck of discarded cards
 */
@Data
public class DiscardDeck {

    private ArrayList<Card> dicardPile;

    /**
     * Creates a new discard pile
     */
    public DiscardDeck() {
        this.dicardPile = new ArrayList<>();
    }

    /**
     * puts a card onto the discard pile
     * @param card Card
     */
    public void discard(Card card) {
        card.setDiscarded(true);
        this.dicardPile.add(card);
    }
}
