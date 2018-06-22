package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the getTotal method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerIsGetTotal {

	/**
	 * Test to confirm that getTotal returns a positive number after one roll, given
	 * that no 1s are rolled
	 * 
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#getTotal()}.
	 */
	@Test
	void testGetTotalAfterOneTurnShouldReturnPositiveNumberIfNo1sWereRolled() {
		ComputerPlayer newComputer = new ComputerPlayer(new CautiousStrategy());
		newComputer.setMaximumRolls();
		newComputer.setIsMyTurn(true);
		do {
			newComputer.takeTurn();
		} while (newComputer.getTotal() == 0);
		assertEquals(true, newComputer.getTotal() > 0);
	}

}
