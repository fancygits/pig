package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the constructor for Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsCreated {

	/**
	 * Test to confirm that a new Game object returns the appropriate toString
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#Game(edu.westga.cs6910.pig.model.HumanPlayer, edu.westga.cs6910.pig.model.ComputerPlayer)}.
	 */
	@Test
	void testGameConstructorShouldReturnStringWith2PlayersAndNoTotal() {
		Game newGame = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		assertEquals("Goal Score: 100" + System.getProperty("line.separator")
					+ "Luke: 0" + System.getProperty("line.separator")
					+ "Simple computer: 0", newGame.toString());
	}

}
