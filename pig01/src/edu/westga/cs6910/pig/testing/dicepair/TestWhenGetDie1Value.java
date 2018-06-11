package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the getDie1Value method of DicePair
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGetDie1Value {

	/**
	 * Test to confirm that getDie1Value of a new DicePair returns 1
	 * Test method for {@link edu.westga.cs6910.pig.model.DicePair#getDie1Value()}.
	 */
	@Test
	void testGetDie1ValueForNewDicePairShouldReturn1() {
		DicePair pair1 = new DicePair();
		assertEquals(1, pair1.getDie1Value());
	}
	
	/**
	 * Test to confirm that getDie1Value of a pair rolled 10000 times never
	 * returns less than 1 or more than 6
	 */
	@Test
	void testGetDie1ValueForPairRolled10000TimesShouldNeverReturn0Or7() {
		DicePair pair2 = new DicePair();
		for (int count = 0; count < 10000; count++) {
			pair2.rollDice();
			if (pair2.getDie1Value() < 1 || pair2.getDie1Value() > 6) {
				fail("Rolled a die with value: " + pair2.getDie1Value());
			}
		}
	}
}
