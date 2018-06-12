package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the getTotal method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerIsGetTotal {

	/**
	 * Test to confirm that getTotal returns a positive number after one roll, given
	 * that no 1s are rolled
	 * 
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#getTotal()}.
	 */
	@Test
	void testGetTotalAfterOneTurnShouldReturnPositiveNumberIfNo1sWereRolled() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		do {
			newHuman.resetTurnTotal();
			newHuman.takeTurn();
		} while (newHuman.getTurnTotal() == 0);
		assertEquals(true, newHuman.getTotal() > 0);
	}

}
