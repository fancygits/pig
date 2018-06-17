package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the hold method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsHold {

	/**
	 * Test to confirm that hold on a game with currentPlayer of HumanPlayer 
	 * returns the ComputerPlayer as currentPlayer
	 */
	@Test
	void testHoldWhenHumanPlayerIsCurrentPlayerShouldReturnComputerPlayerIsCurrentPlayer() {
		Game newGame1 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame1.startNewGame(newGame1.getHumanPlayer());
		newGame1.hold();
		assertEquals(newGame1.getComputerPlayer(), newGame1.getCurrentPlayer());
	}

	
	/**
	 * Test to confirm that hold on a game with currentPlayer of ComputerPlayer 
	 * returns the HumanPlayer as currentPlayer
	 */
	@Test
	void testHoldWhenComputerPlayerIsCurrentPlayerShouldReturnHumanPlayerIsCurrentPlayer() {
		Game newGame2 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame2.startNewGame(newGame2.getComputerPlayer());
		newGame2.hold();
		assertEquals(newGame2.getHumanPlayer(), newGame2.getCurrentPlayer());
	}
}
