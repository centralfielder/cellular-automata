package cell;
/**
 * This class defines a cell of species 1 
 * @author Luca Bisin
 */
import java.util.Random;
import world.*;

public class Cell_1 extends AbstractCell{
	/* A constant containing the maximum lifespan value */
	final int MAX_LIFESPAN = 10;
	/* A constant containing the fitness value */
	final double FITNESS = 0.8;
	
	/**
	 * Constructor
	 * @param x Coordinate X of the square where the cell must be placed
	 * @param y Coordinate Y of the square where the cell must be placed
	 * @param world The world object
	 */
	public Cell_1(int x, int y, World world){
		super(x, y, world);
		this.lifespan = new Random().nextInt(this.MAX_LIFESPAN + 1);
		this.fitness = this.FITNESS;
		this.species = 1;
	}
	
	@Override
	public void reproduce(Square s){
		Cell_1 c = new Cell_1(s.getX(), s.getY(), this.getWorld());
		c.startLife();
	}
	
}
