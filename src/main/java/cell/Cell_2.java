package cell;
/**
 * This class defines a cell of species 2 
 * @author Luca Bisin
 */
import java.util.Random;
import world.*;

public class Cell_2 extends AbstractCell {
	/* A constant containing the maximum lifespan value */
	final int MAX_LIFESPAN = 5;
	/* A constant containing the fitness value */
	final double FITNESS = 0.4;
	
	/**
	 * Constructor
	 * @param x Coordinate X of the square where the cell must be placed
	 * @param y Coordinate Y of the square where the cell must be placed
	 * @param world The world object
	 */
	public Cell_2(int x, int y, AbstractWorld world){
		super(x, y, world);
		this.lifespan = new Random().nextInt(this.MAX_LIFESPAN + 1);
		this.fitness = this.FITNESS;
		this.species = 2;
	}
	
	public void reproduce(Square s){
		Cell_2 c = new Cell_2(s.getX(), s.getY(), this.getWorld());
		c.startLife();
	}
}
