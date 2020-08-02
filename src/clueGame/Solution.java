package clueGame;

/**
 * 
 * @author Yash Sinha, Daniel Thorne, Calvin Mak
 * This class holds the solution cards for the Clue game
 * 
 */

public class Solution {
	
	public Card person;
	public Card room;
	public Card weapon;
	
	/**
	 * 
	 * @param person
	 * @param room
	 * @param weapon
	 * Default constructor for setting the Solution cards
	 */
	public Solution(Card person, Card room, Card weapon) {
		this.person = person;
		this.room = room;
		this.weapon = weapon;
	}


	public Card getPerson() {
		return person;
	}

	public Card getRoom() {
		return room;
	}

	public Card getWeapon() {
		return weapon;
	}
	
	
}