package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests the getIsMyTurn method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerIsGetIsMyTurn {

	/**
	 * Test to confirm that getIsMyTurn for a new ComputerPlayer returns false
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#getIsMyTurn()}.
	 */
	@Test
	void testGetIsMyTurnForNewComputerPlayerShouldReturnFalse() {
		ComputerPlayer newComputer = new ComputerPlayer();
		assertEquals(false, newComputer.getIsMyTurn());
	}
	
	@Test
	void testGetIsMyTurnForComputerPlayerSetIsMyTurnToTrueReturnsTrue() {
		ComputerPlayer newComputer2 = new ComputerPlayer();
		newComputer2.setIsMyTurn(true);
		assertEquals(true, newComputer2.getIsMyTurn());
	}

}
