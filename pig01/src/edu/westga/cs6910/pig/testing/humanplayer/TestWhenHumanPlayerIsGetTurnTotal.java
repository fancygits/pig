package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the getTurnTotal method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerIsGetTurnTotal {

	/**
	 * Test to confirm that a new HumanPlayer should getTurnTotal of 0
	 */
	@Test
	void testGetTurnTotalOfNewPlayerShouldReturnTurnTotalOf0() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		assertEquals(0, newHuman.getTurnTotal());
	}
}
