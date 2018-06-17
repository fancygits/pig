package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the getDicePair method of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGameIsGetDicePair {

	/**
	 * Test to confirm that getDicePair returns a DicePair with each showing 1 pip
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#getDicePair()}.
	 */
	@Test
	void testGetDicePairShouldReturnDicePairWithEachPipShowing1() {
		Game newGame = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		assertEquals("1, 1", newGame.getDicePair().getDie1Value() + ", " + newGame.getDicePair().getDie2Value());
	}

}
