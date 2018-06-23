package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the resetGame method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.23
 */
class TestWhenComputerPlayerResetsGame {

	/**
	 * Test to confirm that resetGame resets turnTotal and total to 0
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#resetGame()}.
	 */
	@Test
	void testResetGameForNewComputerPlayerShouldReturnTurnTotalAndTotalTo0() {
		ComputerPlayer newComputer = new ComputerPlayer(new CautiousStrategy());
		newComputer.resetGame();
		assertEquals(true, newComputer.getTurnTotal() == 0 && newComputer.getTotal() == 0);
	}
	
	/**
	 * Test to confirm that resetGame resets turnTotal and total to 0 after several turns
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#resetGame()}.
	 */
	@Test
	void testResetGameForComputerPlayerAfterSeveralTurnsShouldReturnTurnTotalAndTotalTo0() {
		ComputerPlayer newComputer = new ComputerPlayer(new CautiousStrategy());
		for (int count = 0; count < 10000; count++) {
			newComputer.setIsMyTurn(true);
			newComputer.takeTurn();
		}
		newComputer.resetGame();
		assertEquals(true, newComputer.getTurnTotal() == 0 && newComputer.getTotal() == 0);
	}

}
