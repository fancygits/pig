package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the play method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsPlayed {

	/**
	 * Test to confirm that a new Game when play returns 
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#play()}.
	 */
	@Test
	void testPlayShouldReturnTurnTotalAbove0CountAbove0() {
		Game newGame1 = new Game(new HumanPlayer("Luke"), new ComputerPlayer());
		newGame1.startNewGame(newGame1.getHumanPlayer());
		int aboveZeroTotalCount = 0;
		for (int count = 0; count < 10000; count++) {
			newGame1.play();
			if (newGame1.getHumanPlayer().getTurnTotal() > 0) {
				aboveZeroTotalCount++;
			}
			newGame1.getHumanPlayer().resetTurnTotal();
		}
		assertEquals(true, aboveZeroTotalCount > 0);
	}

}
