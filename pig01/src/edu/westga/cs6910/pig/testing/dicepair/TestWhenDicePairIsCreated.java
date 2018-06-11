package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests the constructor to DicePair using the Die toString method
 * 
 * @author James Luke Johnson
 * @version 2018.06.11
 */
class TestWhenDicePairIsCreated {

	/**
	 * Test to confirm that the DicePair constructor creates 2 Die objects
	 * with each showing 1 pip
	 * Test method for {@link edu.westga.cs6910.pig.model.DicePair#DicePair()}.
	 */
	@Test
	void testDicePairConstructorShould2DiceWith1PipShowingEach() {
		DicePair newPair = new DicePair();
		assertEquals("1, 1", newPair.getDie1Value() + ", " + newPair.getDie2Value());
	}

}
