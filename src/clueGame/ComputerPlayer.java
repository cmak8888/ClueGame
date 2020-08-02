package clueGame;

import java.awt.Color;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

/**
 * 
 * @author Yash Sinha, Daniel Thorne, Calvin Mak
 * This class holds the computer AI players for the Clue Game.
 * 
 */

public class ComputerPlayer extends Player {
	
	/**
	 * 
	 * @param playerName
	 * @param row
	 * @param column
	 * @param color
	 * Default constructor for a Computer Player
	 */
	char lastVisited;
	Vector<Card> roomOptions;
	public ComputerPlayer(String playerName, int row, int column, Color color) {
		super(playerName, row, column, color);
		lastVisited = 'w';
		roomOptions = new Vector<Card>();
	}
	
	

	public void setRoomOptions(Vector<Card> options) {
		this.roomOptions = options;
	}



	/**
	 * 
	 * @param targets
	 * @return
	 * 
	 * Selects a random location for the computer player to start at
	 */
	public BoardCell pickLocation(Set<BoardCell> targets) {
		for(BoardCell cell: targets) {
			if (cell.getInitial() != 'w') {
				if(cell.getInitial() != lastVisited) {
					lastVisited = cell.getInitial();
					return cell;
				}
			}
		}
		int index = new Random().nextInt(targets.size());
		int i = 0;
		for(BoardCell target : targets)
		{
			if (i == index)
				return target;
			i++;
		}
		return null;


	}
	
	/**
	 * 
	 * Player makes an accusation on the murderer and weapon
	 * 
	 */
	public void makeAccusation() {
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	public Solution createSuggestion(String room) {
		Card roomSolution = null;
		for(Card card: roomOptions) {
			if(card.getCardName() == room) {
				roomSolution = card;
			}
		}
		int index = new Random().nextInt(unSeenPeople.size());
		Card peopleSolution = unSeenPeople.get(index);
		index = new Random().nextInt(unSeenWeapons.size());
		Card weaponSolution = unSeenWeapons.get(index);
		return new Solution(peopleSolution, roomSolution, weaponSolution);
		
	}
	
	public Card disproveSuggestion(Solution suggestion) {
		Vector<Card> currentHand = this.getHand();
		Vector<Card> options = new Vector<Card>();
		for(Card currentCard: currentHand) {
			if(currentCard == suggestion.getPerson()) {
				options.add(currentCard);
			}
			else if(currentCard == suggestion.getRoom()) {
				options.add(currentCard);
			}
			else if(currentCard == suggestion.getWeapon()) {
				options.add(currentCard);
			}
		}
		if(options.size() > 0) {
			int index = new Random().nextInt(options.size());
			return options.get(index);
		}
		else {
			return null;
		}
	}

}
