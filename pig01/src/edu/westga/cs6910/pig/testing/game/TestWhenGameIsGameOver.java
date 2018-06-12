package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the isGameOver method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsGameOver {

	/**
	 * Test to confirm that isGameOver on a new Game returns true
	 * since the game was created but not started yet
	 * 
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#isGameOver()}.
	 */
	@Test
	void testIsGameOverOnNewGameShouldReturnTrue() {
		Game newGame1 = new Game(new HumanPlayer("Luke"), new ComputerPlayer());
		assertEquals(true, newGame1.isGameOver());
	}

	
	/**
	 * Test to confirm that isGameOver on a new Game returns false since game
	 * was just started
	 * 
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#isGameOver()}.
	 */
	@Test
	void testIsGameOverOnStaredGameShouldReturnFalse() {
		Game newGame2 = new Game(new HumanPlayer("Luke"), new ComputerPlayer());
		newGame2.startNewGame(newGame2.getHumanPlayer());
		assertEquals(false, newGame2.isGameOver());
	}
}
