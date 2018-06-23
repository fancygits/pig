package edu.westga.cs6910.pig.model;

/**
 * Defines the AbstractPlayer class and methods
 * 
 * @author James Luke Johnson
 * @version 2018.06.04
 *
 */
public abstract class AbstractPlayer implements Player {

	private String name;
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;
	
	/**
	 * Creates a new AbstractPlayer with specified name
	 * @param name	String name of player
	 */
	public AbstractPlayer(String name) {
		this.name = name;
		this.thePair = new DicePair();
		this.total = 0;
	}
	
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#takeTurn()
	 */
	@Override
	public void takeTurn() {
		this.thePair.rollDice();
		
		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		
		if (die1Value == 1 || die2Value == 1) {
			this.total -= this.turnTotal;
			this.isMyTurn = false;
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
	}
	
	//*************************** mutator methods ****************************
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#resetTurnTotal()
	 */
	@Override
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}
	
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#resetGame()
	 */
	public void resetGame() {
		this.resetTurnTotal();
		this.total = 0;
	}
	
	/**
	 * Modifier for isMyTurn
	 * @param isMyTurn	boolean
	 */
	public void setIsMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	//*************************** accessor methods ****************************
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getIsMyTurn()
	 */
	@Override
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getTurnTotal()
	 */
	@Override
	public int getTurnTotal() {
		return this.turnTotal;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getTotal()
	 */
	@Override
	public int getTotal() {
		return this.total;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.pig.model.Player#getDiceValues()
	 */
	@Override
	public String getDiceValues() {
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}

}
