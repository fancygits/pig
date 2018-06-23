package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the startNewGame method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsStartNewGame {

	/**
	 * Test to confirm that startNewGame on a new Game returns the HumanPlayer
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#startNewGame()}.
	 */
	@Test
	void testStartNewGameShouldReturnHumanPlayerAndNewDicePairAndResetGame() {
		Game newGame1 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame1.startNewGame(newGame1.getHumanPlayer());
		assertEquals(true, 
				newGame1.getHumanPlayer() == newGame1.getCurrentPlayer() 
				&& "1, 1".equals(newGame1.getDicePair().getDie1Value() + ", " + newGame1.getDicePair().getDie2Value())
				&& newGame1.getHumanPlayer().getTotal() == 0
				&& newGame1.getHumanPlayer().getTurnTotal() == 0
				&& newGame1.getComputerPlayer().getTotal() == 0
				&& newGame1.getComputerPlayer().getTurnTotal() == 0);
	}

	/**
	 * Test to confirm that startNewGame on a new Game returns the ComputerPlayer
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#startNewGame()}.
	 */
	@Test
	void testStartNewGameShouldReturnComputerPlayerAndNewDicePairAndResetGame() {
		Game newGame2 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame2.startNewGame(newGame2.getComputerPlayer());
		assertEquals(true, newGame2.getComputerPlayer() == newGame2.getCurrentPlayer() 
				&& "1, 1".equals(newGame2.getDicePair().getDie1Value() + ", " + newGame2.getDicePair().getDie2Value())
				&& newGame2.getHumanPlayer().getTotal() == 0
				&& newGame2.getHumanPlayer().getTurnTotal() == 0
				&& newGame2.getComputerPlayer().getTotal() == 0
				&& newGame2.getComputerPlayer().getTurnTotal() == 0);
	}
	
	/**
	 * Test to confirm that startNewGame on a new Game returns the ComputerPlayer
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#startNewGame()}.
	 */
	@Test
	void testStartNewGameAfter10000TurnsShouldReturnComputerPlayerAndNewDicePairAndResetGame() {
		Game newGame2 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		for (int count = 0; count < 10000; count++) {
			newGame2.getComputerPlayer().setIsMyTurn(true);
			newGame2.getComputerPlayer().takeTurn();
		}
		for (int count = 0; count < 10000; count++) {
			newGame2.getHumanPlayer().takeTurn();
		}
		newGame2.startNewGame(newGame2.getComputerPlayer());
		assertEquals(true, newGame2.getComputerPlayer() == newGame2.getCurrentPlayer() 
				&& "1, 1".equals(newGame2.getDicePair().getDie1Value() + ", " + newGame2.getDicePair().getDie2Value())
				&& newGame2.getHumanPlayer().getTotal() == 0
				&& newGame2.getHumanPlayer().getTurnTotal() == 0
				&& newGame2.getComputerPlayer().getTotal() == 0
				&& newGame2.getComputerPlayer().getTurnTotal() == 0);
	}
}
