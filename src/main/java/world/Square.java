package world;
/**
 * This class models a single square in the world.
 * @author Luca Bisin
 */

import cell.*;

public class Square {
	/* X coordinate of the square */
	private int x;
	/* Y coordinate of the square */
	private int y;
	/* The cell placed in the square (will be null if the square is free) */
	private AbstractCell occupiedBy;
	
	/**
	 * Constructor
	 * @param x Coordinate X 
	 * @param y	Coordinate Y
	 */
	public Square(int x, int y){
		this.x = x;
		this.y = y;
		// Square is initialized as empty
		this.occupiedBy = null;
	}

	/**
	 * Return the cell placed in the square 
	 * @return AbstractCell or null if the square is free
	 */
	public AbstractCell getOccupiedBy() {
		return this.occupiedBy;
	}

	/**
	 * Place a single cell in the square
	 * @param cell	The cell to be placed in the square
	 */
	public void setOccupiedBy(AbstractCell cell) {
		this.occupiedBy = cell;
	}

	/**
	 * Get the X coordinate of the square
	 * @return X coordinate as int
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Get the y coordinate of the square
	 * @return y coordinate as int
	 */
	public int getY() {
		return this.y;
	}
}
