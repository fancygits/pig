package edu.westga.cs6910.pig.model.stategies;

/**
 * Defines the strategies for the ComputerPlayer for Pig Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.15
 */
public interface PigStrategy {

	/**
	 * Determines if the ComputerPlayer should roll again
	 * 
	 * @param currentNumberOfRolls	The number of rolls already taken this turn
	 * @param currentTurnTotal		The number of points rolled so far this turn
	 * @param distanceToGoal		The difference between the total points so far and the goal
	 * @return						true if player should roll again, false otherwise
	 */
	boolean rollAgain(int currentNumberOfRolls, int currentTurnTotal, int distanceToGoal);
}
