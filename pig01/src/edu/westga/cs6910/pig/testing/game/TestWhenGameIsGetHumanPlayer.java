package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the getHumanPlayer method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsGetHumanPlayer {

	/**
	 * Test to confirm that getComputerPlayer returns the HumanPlayer named Luke
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#getHumanPlayer()}.
	 */
	@Test
	void testGetHumanPlayer() {
		Game newGame = new Game(new HumanPlayer("Luke"), new ComputerPlayer());
		assertEquals("Luke", newGame.getHumanPlayer().getName());
	}

}
