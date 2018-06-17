package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the getCurrentPlayer method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsGetCurrentPlayer {

	/**
	 * Test to confirm that getCurrentPlayer on a new Game returns the HumanPlayer
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#getCurrentPlayer()}.
	 */
	@Test
	void testGetCurrentPlayerShouldReturnHumanPlayer() {
		Game newGame1 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame1.startNewGame(newGame1.getHumanPlayer());
		assertEquals(newGame1.getHumanPlayer(), newGame1.getCurrentPlayer());
	}

	/**
	 * Test to confirm that getCurrentPlayer on a new Game returns the ComputerPlayer
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#getCurrentPlayer()}.
	 */
	@Test
	void testGetCurrentPlayerShouldReturnComputerPlayer() {
		Game newGame2 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame2.startNewGame(newGame2.getComputerPlayer());
		assertEquals(newGame2.getComputerPlayer(), newGame2.getCurrentPlayer());
	}
}
