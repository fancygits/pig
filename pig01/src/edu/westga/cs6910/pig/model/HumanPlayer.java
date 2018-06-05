package edu.westga.cs6910.pig.model;

/**
 * HumanPlayer represents a human player in the game Pig.
 * 
 * @author	James Luke Johnson
 * @version	2016.06.04
 */
public class HumanPlayer extends AbstractPlayer {
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param name	this Player's name
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name) {
		super(name);
	}
}
