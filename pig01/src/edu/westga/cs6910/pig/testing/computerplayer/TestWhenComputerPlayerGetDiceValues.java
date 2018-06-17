package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the getDiceValues method of ComputerPlayer
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenComputerPlayerGetDiceValues {

	/**
	 * Test to confirm that getDiceValues never returns less than 1 or more than 6 for each die
	 * Test method for {@link edu.westga.cs6910.pig.model.AbstractPlayer#getDiceValues()}.
	 */
	@Test
	void testGetDiceValues10000TimesWillNeverReturn0Or7() {
		ComputerPlayer newComputer = new ComputerPlayer(new CautiousStrategy());
		for (int count = 0; count < 10000; count++) {
			String diceValues = newComputer.getDiceValues();
			int die1 = Integer.parseInt(diceValues.substring(0, 1));
			int die2 = Integer.parseInt(diceValues.substring(3, 4));
			if (die1 < 1 || die1 > 6 || die2 < 1 || die2 > 6) {
				fail("Dice values are: " + diceValues);
			}
		}
	}

}
