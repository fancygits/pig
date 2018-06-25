package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the setAutoRoll method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.24
 */
class TestWhenComputerPlayerSetsAutoRoll {

	/**
	 * Test to confirm that a new ComputerPlayer getAutoRoll is false
	 * Test method for {@link edu.westga.cs6910.pig.model.ComputerPlayer#setAutoRoll(boolean)}.
	 */
	@Test
	void testGetAutoRollToFalseShouldReturnFalse() {
		ComputerPlayer newComputer1 = new ComputerPlayer(new CautiousStrategy());
		assertEquals(false, newComputer1.getAutoRoll());
	}
	
	@Test
	void testSetAutoRollToTrueShouldReturnTrue() {
		ComputerPlayer newComputer2 = new ComputerPlayer(new CautiousStrategy());
		newComputer2.setAutoRoll(true);
		assertEquals(true, newComputer2.getAutoRoll());
	}

}
