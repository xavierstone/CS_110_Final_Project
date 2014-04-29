import java.util.Random;
import java.util.ArrayList;

public class Deck {

   public final static int STANDARD = 52;
   private ArrayList<Card> deck;
   
   public Deck() {
      deck = new ArrayList<Card>();
   }
   
   public Deck(int cardSet) {
   
      if (cardSet == STANDARD) {
      
         deck = new ArrayList<Card>(STANDARD);
         
         for (int r = Card.ACE; r<=Card.KING;r++)
            for (int s=Card.DIAMONDS;s<=Card.SPADES;s++)
               deck.add(new Card(r,s));
      } else
         deck = new ArrayList<Card>();
   }
   
   public Card deal() {
   
      Card returnCard = deck.get(deck.size()-1);
      deck.remove(deck.size()-1);
      return returnCard;
   }
   
   public Deck deal(int numCards) {
   
      Deck temp = new Deck();
      
      for (int i=0; i<numCards; i++)
         temp.addCard(deal());
      
      return temp;
   }
   
   public void addCard(Card c) {
   
      deck.add(c);
   }
   
   public int cardsRemaining() {
   
      return deck.size();
   }
   
   public void shuffle() {
   
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }
   }
   
   public boolean isEmpty() {
   
      return (cardsRemaining() == 0);
   }
}
