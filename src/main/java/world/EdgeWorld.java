/**
 * This models a concrete world for the "edge" case.
 * A square whose coordinates are beyond the limits of the world
 * is considered null.
 * @author Luca Bisin
 */

package world;

import java.util.AbstractMap;

public final class EdgeWorld extends World{
	
	/**
	 * Constructor
	 * @param rows	Number of rows
	 * @param cols Number of columns
	 */
	public EdgeWorld(int rows, int cols){
		super(rows, cols);
	}
	
	/**
	 * Returns a pair of coordinates for a square, validated according to
	 * the world type, or null if the coordinates are not valid in the world.
	 * @param x
	 * @param y
	 * @return A SimpleImmutableEntry storing coordinates or null
	 */
	@Override
	protected AbstractMap.SimpleImmutableEntry<Integer, Integer> 
	checkCoordinates(int x, int y){
		int rows = this.getRows();
		int cols = this.getCols();
		
		// Returns true if the coordinates are within the limits of the world
		if(x >= 0 && x < rows){
			if(y >= 0 && y < cols){
				return new AbstractMap.SimpleImmutableEntry<Integer, Integer>(
						x,y
						);
			}
		}
		return null;
	}
}
