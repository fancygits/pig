package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests the constructor and toString method of Die
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenDieIsCreated {

	/**
	 * Test to confirm that a new Die object is constructed and returns the correct
	 * toString statement.
	 * Test method for {@link edu.westga.cs6910.pig.model.Die#Die(java.util.Random)}.
	 */
	@Test
	void testShouldProduceDieWith1Pip() {
		Die newDie = new Die(new Random());
		assertEquals("pips: 1", newDie.toString());
	}
}
