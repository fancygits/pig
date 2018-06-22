package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the takeTurn method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerTakesTurn {

	/**
	 * Test to confirm that takeTurn sometimes increases the total
	 * To test this, I will run takeTurn 10000 times and fail if turnTotal NEVER goes over 0
	 * 
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#takeTurn()}.
	 */
	@Test
	void testTakeTurn10000TimesShouldHaveTurnTotalGoingAbove0MoreThanOnce() {
		ComputerPlayer newComputer = new ComputerPlayer(new CautiousStrategy());
		int aboveZeroTotalCount = 0;
		newComputer.setMaximumRolls();
		for (int count = 0; count < 10000; count++) {
			newComputer.setIsMyTurn(true);
			newComputer.takeTurn();
			if (newComputer.getTurnTotal() > 0) {
				aboveZeroTotalCount++;
			}
			newComputer.resetTurnTotal();
		}
		assertEquals(true, aboveZeroTotalCount > 0);
	}

}
