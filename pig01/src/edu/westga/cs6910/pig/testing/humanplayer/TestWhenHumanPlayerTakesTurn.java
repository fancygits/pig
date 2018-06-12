package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the takeTurn method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerTakesTurn {

	/**
	 * Test to confirm that takeTurn sometimes increases the total
	 * To test this, I will run takeTurn 10000 times and fail if turnTotal NEVER goes over 0
	 * 
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#takeTurn()}.
	 */
	@Test
	void testTakeTurn10000TimesShouldHaveTurnTotalGoingAbove0MoreThanOnce() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		int aboveZeroTotalCount = 0;
		for (int count = 0; count < 10000; count++) {
			newHuman.takeTurn();
			if (newHuman.getTurnTotal() > 0) {
				aboveZeroTotalCount++;
			}
			newHuman.resetTurnTotal();
		}
		assertEquals(true, aboveZeroTotalCount > 0);
	}

}
