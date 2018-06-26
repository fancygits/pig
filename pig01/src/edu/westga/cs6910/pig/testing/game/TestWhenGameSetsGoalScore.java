package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the getGoalScore and setGoalScore methods of Game
 * 
 * @author James Luke Johnson
 * @version 2018.06.26
 */
class TestWhenGameSetsGoalScore {

	/**Test to confirm that setGoalScore to 250 correctly gets the goalScore of 250
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#setGoalScore(int)}.
	 */
	@Test
	void testSetGoalScoreTo250ShouldReturnGoalScoreOf250() {
		Game newGame1 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		newGame1.setGoalScore(250);
		assertEquals(250, newGame1.getGoalScore());
	}

	/**
	 * Test to confirm that a new Game object gets a Goal Score of 100
	 * Test method for {@link edu.westga.cs6910.pig.model.Game#getGoalScore()}.
	 */
	@Test
	void testGetGoalScoreForNewGameShouldReturn100() {
		Game newGame2 = new Game(new HumanPlayer("Luke"), new ComputerPlayer(new CautiousStrategy()));
		assertEquals(100, newGame2.getGoalScore());
	}

}
