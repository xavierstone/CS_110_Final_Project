public class WarCardGame {

   private Deck startDeck;
   private Player person, computer;
   private Card personKnight, computerKnight;
   private Deck prisoners;
   
   public WarCardGame() {
   
      startDeck = new Deck(Deck.STANDARD);
      prisoners = new Deck();
      person = new Player("Bob");
      computer = new Player("Computer");
      
      startDeck.shuffle();
      person.addToPile(startDeck.deal(26));
      computer.addToPile(startDeck.deal(26));
   }
   
   public boolean move() {
      
      boolean gameContinue = true;
      boolean isWar = true;
      
      try {
      
         do {
         
            personKnight = person.draw();
            computerKnight = computer.draw();
            
            if (personKnight.compareTo(computerKnight)>0) {
               person.addToDiscard(personKnight);
               person.addToDiscard(computerKnight);
               person.addToDiscard(prisoners);
               isWar=false;
            } else if (personKnight.compareTo(computerKnight)<0) {
               computer.addToDiscard(personKnight);
               computer.addToDiscard(computerKnight);
               computer.addToDiscard(prisoners);
               isWar=false;
            } else {
               prisoners.addCard(personKnight);
               prisoners.addCard(computerKnight);
               prisoners.addCard(person.draw());
               prisoners.addCard(computer.draw());
            }
         } while (isWar==true);
      } catch (ArrayIndexOutOfBoundsException e) {
         gameContinue=false;
      }
      
      return gameContinue;
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
   
   public String getWinner() {
   
      if (person.getForfeit()) return computer.getName();
      if (computer.getForfeit()) return person.getName();
      return "";
   }
}