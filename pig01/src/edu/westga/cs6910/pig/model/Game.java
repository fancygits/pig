package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * @author	CS6910
 * @version	Summer 2018
 */
public class Game implements Observable {

	/**
	 * The goal score for the game
	 */
	public static final int GOAL_SCORE = 100;

	private ObjectProperty<Player> currentPlayerObject;	

	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;
	private Player firstPlayer;

	private DicePair thePair;
	
	private int goalScore;

	/**
	 * Creates a Pig Game with the specified Players and
	 * a pair of dice.
	 * 
	 * @param theComputer	the automated player
	 * @param theHuman		the human player
	 * 
	 * @require				theHuman != null && theComputer != null
	 * 
	 * @ensure				humanPlayer().equals(theHuman) &&
	 *         				computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		this.theHuman = theHuman;
		this.theComputer = theComputer;
		
		this.currentPlayerObject = new SimpleObjectProperty<Player>();
		this.goalScore = GOAL_SCORE;
		this.thePair = new DicePair();
	}

	
	// *********************** mutator methods *************************

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer 	the Player who takes the first turn
	 * 
	 * @require 			firstPlayer != null && 
	 * 						!firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures 			whoseTurn().equals(firstPlayer) &&
	 * 						firstPlayer.getTotal() == 0
	 */
	public void startNewGame(Player firstPlayer) {
		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(firstPlayer);
		firstPlayer.setIsMyTurn(true);
		this.firstPlayer = firstPlayer;
		this.theComputer.resetGame();
		this.theHuman.resetGame();
		this.thePair = new DicePair();
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to
	 * take a turn. Has no effect if the game is over.
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		this.currentPlayerObject.getValue().takeTurn();

		// Force the user interface to update by changing the currentPlayerObject
		//	to null and back
		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);
		
		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {		
			this.hold();
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}
	
	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void hold() {
		// DONE: Swap whose turn it is.
		if (!this.isGameOver()) {
			this.swapWhoseTurn();
		}
	}
	
	/**
	 * Sets the goalScore to the given int
	 * @param goalScore	int new Goal Score
	 * 
	 * Precondition:	goalScore > 0
	 */
	public void setGoalScore(int goalScore) {
		if (goalScore > 0) {
			this.goalScore = goalScore;
			this.theComputer.setGoalScore(goalScore);
		}
	}

	// *********************** accessor methods *************************
	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return	the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}
	
	/**
	 * Returns the player chosen to go first
	 * @return	the first player of the game
	 */
	public Player getFirstPlayer() {
		return this.firstPlayer;
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= GOAL_SCORE
	 */
	public boolean isGameOver() {	
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}
		
		if (this.currentPlayerObject.getValue().getTotal() >= this.goalScore) {
			return true;
		}
		return false;
	}
	
	/** 
	 * Returns the pair of dice being used in the game
	 * 
	 * @return	the pair of dice
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}
	
	/**
	 * Returns the Goal Score
	 * @return	int goalScore
	 */
	public int getGoalScore() {
		return this.goalScore;
	}

	/**
	 * Returns a String showing the goal score, or, if
	 * the game is over, the name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {	
		String result = "Goal Score: " + this.goalScore;
		result += System.getProperty("line.separator")
				+ this.theHuman.getName() + ": "
				+ this.theHuman.getTotal();
		result += System.getProperty("line.separator")
				+ this.theComputer.getName() + ": "
						+ this.theComputer.getTotal();
		
		//if (!this.isGameOver()) {
		//	return result;
		//}
		
		if (this.theHuman.getTotal() >= this.goalScore) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= this.goalScore) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}

	
	
	// ************************ private helper method *************************

	private void swapWhoseTurn() {
		// DONE: Swap the players so that the other player becomes 
		//       the current player.  Note that in order to access the
		//		 object inside of the ObjectProperty, you'll need to use
		//		 getValue() and setValue()
		if (this.currentPlayerObject.getValue() == this.theHuman) {
			this.currentPlayerObject.setValue(this.theComputer);
			this.theComputer.setIsMyTurn(true);
		} else {
			this.currentPlayerObject.setValue(this.theHuman);
			this.theHuman.setIsMyTurn(true);
		}
	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}
	
}
