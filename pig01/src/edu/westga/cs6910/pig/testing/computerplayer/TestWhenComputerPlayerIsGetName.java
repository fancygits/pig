package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests the getName method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerIsGetName {

	/**
	 * Test to confirm that a new ComputerPlayer getName should
	 * return the player's name, Simple Computer
	 */
	@Test
	void testGetNameForNewComputerPlayerShouldReturnSimpleComputer() {
		ComputerPlayer newComputer = new ComputerPlayer();
		assertEquals("Simple computer", newComputer.getName());
	}

}
