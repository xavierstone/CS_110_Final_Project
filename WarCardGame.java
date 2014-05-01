public class WarCardGame {

   private Deck startDeck;
   private Player person, computer;
   private Card personKnight, computerKnight;
   private Deck prisoners;
   
   public final int LEFT=0, WAR=1, END=2, RIGHT=3;
   
   public WarCardGame() {
   
      startDeck = new Deck(Deck.STANDARD);
      prisoners = new Deck();
      person = new Player("Bob");
      computer = new Player("Computer");
      
      startDeck.shuffle();
      person.addToPile(startDeck.deal(26));
      computer.addToPile(startDeck.deal(26));
   }
   
   public int move() {
   
      try {
      
         personKnight = person.draw();
         computerKnight = computer.draw();
         
         if (personKnight.compareTo(computerKnight)>0) {
            person.addToDiscard(personKnight);
            person.addToDiscard(computerKnight);
            person.addToDiscard(prisoners);
            return LEFT;
         } else if (personKnight.compareTo(computerKnight)<0) {
            computer.addToDiscard(personKnight);
            computer.addToDiscard(computerKnight);
            computer.addToDiscard(prisoners);
            return RIGHT;
         } else {
            prisoners.addCard(personKnight);
            prisoners.addCard(computerKnight);
            prisoners.addCard(person.draw());
            prisoners.addCard(computer.draw());
            return WAR;
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         return END;
      }
   }
   
   public String getPersonStatus() {
   
      return person.getName()+": "+person.pileSize()
            +" ("+person.discardSize()+")";
   }
   
   public String getComputerStatus() {
   
      return computer.getName()+": "+computer.pileSize()
            +" ("+computer.discardSize()+")";
   }
   
   public String getPersonKnight() {
   
      return personKnight.toString();
   }
   
   public String getComputerKnight() {
   
      return computerKnight.toString();
   }
   
   public int getStake() {
   
      return prisoners.cardsRemaining();
   }
   
   public String getWinner() {
   
      if (person.getForfeit()) return computer.getName();
      if (computer.getForfeit()) return person.getName();
      return "";
   }
}