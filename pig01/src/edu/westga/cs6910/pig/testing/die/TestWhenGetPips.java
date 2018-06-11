package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests the getNumberOfPips method of Die
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenGetPips {

	/**
	 * Test to confirm that a newly constructed Die has 1 pip showing 
	 * Test method for {@link edu.westga.cs6910.pig.model.Die#getNumberOfPips()}.
	 */
	@Test
	void testWithNewDieShouldHave1Pip() {
		Die newDie = new Die(new Random());
		assertEquals(1, newDie.getNumberOfPips());
	}

}
