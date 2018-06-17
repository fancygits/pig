package edu.westga.cs6910.pig.model.stategies;

/**
 * Defines the RandomStrategy which randomly decides to roll again
 * 
 * @author James Luke Johnson
 * @version 2018.06.16
 */
public class RandomStrategy implements PigStrategy {

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.stategies.PigStrategy#rollAgain(int, int, int)
	 */
	/** 
	 * Randomly chooses to roll again or not
	 */
	@Override
	public boolean rollAgain(int currentNumberOfRolls, int currentTurnTotal, int distanceToGoal) {
		return Math.random() > 0.5;
	}

}
