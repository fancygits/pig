package edu.westga.cs6910.pig.testing.cautiousstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.stategies.CautiousStrategy;

/**
 * Tests the default constructor and rollAgain method of CautiousStrategy
 * 
 * @author James Luke Johnson
 * @version 2018.06.15
 */
class TestWhenCautiousStrategyIsCreated {

	/**
	 * Test to confirm that rollAgain always returns false
	 * Test method for {@link edu.westga.cs6910.pig.model.stategies.CautiousStrategy#rollAgain(int, int, int)}.
	 */
	@Test
	void testRollAgainForNewCautiousStrategyRollAgainShouldReturnFalse() {
		CautiousStrategy strategy1 = new CautiousStrategy();
		assertEquals(false, strategy1.rollAgain(0, 0, 0));
	}
	
	/**
	 * Test to confirm that rollAgain always returns false
	 * Test method for {@link edu.westga.cs6910.pig.model.stategies.CautiousStrategy#rollAgain(int, int, int)}.
	 */
	@Test
	void testRollAgainForNewCautiousStrategyRollAgainForLargeParametersShouldReturnFalse() {
		CautiousStrategy strategy2 = new CautiousStrategy();
		assertEquals(false, strategy2.rollAgain(1000, 1000, 1000));
	}
	
	/**
	 * Test to confirm that CautiousStrategy rollAgain 10000 times always returns false, regardless of parameters
	 */
	@Test
	void testRollAgainForCautiousStrategy10000TimesShouldAlwaysReturnFalse() {
		CautiousStrategy strategy3 = new CautiousStrategy();
		for (int count = 0; count < 10000; count++) {
			if (strategy3.rollAgain((int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100))) {
				fail("CautiousStrategy returned TRUE!");
			}
		}
	}

}
