package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the resetGame method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.23
 */
class TestWhenHumanPlayerResetsGame {

	/**
	 * Test to confirm that resetGame resets turnTotal and total to 0
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#resetGame()}.
	 */
	@Test
	void testResetGameForNewHumanPlayerShouldReturnTurnTotalAndTotalTo0() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		newHuman.resetGame();
		assertEquals(true, newHuman.getTurnTotal() == 0 && newHuman.getTotal() == 0);
	}
	
	/**
	 * Test to confirm that resetGame resets turnTotal and total to 0 after several turns
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#resetGame()}.
	 */
	@Test
	void testResetGameForHumanPlayerAfterSeveralTurnsShouldReturnTurnTotalAndTotalTo0() {
		HumanPlayer newHuman = new HumanPlayer("James");
		for (int count = 0; count < 10000; count++) {
			newHuman.takeTurn();
		}
		newHuman.resetGame();
		assertEquals(true, newHuman.getTurnTotal() == 0 && newHuman.getTotal() == 0);
	}

}
