package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

/**
 * 
 * @author Yash Sinha, Daniel Thorne, Calvin Mak
 * This is the player superclass generating the overall framework for players.
 * 
 * 
 */

public class Player {
	
	private String playerName;
	private int row;
	private int column;
	private Color color;
	private Vector<Card> hand;
	protected Vector<Card> unSeenWeapons;
	protected Vector<Card> unSeenPeople;
	protected Vector<Card> unSeenRooms;
	
	
	/**
	 * 
	 * 
	 * @param playerName
	 * @param row
	 * @param column
	 * @param color
	 * Default Constructor
	 * 
	 */
	public Player(String playerName, int row, int column, Color color) {
		super();
		this.playerName = playerName;
		this.row = row;
		this.column = column;
		this.color = color;
		this.hand = new Vector<Card>();
		unSeenWeapons = new Vector<Card>();
		unSeenPeople = new Vector<Card>();
		unSeenRooms = new Vector<Card>();
	}

	
//Getters and Setters
	
	public void setUnSeenWeapons(Vector<Card> seenWeapons) {
		this.unSeenWeapons = seenWeapons;
	}


	public void setUnSeenPeople(Vector<Card> seenPeople) {
		this.unSeenPeople = seenPeople;
	}


	public void setUnSeenRooms(Vector<Card> seenRooms) {
		this.unSeenRooms = seenRooms;
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Color getColor() {
		return color;
	}

	public void addCard(Card card) {
		hand.add(card);
	}
	
	public Vector<Card> getHand() {

		return hand;
	}
	
//Disprove Suggestion method
	public Card disproveSuggestion(Solution suggestion) {
		return null;
	}
	
	public void seeCard(Card card) {
		if(card.getCardType() == CardType.PERSON) {
			unSeenPeople.remove(card);
		}
		else if(card.getCardType() == CardType.ROOM) {
			unSeenRooms.remove(card);
		}
		else if(card.getCardType() == CardType.WEAPON) {
			unSeenWeapons.remove(card);
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(column*32, row*32, 32, 32);
		g.setColor(Color.black);
		g.drawOval(column*32, row*32, 32, 32);
	}

}
