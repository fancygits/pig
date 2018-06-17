package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the setIsMyTurn method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerIsSetIsMyTurn {

	/**
	 * Test to confirm that getIsMyTurn for a ComputerPlayer setIsMyTurn to false returns false
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#setIsMyTurn()}.
	 */
	@Test
	void testSetIsMyTurnToFalseForComputerPlayerShouldReturnFalse() {
		ComputerPlayer falseComputer = new ComputerPlayer(new CautiousStrategy());
		falseComputer.setIsMyTurn(false);
		assertEquals(false, falseComputer.getIsMyTurn());
	}
	
	/**
	 * Test to confirm that setIsMyTurn to true returns true
	 */
	@Test
	void testSetIsMyTurnForComputerPlayerSetIsMyTurnToTrueReturnsTrue() {
		ComputerPlayer trueComputer = new ComputerPlayer(new CautiousStrategy());
		trueComputer.setIsMyTurn(true);
		assertEquals(true, trueComputer.getIsMyTurn());
	}

}
