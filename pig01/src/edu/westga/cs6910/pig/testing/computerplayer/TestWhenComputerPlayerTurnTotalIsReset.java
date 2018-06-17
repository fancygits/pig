package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the resetTurnTotal method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerTurnTotalIsReset {

	/**
	 * Test to confirm that a new ComputerPlayer with a resetTurnTotal
	 * should return 0
	 */
	@Test
	void testResetTurnTotalShouldReturnTurnTotalOf0() {
		ComputerPlayer newComputer = new ComputerPlayer(new CautiousStrategy());
		newComputer.resetTurnTotal();
		assertEquals(0, newComputer.getTurnTotal());
	}

}
