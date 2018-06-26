package edu.westga.cs6910.pig.model.stategies;

/**
 * Defines the GreedyStrategy which tries to rollAgain 3 times
 * 
 * @author James Luke Johnson
 * @version 2018.06.16
 */
public class GreedyStrategy implements PigStrategy {

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.stategies.PigStrategy#rollAgain(int, int, int)
	 */
	/** 
	 * Will attempt to roll again at most 3 times unless it already won
	 * 
	 * Precondition:	distanceToGoal > 0
	 */
	@Override
	public boolean rollAgain(int currentNumberOfRolls, int currentTurnTotal, int distanceToGoal) {
		if (distanceToGoal > 0) {
			return currentNumberOfRolls < 3;
		}
		return false;
	}

}
