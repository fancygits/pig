package edu.westga.cs6910.pig.testing.randomstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.stategies.RandomStrategy;

/**
 * Tests the constructor and rollAgain method of RandomStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.06.16
 */
class TestWhenRandomStrategyIsRollAgain {

	/**
	 * Test to confirm that rollAgain 10000 times returns true about 50 percent of the time
	 * Test method for {@link edu.westga.cs6910.pig.model.stategies.RandomStrategy#rollAgain(int, int, int)}.
	 */
	@Test
	void testRollAgain10000TimesShouldReturnTrueAbout50Percent() {
		RandomStrategy randomStrategy = new RandomStrategy();
		int trueCount = 0;
		for (int count = 0; count < 10000; count++) {
			if (randomStrategy.rollAgain(0, 0, 10)) {
				trueCount++;
			}
		}
		assertEquals(true, trueCount > 4500 && trueCount < 5500);
	}
	
	/**
	 * Test to confirm that rollAgain will return false when distanceToGoal is < 0
	 */
	@Test
	void testRollAgainForRandomStrategyWhenDistanceToGoalIsLessThan0ShouldReturnFalse() {
		RandomStrategy random1 = new RandomStrategy();
		assertEquals(false, random1.rollAgain(0, 0, -10));
	}
	
	/**
	 * Test to confirm that rollAgain will return false when distanceToGoal is < 0
	 */
	@Test
	void testRollAgainForRandomStrategyWhenDistanceToGoalIs0ShouldReturnFalse() {
		RandomStrategy random2 = new RandomStrategy();
		assertEquals(false, random2.rollAgain(0, 0, 0));
	}

}
