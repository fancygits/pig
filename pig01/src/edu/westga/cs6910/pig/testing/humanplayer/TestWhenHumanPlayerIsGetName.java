package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the getName method of HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerIsGetName {

	/**
	 * Test to confirm that a new HumanPlayer getName should
	 * return the player's name, Luke
	 */
	@Test
	void testGetNameForNewHumanPlayerShouldReturnLuke() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		assertEquals("Luke", newHuman.getName());
	}

}
