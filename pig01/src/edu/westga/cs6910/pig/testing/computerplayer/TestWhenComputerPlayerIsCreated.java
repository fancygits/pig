package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests the constructor for ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerIsCreated {

	/**
	 * Test to confirm that a new ComputerPlayer is named correctly
	 * Test method for {@link edu.westga.cs6910.pig.model.ComputerPlayer#ComputerPlayer(java.lang.String)}.
	 */
	@Test
	void testComputerPlayerShouldConstructComputerPlayerWithNameSimpleComputer() {
		ComputerPlayer newComputer = new ComputerPlayer();
		assertEquals("Simple computer", newComputer.getName());
	}

}
