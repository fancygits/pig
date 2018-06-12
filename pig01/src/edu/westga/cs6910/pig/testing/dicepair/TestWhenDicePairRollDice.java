package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the rollDice method of DicePair
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenDicePairRollDice {

	/**
	 * Test to confirm that a DicePair rolled 10000 times never is less than 2 or
	 * more than 12
	 * Test method for {@link edu.westga.cs6910.pig.model.DicePair#rollDice()}.
	 */
	@Test
	void testDiceRollRollDice10000TimesShouldNeverReturn1or13() {
		DicePair newPair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			newPair.rollDice();
			int sum = newPair.getDie1Value() + newPair.getDie2Value();
			if (sum < 2 || sum > 12) {
				fail("Rolled dice with values: " + newPair.getDie1Value() 
					+ ", " + newPair.getDie2Value());
			}
		}
	}
}
