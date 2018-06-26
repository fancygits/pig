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
	 * 
	 * Precondition:	distanceToGoal > 0
	 */
	@Override
	public boolean rollAgain(int currentNumberOfRolls, int currentTurnTotal, int distanceToGoal) {
		if (distanceToGoal > 0) {
			return Math.random() > 0.5;
		}
		return false;
	}

}
