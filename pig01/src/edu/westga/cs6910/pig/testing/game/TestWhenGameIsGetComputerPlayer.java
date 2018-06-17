package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the getComputerPlayer method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsGetComputerPlayer {

	/**
	 * Test to confirm that getComputerPlayer returns the Simple Computer player
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#getComputerPlayer()}.
	 */
	@Test
	void testGetComputerPlayerShouldReturnNameOfSimpleComputer() {
		Game newGame = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		assertEquals("Simple computer", newGame.getComputerPlayer().getName());
	}

}
