public class Player {
   
   private String name;
   private Deck pile, discard;
   private boolean forfeit = false;
   
   public Player(String name) {
      pile = new Deck();
      discard = new Deck();
      this.name = name;
   }
   
   public void addToPile(Card c) {
   
      pile.addCard(c);
   }
   
   public void addToPile(Deck d) {
   
      int size = d.cardsRemaining();
      for (int i=0; i<size; i++)
         pile.addCard(d.deal());
   }
   
   public void addToDiscard(Card c) {
   
      discard.addCard(c);
   }
   
   public void addToDiscard(Deck d) {
   
      int size = d.cardsRemaining();
      for (int i=0; i<size; i++)
         discard.addCard(d.deal());
   }
   
   public Card draw() {
   
      if (pile.isEmpty()) {
         if (discard.isEmpty())
            forfeit = true;
         else {
            addToPile(discard);
            pile.shuffle();
         }
      }
      
      return pile.deal();
   }
   
   public int pileSize() {
   
      return pile.cardsRemaining();
   }
   
   public int discardSize() {
   
      return discard.cardsRemaining();
   }
   
   public String getName() {
   
      return name;
   }
   
   public boolean getForfeit() {
   
      return forfeit;
   }
}