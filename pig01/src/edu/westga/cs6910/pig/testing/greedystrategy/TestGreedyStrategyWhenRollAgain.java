package edu.westga.cs6910.pig.testing.greedystrategy;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.stategies.GreedyStrategy;

/**
 * Tests the constructor and rollAgain method of GreedyStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.06.16
 */
class TestGreedyStrategyWhenRollAgain {

	/**
	 * Test to confirm that GreedyStrategy always returns true of currentNumberOfRolls < 3
	 * Test method for {@link edu.westga.cs6910.pig.model.stategies.GreedyStrategy#rollAgain(int, int, int)}.
	 */
	@Test
	void testRollAgain10000TimesForCurrentNumberOfRollsLessThan3ShouldAlwaysReturnTrue() {
		GreedyStrategy greedy = new GreedyStrategy();
		for (int count = 0; count < 10000; count++) {
			if (!greedy.rollAgain((int) (Math.random() * 3), 0, 0)) {
				fail("GreedyStrategy returned false under 3 rolls");
			}
		}
	}
	
	/**
	 * Test to confirm that GreedyStrategy always returns false of currentNumberOfRolls > 3
	 * Test method for {@link edu.westga.cs6910.pig.model.stategies.GreedyStrategy#rollAgain(int, int, int)}.
	 */
	@Test
	void testRollAgain10000TimesForCurrentNumberOfRollsGreaterThan3ShouldAlwaysReturnFalse() {
		GreedyStrategy greedy = new GreedyStrategy();
		for (int count = 0; count < 10000; count++) {
			if (greedy.rollAgain((int) (Math.random() * 100) + 3, 0, 0)) {
				fail("GreedyStrategy returned false under 3 rolls");
			}
		}
	}

}
