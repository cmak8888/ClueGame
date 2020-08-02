package clueGame;

import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * 
 * @author Yash Sinha, Daniel Thorne, Calvin Mak
 * This class creates the main window for clue where the board, players, controls, etc will be shown. It has a tab called "File" that allows
 * the user to exit the game or to bring up the detective notes. It uses a static board variable to help draw the board. JMenuBar helps create
 * the "File" tab. The detectiveNotes variable helps create the detective notes dialog window. 
 * 
 */
public class ClueGame extends JFrame{
	
	private static Board board;
	private JMenuBar menuBar;
	private DetectiveNotes detectiveNotes;
	
	/**
	 * This is the constructor that helps combine all the panels and helps set size of the main window. It also contains the main method
	 * to run the entire java project. 
	 */
	public ClueGame() {
		setSize(new Dimension(1200, 880));
		setTitle("Clue Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControlPanel controlPanel = new ControlPanel();
		add(controlPanel, BorderLayout.SOUTH);

		JMenuBar menuBar = new JMenuBar();

		board = Board.getInstance();
		board.setConfigFiles("ClueBoard.csv", "ClueRooms.txt", "peopleConfig.txt", "weaponConfig.txt");
		board.initialize();
		add(board, BorderLayout.CENTER);
		
        PlayerCardDisplay playerCardDisplay = new PlayerCardDisplay();
        add(playerCardDisplay, BorderLayout.EAST);
        
		JMenuItem closeItem;
		JMenuItem notesItem;
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		notesItem = fileMenu.add("Notes");
		closeItem = fileMenu.add("Exit");
	    menuBar.add(fileMenu);
	    notesItem.addActionListener(new ButtonListener());
	    closeItem.addActionListener(new ExitListener());	    
	    
	}
	
	/**
	 * 
	 * @author Yash Sinha, Daniel Thorne, Calvin Mak
	 * This class helps bring up the detective notes dialog window when the option "Notes" is clicked under the "Files" tab.
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * This function helps bring up the detective notes dialog window when the option "Notes" is clicked under the "Files" tab. 
		 */
		public void actionPerformed(ActionEvent e) {
			detectiveNotes = new DetectiveNotes();
			detectiveNotes.setVisible(true);
		}
	}
	
	/**
	 * 
	 * @author Yash Sinha, Daniel Thorne, Calvin Mak
	 * This class helps exit out of the game when the option "Exit" is clicked under the "Files" tab.
	 *
	 */
	private class ExitListener implements ActionListener{
        /**
         * This function  helps exit out of the game when the option "Exit" is clicked under the "Files" tab.
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClueGame clueGame = new ClueGame();
		JOptionPane.showMessageDialog(clueGame, "You are " + board.getHumanPlayer().getPlayerName() + ", press Next Player to begin play.", "Welcome to Clue", JOptionPane.INFORMATION_MESSAGE);
		clueGame.setVisible(true);
		
            
	}
}
