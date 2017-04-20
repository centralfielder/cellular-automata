package world;

/**
 * This models a concrete world for the "wrap" case.
 * @author Luca Bisin
 */
public final class WrapWorld extends AbstractWorld{
	
	/**
	 * Constructor
	 * @param rows Number of rows
	 * @param cols Number of columns
	 */
	public WrapWorld(int rows, int cols){
		super(rows, cols);
	}
	
	@Override
	protected Square getSquareInWorld(int x, int y){
		int rows = this.getRows();
		int cols = this.getCols();
		
		// Resulting coordinates are stored here.
		// If x and y are within the world limits, resulting coordinates
		// are equal to x and y
		int xRef = x;
		int yRef = y;
		
		// X is greater than number of rows
		if(x >= rows){
			xRef = x - rows; 
		}
		// X is less than 0
		if(x < 0){
			xRef = rows + x;
		}
		// Y is greater than number of cols
		if(y >= cols){
			yRef = y - cols; 
		}
		// Y is less than 0
		if(y < 0){
			yRef = cols + y;
		}
		
		return this.getSquare(xRef, yRef);
	}
}
