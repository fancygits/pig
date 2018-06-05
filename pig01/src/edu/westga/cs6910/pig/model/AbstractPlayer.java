/**
 * 
 */
package edu.westga.cs6910.pig.model;

/**
 * 
 * 
 * @author James Luke Johnson
 * @version 2018.06.04
 *
 */
public abstract class AbstractPlayer implements Player {

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#takeTurn()
	 */
	@Override
	public void takeTurn() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#resetTurnTotal()
	 */
	@Override
	public void resetTurnTotal() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getIsMyTurn()
	 */
	@Override
	public boolean getIsMyTurn() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getTurnTotal()
	 */
	@Override
	public int getTurnTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getTotal()
	 */
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getDiceValues()
	 */
	@Override
	public String getDiceValues() {
		// TODO Auto-generated method stub
		return null;
	}

}
