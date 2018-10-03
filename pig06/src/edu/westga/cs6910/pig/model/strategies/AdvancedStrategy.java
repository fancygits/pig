package edu.westga.cs6910.pig.model.strategies;

/**
 * Defines the AdvancedStrategy class and behavior
 * 
 * @author James Luke Johnson
 * @version 2018.07.05
 */
public class AdvancedStrategy implements PigStrategy {

	/**
	 * Determines whether the computer should roll again
	 * 
	 * @param numberOfRollsSoFar	Number of rolls the player has taken this turn
	 * @param pointsSoFarThisTurn	Number of points gained so far this turn
	 * @param pointsToGoal			Number of points from the goal
	 * @param opponentPointsToGoal	Number of points the opponent is from the goal
	 * @return						True if the player should roll again, false otherwise
	 * @see edu.westga.cs6910.pig.model.strategies.PigStrategy#rollAgain(int, int, int, int)
	 */
	public boolean rollAgain(int numberOfRollsSoFar, int pointsSoFarThisTurn, int pointsToGoal, int opponentPointsToGoal) {
		int myAverageRolls = this.getAverageRollsRemaining(pointsToGoal);
		int theirAverageRolls = this.getAverageRollsRemaining(opponentPointsToGoal);
		double myAverageRollThisTurn = this.getAverageRollThisTurn(numberOfRollsSoFar, pointsSoFarThisTurn);
		boolean notGameOver				= pointsToGoal > 0 && opponentPointsToGoal > 0;
		boolean theyAlmostWin			= opponentPointsToGoal <= 7;
		boolean moreRollsRemaining		= myAverageRolls > theirAverageRolls;
		boolean equalRollsButLowAverage	= myAverageRolls == theirAverageRolls && myAverageRollThisTurn < 7;
		
		return notGameOver && (theyAlmostWin || moreRollsRemaining || equalRollsButLowAverage);
	}
	
	private int getAverageRollsRemaining(int pointsToGoal) {
		int averageRolls = (int) Math.ceil(pointsToGoal / 7.0);
		return averageRolls;
	}
	
	private double getAverageRollThisTurn(int numberOfRollsSoFar, int pointsSoFarThisTurn) {
		if (numberOfRollsSoFar < 1 || pointsSoFarThisTurn < 1) {
			return 0;
		}
		return pointsSoFarThisTurn / numberOfRollsSoFar * 1.0;
	}
}
