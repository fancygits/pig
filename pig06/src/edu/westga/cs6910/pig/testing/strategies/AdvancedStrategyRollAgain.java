package edu.westga.cs6910.pig.testing.strategies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.AdvancedStrategy;

/**
 * Behavior-Driven Development Tests of AdvancedStrategy.rollAgain()
 * 
 * @author James Luke Johnson
 * @version 2018.07.05
 */
class AdvancedStrategyRollAgain {
	private AdvancedStrategy strategy;
	
	@BeforeEach
	void setUp() throws Exception {
		this.strategy = new AdvancedStrategy();
	}
	
	/**
	 * Test method for {@link edu.westga.cs6910.pig.model.strategies.AdvancedStrategy#rollAgain(int, int, int, int)}.
	 */
	@Test
	void testShouldReturnTrueAtStartOfGame() {
		boolean result = this.strategy.rollAgain(0, 0, 100, 100);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnTrueAtStartOfGameAfterHumanPlayerHasGoneWithNoPoints() {
		boolean result = this.strategy.rollAgain(0, 0, 100, 100);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnTrueAtStartOfGameAfterHumanPlayerHasGoneWithSomePoints() {
		boolean result = this.strategy.rollAgain(0, 0, 100, 93);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnFalseAtEndOfGameAfterComputerPlayerHasExactly100Points() {
		boolean result = this.strategy.rollAgain(1, 7, 0, 100);
		assertEquals(false, result);
	}
	
	@Test
	void testShouldReturnFalseAtEndOfGameAfterComputerPlayerHasMoreThan100Points() {
		boolean result = this.strategy.rollAgain(1, 7, -4, 100);
		assertEquals(false, result);
	}
	
	@Test
	void testShouldReturnFalseAfterHumanPlayerHasWonTheGameWithExactly100Points() {
		boolean result = this.strategy.rollAgain(0, 0, 50, 0);
		assertEquals(false, result);
	}
	
	@Test
	void testShouldReturnFalseAfterHumanPlayerHasWonTheGameWithMoreThan100Points() {
		boolean result = this.strategy.rollAgain(0, 0, 50, -6);
		assertEquals(false, result);
	}
	
	@Test
	void testShouldReturnTrueWhenOtherPlayerHasAlmostWonTheGameWithExactly7PointsNeeded() {
		boolean result = this.strategy.rollAgain(1, 7, 50, 7);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnTrueWhenOtherPlayerHasAlmostWonTheGameWithLessThan7PointsNeeded() {
		boolean result = this.strategy.rollAgain(1, 7, 50, 5);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnFalseWhenMyExpectedNumberOfRollsLeftIsLessThanOpponent() {
		boolean result = this.strategy.rollAgain(1, 7, 50, 70);
		assertEquals(false, result);
	}
	
	@Test
	void testShouldReturnTrueWhenMyExpectedNumberOfRollsLeftIsGreaterThanOpponent() {
		boolean result = this.strategy.rollAgain(1, 7, 70, 50);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnTrueWhenExpectedRollsAreEqualAndMyAverageRollIsLessThan7() {
		boolean result = this.strategy.rollAgain(3, 10, 50, 50);
		assertEquals(true, result);
	}
	
	@Test
	void testShouldReturnFalseWhenExpectedRollsAreEqualAndMyAverageRollIsMoreThan7() {
		boolean result = this.strategy.rollAgain(3, 25, 50, 50);
		assertEquals(false, result);
	}

	@Test
	void testShouldReturnFalseWhenExpectedRollsAreEqualAndMyAverageRollIsEqual7() {
		boolean result = this.strategy.rollAgain(3, 21, 50, 50);
		assertEquals(false, result);
	}
}
