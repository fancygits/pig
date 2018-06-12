package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the setIsMyTurn method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerIsSetIsMyTurn {

	/**
	 * Test to confirm that getIsMyTurn for a HumanPlayer setIsMyTurn to false returns false
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#setIsMyTurn()}.
	 */
	@Test
	void testSetIsMyTurnToFalseForHumanPlayerShouldReturnFalse() {
		HumanPlayer falseHuman = new HumanPlayer("Luke");
		falseHuman.setIsMyTurn(false);
		assertEquals(false, falseHuman.getIsMyTurn());
	}
	
	/**
	 * Test to confirm that setIsMyTurn to true returns true
	 */
	@Test
	void testSetIsMyTurnForHumanPlayerSetIsMyTurnToTrueReturnsTrue() {
		HumanPlayer trueHuman = new HumanPlayer("Luke");
		trueHuman.setIsMyTurn(true);
		assertEquals(true, trueHuman.getIsMyTurn());
	}

}
