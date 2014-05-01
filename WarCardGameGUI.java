import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarCardGameGUI extends JFrame implements ActionListener {

   private WarCardGame game = new WarCardGame();
   private JPanel topPanel, gamePanel, playPanel;
   private JLabel title, personStatus, computerStatus, middle;
   private JLabel personKnight, computerKnight, prisonerDeck;
   private JButton drawButton;
   
   public WarCardGameGUI() {
   
      super("War");
      
      setBounds(100,100,800,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      
      topPanel = new JPanel();
      topPanel.setBackground(Color.black);
      gamePanel = new JPanel(new GridLayout(2,5));
      gamePanel.setBackground(Color.black);
      playPanel = new JPanel();
      playPanel.setBackground(Color.black);
      
      add(topPanel,BorderLayout.NORTH);
      add(gamePanel,BorderLayout.CENTER);
      add(playPanel,BorderLayout.SOUTH);
      
      title = new JLabel("The Game of War");
      topPanel.add(title);
      
      personStatus = new JLabel(game.getPersonStatus());
      gamePanel.add(personStatus);
      
      if (game.getWinner()=="")
         gamePanel.add(new JLabel(new ImageIcon("cardPics/back.jpg")));
      
      middle = new JLabel("",JLabel.CENTER);
      gamePanel.add(middle);
      
      if (game.getWinner()=="")
         gamePanel.add(new JLabel(new ImageIcon("cardPics/back.jpg")));
      
      computerStatus = new JLabel(game.getComputerStatus());
      gamePanel.add(computerStatus);
      
      gamePanel.add(new JLabel());
            
      personKnight = new JLabel();
      gamePanel.add(personKnight);
      
      prisonerDeck = new JLabel();
      gamePanel.add(prisonerDeck);
      
      computerKnight = new JLabel();
      gamePanel.add(computerKnight);
      
      gamePanel.add(new JLabel());
      
      drawButton = new JButton("Draw");
      drawButton.addActionListener(this);
      playPanel.add(drawButton);
      
      setVisible(true); // display this frame
   }
   
   public static void main(String [] args) {
   
      new WarCardGameGUI();
   }
   
   public void actionPerformed(ActionEvent e) {
   
      Object source = e.getSource();
      if (source == drawButton) {
      
         if (game.move()==game.END) {
            middle.setText("^_^");
            title.setText("Winner is "+game.getWinner());
         } else if (game.move()==game.WAR) {
            middle.setText("<?>");
            title.setText("LADIES AND GENTLEMAN WE HAVE A WAR!");
            prisonerDeck.setIcon(new ImageIcon("cardPics/back.jpg"));
         } else if (game.move()==game.LEFT) {
            middle.setText("<==");
            title.setText("The Game of War");
            prisonerDeck.setIcon(new ImageIcon());
         } else {
            middle.setText("==>");
            title.setText("The Game of War");
            prisonerDeck.setIcon(new ImageIcon());
         }
         
         personStatus.setText(game.getPersonStatus());
         computerStatus.setText(game.getComputerStatus());
         personKnight.setIcon(new ImageIcon("cardPics/"+game.getPersonKnight().toString()+".jpg"));
         computerKnight.setIcon(new ImageIcon("cardPics/"+game.getComputerKnight().toString()+".jpg"));
      }
   }
}