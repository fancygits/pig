package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests the roll method of Die
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenRoll {

	/**
	 * Test to confirm that roll never returns less than 1, or more than 7
	 * Test method for {@link edu.westga.cs6910.pig.model.Die#roll()}.
	 */
	@Test
	void testRoll10000TimesShouldNotReturn0or7() {
		Die testDie = new Die(new Random());
			for (int count = 0; count < 10000; count++) {
				testDie.roll();
				if (testDie.getNumberOfPips() < 1 
						|| testDie.getNumberOfPips() > 6) {
					fail("Rolled a die with value: "
						+ testDie.getNumberOfPips());
				}
			}
	}

}
