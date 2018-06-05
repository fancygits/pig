package edu.westga.cs6910.pig.model;

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
	private int maximumRolls;
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 */
	public ComputerPlayer() {
		super(NAME);
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {				
		for (int count = 0; count < this.maximumRolls; count++) {
			super.takeTurn();
		}
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
}
