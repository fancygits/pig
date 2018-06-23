package edu.westga.cs6910.pig.model;

/**
 * Player defines the interface for players in the game Pig.
 * 
 * @author James Luke Johnson
 * @author	CS6910
 * @version	Summer 2018
 * @version 2018.06.17
 */
public interface Player {

	//*************************** mutator methods ****************************
	/**
	 * Rolls the die 1 or more times.
	 * 
	 */
	void takeTurn();
	
	/**
	 * Resets the turn total to 0
	 * 
	 */
	void resetTurnTotal();
	
	/**
	 * Resets the turn total and game total to 0
	 */
	void resetGame();

	/**
	 * Modifier for isMyTurn
	 * @param isMyTurn	boolean. True if isMyTurn
	 */
	void setIsMyTurn(boolean isMyTurn);
	
	//*************************** accessor methods ****************************
	/**
	 * Returns whether or not it is this player's turn
	 * @return	True if and only if it is this player's turn
	 */
	boolean getIsMyTurn();
	
	/**
	 * Returns this Player's name.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Returns the total of all die rolls for this turn
	 * @return	The total of all die rolls for this turn
	 */
	int getTurnTotal();
	
	/**
	 * Returns the total number of pips rolled by this player during the game
	 * 
	 * @return	The player's total score
	 */
	int getTotal();
	
	/**
	 * Returns the number of pips showing on the die that were just rolled
	 * @return	The number of pips showing on the die that were just rolled
	 */
	String getDiceValues();
}
