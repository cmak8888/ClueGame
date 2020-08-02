package clueGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


/**
 * 
 * @author Yash Sinha, Daniel Thorne, Calvin Mak
 * This class creates a window with panels like making an accusation, end the turn of a player, creating a grid to show whose turn it is, 
 * a panel to show the player's guess, shows the die roll, and showing the result of the guess made by the player. 
 *
 */
public class ControlPanel extends JPanel{
    
	private JTextField control;
	
	public ControlPanel() {
		super();
		//this.setOpaque(true);
		//this.setBackground(new Color(93, 97, 104));
		setLayout(new GridLayout(2,3));
		JPanel turnPanel = createTurnPanel();
		JPanel diePanel = createDiceReadout();
		JPanel guessPanel = createSuggestionReadout();
		JPanel nextPlayerButtonPanel = createNextPlayerButton();
		JPanel makeAccusationButton = createMakeAccusationButton();
		JPanel guessResult = createGuessResult();
		turnPanel.setOpaque(true);
		turnPanel.setBackground(new Color(93, 97, 104));
		add(turnPanel, BorderLayout.WEST);
		add(nextPlayerButtonPanel, BorderLayout.CENTER);
		add(makeAccusationButton, BorderLayout.EAST);
		add(diePanel, BorderLayout.WEST);
		add(guessPanel, BorderLayout.CENTER);
		
		add(guessResult, BorderLayout.EAST);
		
		
		
		
		
	}
	
	/**
	 * This function creates a panel that shows whose turn it is.
	 * @return
	 */
	private JPanel createTurnPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		JLabel nameLabel = new JLabel("Whose turn?");
		control = new JTextField(8);
		panel.add(nameLabel);
		panel.add(control);
		return panel;
	}
	
	/**
	 * This function creates a panel that shows the number the die rolled. 
	 * @return
	 */
	private JPanel createDiceReadout() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		JLabel roll = new JLabel("Roll: ");
		JTextField display = new JTextField(4);
		panel.add(roll);
		panel.add(display);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Die"));
		return panel;
	}
	
	/**
	 * This function creates a panel that shows what the player guessed.
	 * @return
	 */
	private JPanel createSuggestionReadout() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,3));
		JLabel guess = new JLabel("Guess: ");
		JTextField display = new JTextField(30);
		panel.add(guess);
		panel.add(display);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Guess"));
		return panel;
	}
	/**
	 * This function creates a panel that shows what the result of the guess is from the player. 
	 * @return
	 */
	private JPanel createGuessResult() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,5));
		JLabel guessResult = new JLabel("Response: ");
		JTextField displayResponse = new JTextField(12);
		panel.add(guessResult);
		panel.add(displayResponse);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Guess Result"));
		return panel;
	}
	
	/**
	 * This function creates a button that ends the turn of a player. 
	 * @return
	 */
	private JPanel createNextPlayerButton() {
		JPanel panel = new JPanel();
		JButton nextPlayer = new JButton("Next Player");
		panel.add(nextPlayer);
		panel.setLayout(new GridLayout(1,1));
		return panel;
	}
	/**
	 * This function creates a button that lets the player make an accusation.
	 * @return
	 */
	private JPanel createMakeAccusationButton() {
		JPanel panel = new JPanel();
		JButton makeAccusation = new JButton("Make an Accusation");
		panel.add(makeAccusation);
		panel.setLayout(new GridLayout(1,2));
		return panel;
	}
	
	/**
	 * This is the main method that helps instantiate and show the window with the panels. 
	 * @param args
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setOpaque(true);
		Graphics2D g2D = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();
		Color ForeColor = new Color(93, 97, 104);
		Color BColor = Color.black;
		GradientPaint gP = new GradientPaint(0,0, ForeColor, 0, height, BColor);
		g2D.setPaint(gP);
		g2D.fillRect(0, 0, width, height);
	}

}
