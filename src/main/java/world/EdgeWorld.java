/**
 * This models a concrete world for the "edge" case.
 * A square whose coordinates are beyond the limits of the world
 * is considered null.
 * @author Luca Bisin
 */

package world;
public final class EdgeWorld extends AbstractWorld{
	
	/**
	 * Constructor
	 * @param rows	Number of rows
	 * @param cols Number of columns
	 */
	public EdgeWorld(int rows, int cols){
		super(rows, cols);
	}
	
	@Override
	protected Square getSquareInWorld(int x, int y){
		int rows = this.getRows();
		int cols = this.getCols();
		
		// If the coordinates are within the limits of the world,
		// return the corresponding square
		if(x >= 0 && x < rows){
			if(y >= 0 && y < cols){
				return this.getSquare(x, y);
			}
		}
		// Else return null
		return null;
	}
}
