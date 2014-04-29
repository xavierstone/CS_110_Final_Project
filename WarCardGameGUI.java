import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarCardGameGUI extends JFrame implements ActionListener {

   private WarCardGame game = new WarCardGame();
   private JPanel topPanel, gamePanel, playPanel;
   private JLabel title, personStatus, computerStatus;
   private JLabel personKnight, computerKnight;
   private JButton drawButton;
   
   public WarCardGameGUI() {
   
      super("War");
      
      setBounds(100,100,800,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new GridLayout(3,1));
      
      topPanel = new JPanel();
      gamePanel = new JPanel(new GridLayout(3,2));
      playPanel = new JPanel();
      
      add(topPanel);
      add(gamePanel);
      add(playPanel);
      
      title = new JLabel("The Game of War");
      topPanel.add(title);
      
      personStatus = new JLabel(game.getPersonStatus());
      gamePanel.add(personStatus);
      
      computerStatus = new JLabel(game.getComputerStatus());
      gamePanel.add(computerStatus);
      
      personKnight = new JLabel();
      gamePanel.add(personKnight);
      
      computerKnight = new JLabel();
      gamePanel.add(computerKnight);
      
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
      
         if (game.move()==false)
            title.setText("Winner is "+game.getWinner());
         
         personStatus.setText(game.getPersonStatus());
         computerStatus.setText(game.getComputerStatus());
         personKnight.setText(game.getPersonKnight());
         computerKnight.setText(game.getComputerKnight());
      }
   }
}