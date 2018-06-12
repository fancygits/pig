package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests the getTurnTotal method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerIsGetTurnTotal {

	/**
	 * Test to confirm that a new ComputerPlayer should getTurnTotal of 0
	 */
	@Test
	void testGetTurnTotalOfNewPlayerShouldReturnTurnTotalOf0() {
		ComputerPlayer newComputer = new ComputerPlayer();
		assertEquals(0, newComputer.getTurnTotal());
	}
}
