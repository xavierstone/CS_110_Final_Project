public class WarCardGame {

   private static Deck startDeck;
   private static Player person, computer;
   private static Card personKnight, computerKnight;
   private static Deck prisoners;
   
   public static void main ( String [] args ) {
   
      startDeck = new Deck(Deck.STANDARD);
      prisoners = new Deck();
      person = new Player("Xavier");
      computer = new Player("Computer");
      
      startDeck.shuffle();
      person.addToPile(startDeck.deal(26));
      computer.addToPile(startDeck.deal(26));
      
      boolean gameContinue = true;
      boolean isWar = true;
      
      while (gameContinue == true) {
         
         try {
            System.out.println(person.getName()+": "+person.pileSize()
                              +" ("+person.discardSize()+")");
            System.out.println(computer.getName()+": "+computer.pileSize()
                              +" ("+computer.discardSize()+")");
            
            isWar = true;
            
            do {
            
               personKnight = person.draw();
               computerKnight = computer.draw();
               
               System.out.println(personKnight+" vs "+computerKnight);
               
               if (personKnight.compareTo(computerKnight)>0) {
                  person.addToDiscard(personKnight);
                  person.addToDiscard(computerKnight);
                  person.addToDiscard(prisoners);
                  System.out.println(person.getName()+" takes all");
                  isWar=false;
               } else if (personKnight.compareTo(computerKnight)<0) {
                  computer.addToDiscard(personKnight);
                  computer.addToDiscard(computerKnight);
                  computer.addToDiscard(prisoners);
                  System.out.println(computer.getName()+" takes all");
                  isWar=false;
               } else {
                  System.out.println("WAR!!!");
                  prisoners.addCard(personKnight);
                  prisoners.addCard(computerKnight);
                  prisoners.addCard(person.draw());
                  prisoners.addCard(computer.draw());
               }
            } while (isWar==true);
         } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Game Over!");
            if (person.getForfeit()) playerWins(computer);
            if (computer.getForfeit()) playerWins(person);
            gameContinue=false;
         }
      }
   }
   
   private static void playerWins(Player p) {
   
      System.out.println(p.getName()+" Wins!");
   }
}