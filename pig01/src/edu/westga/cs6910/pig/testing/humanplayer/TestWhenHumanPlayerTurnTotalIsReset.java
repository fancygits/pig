package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the resetTurnTotal method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerTurnTotalIsReset {

	/**
	 * Test to confirm that a new HumanPlayer with a resetTurnTotal
	 * should return 0
	 */
	@Test
	void testResetTurnTotalShouldReturnTurnTotalOf0() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		newHuman.resetTurnTotal();
		assertEquals(0, newHuman.getTurnTotal());
	}

}
