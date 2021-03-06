package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.stategies.PigStrategy;

// DONE: Classes ComputerPlayer and HumanPlayer share most of their code.
//		 Refactor their code:
// 		 1. Create abstract base class AbstractPlayer to implement the
//			shared code and define abstract methods for methods without
//			duplicate code. AbstractPlayer should implement interface Player.
//		 2. Have ComputerPlayer and HumanPlayer extend AbstractPlayer to
//		    implement the unshared constructor code and the abstract methods.

/**
 * ComputerPlayer represents a very simple automated player in the game Pig.
 * It rolls exactly 1 time and then holds.
 * 
 * @author	James Luke Johnson
 * @version	2016.06.04
 */
public class ComputerPlayer extends AbstractPlayer {
	
	private static final String NAME = "Simple computer";
	@SuppressWarnings("unused")
	private int maximumRolls;
	private PigStrategy strategy;
	private boolean autoRoll;
	private int goalScore;
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * @param strategy	The PigStrategy the player will follow
	 * 
	 * Precondition:	strategy != null
	 */
	public ComputerPlayer(PigStrategy strategy) {
		super(NAME);
		if (strategy == null) {
			throw new IllegalArgumentException("PigStrategy cannot be null");
		}
		this.goalScore = 100;
		this.strategy = strategy;
		this.autoRoll = false;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {
		this.resetTurnTotal();
		int turnCount = 0;
		do {
			if (this.getIsMyTurn()) {
				super.takeTurn();
				//System.out.println("Turn Count: " + turnCount + "\tRolled: " + this.getDiceValues() + "\tTurnTotal: " + this.getTurnTotal());
			}
			turnCount++;
		} while (this.strategy.rollAgain(turnCount, this.getTurnTotal(), this.goalScore - this.getTotal()));
		this.setIsMyTurn(false);
	}
	
	//*************************** mutator methods ****************************
	
	/**
	 * Implements Player's setMaximumRolls, but is not normally
	 * called by client objects.  Instead, clients usually
	 * call the 0-parameter version
	 * 
	 * @param	maximumRolls	The maximum number of times the computer
	 * 							will roll before holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the 
	 * maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}
	
	/**
	 * Sets the strategy for the computer player
	 * @param strategy	PigStrategy object
	 * 
	 * Precondition:	strategy != null
	 * Postcondition: 	the specified strategy will determine how the player will play
	 */
	public void setStrategy(PigStrategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Sets the computer player to autoRoll, taking its turn automatically
	 * without user input	
	 * @param autoRoll	boolean True if autoRoll should be on
	 */
	public void setAutoRoll(boolean autoRoll) {
		this.autoRoll = autoRoll;
	}
	
	/**
	 * Sets the goalScore, for use in rollAgain
	 * @param goalScore		int goalScore of the Game
	 */
	public void setGoalScore(int goalScore) {
		if (goalScore > 0) {
			this.goalScore = goalScore;
		}
	}
	
	//*************************** accessor methods ****************************
	/**
	 * Accessor method for autoRoll functionality
	 * @return	boolean autoRoll
	 */
	public boolean getAutoRoll() {
		return this.autoRoll;
	}
}
