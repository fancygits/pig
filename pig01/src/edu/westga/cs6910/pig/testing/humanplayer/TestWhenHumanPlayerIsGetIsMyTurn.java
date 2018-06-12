package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the getIsMyTurn method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerIsGetIsMyTurn {

	/**
	 * Test to confirm that getIsMyTurn for a new HumanPlayer returns false
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#getIsMyTurn()}.
	 */
	@Test
	void testGetIsMyTurnForNewHumanPlayerShouldReturnFalse() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		assertEquals(false, newHuman.getIsMyTurn());
	}
	
	@Test
	void testGetIsMyTurnForHumanPlayerSetIsMyTurnToTrueReturnsTrue() {
		HumanPlayer humanTurn = new HumanPlayer("Luke");
		humanTurn.setIsMyTurn(true);
		assertEquals(true, humanTurn.getIsMyTurn());
	}

}
