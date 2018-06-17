package edu.westga.cs6910.pig.model.stategies;

/**
 * Defines the Cautious Strategy for the ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.15
 */
public class CautiousStrategy implements PigStrategy {

	
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.stategies.PigStrategy#rollAgain(int, int, int)
	 */
	/** 
	 * Always returns false since that is the cautious way to play
	 */
	@Override
	public boolean rollAgain(int currentNumberOfRolls, int currentTurnTotal, int distanceToGoal) {
		return false;
	}

}
