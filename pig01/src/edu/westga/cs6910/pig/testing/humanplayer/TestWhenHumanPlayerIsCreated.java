package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests the constructor for HumanPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenHumanPlayerIsCreated {

	/**
	 * Test to confirm that a new HumanPlayer is named correctly
	 * Test method for {@link edu.westga.cs6910.pig.model.HumanPlayer#HumanPlayer(java.lang.String)}.
	 */
	@Test
	void testHumanPlayerShouldConstructHumanPlayerWithNameLuke() {
		HumanPlayer newHuman = new HumanPlayer("Luke");
		assertEquals("Luke", newHuman.getName());
	}

}
