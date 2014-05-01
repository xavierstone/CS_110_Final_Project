/**
   Represents a playing card from a Spanish Deck (the familiar 52-card one)
*/

public class Card {
   
   public static final int DIAMONDS=1, CLUBS=2, HEARTS=3, SPADES=4; // Suits
   public static final int ACE=1, JACK=11, QUEEN=12, KING=13; // Face Cards
   private int rank, suit; // Rank and suit
   
   /**
      Basic constructor taking rank and suit
      @param rank The number on the card, or Ace, Jack, Queen, King
      @param suit Diamonds, Clubs, Hearts, or Spades
   */
   
   public Card ( int rank , int suit ) {
   
      this.rank = rank;
      this.suit = suit;
   }
   
   /**
      getRank returns the rank of the card
      @return Rank
   */
   
   public int getRank () {
   
      return rank;
   }
   
   /**
      getSuit returns the suit of the card
      @return Suit
   */
   
   public int getSuit () {
   
      return suit;
   }
   
   /**
      toString returns a string representation of the card, e.g. Ace of Spades
      @return String representation
   */
   
   public String toString () {
      
      String rankText, suitText;
      
      if (rank==Card.ACE) {
         rankText = "ace";
      } else if (rank == Card.JACK ) {
         rankText = "jack";
      } else if (rank == Card.QUEEN ) {
         rankText = "queen";
      } else if (rank == Card.KING ) {
         rankText = "king";
      } else {
         rankText = ""+rank;
      }
      
      switch (suit) {
         case Card.CLUBS:
            suitText = "c";
            break;
         case Card.DIAMONDS:
            suitText = "d";
            break;
         case Card.SPADES:
            suitText = "s";
            break;
         case Card.HEARTS:
            suitText = "h";
            break;
         default:
            suitText = "";
            break;
      }
   
      return rankText+""+suitText;
   }
   
   /**
      equals compares the rank of two cards to determine equality
      @return True if equal, false otherwise
   */
   
   public int compareTo(Card compare) {
   
      if ( this.rank == compare.rank )
         return 0;
      else if (this.rank < compare.rank)
         return -1;
      else
         return 1;
   }
}