package cell;
import world.*;
/**
 * This models an abstract cell.
 * @author Luca Bisin
 */
public abstract class AbstractCell implements Runnable{
	/* An integer representing the cell's species */
	protected int species;
	/* Value for lifespan */
	protected int lifespan;
	/* Value for fitness */
	protected double fitness;
	/* The world where the cell is placed */
	private World world;
	/* The square where the cell is placed*/
	private Square placedAt;
	/* The thread of the cell */
	protected Thread t;
	/* A counter used to numbering the created cells (useful for debugging) */
	static int tCounter = 0;
	
	/**
	 * Constructor
	 * @param x			Coordinate x
	 * @param y			Coordinate y
	 * @param world	World object
	 */
	public AbstractCell(int x, int y, World world){
		this.world = world;
		this.placedAt = this.world.getSquare(x, y);
		
		this.t = new Thread(this);
		t.setName(tCounter + "_" + x + "_" + y);
		this.world.getSquare(x, y).setOccupiedBy(this);
		tCounter++;
	}
	
	/**
	 * Start the cell's thread
	 */
	public void startLife(){
		this.t.start();
	}
	
	/**
	 * Get the species of the cell
	 * @return String
	 */
	public int getSpecies(){
		return this.species;
	}
	
	/**
	 * Method to let a cell die
	 */
	public void die(){
		try{
			if(this.placedAt.getOccupiedBy() == this){
				this.placedAt.setOccupiedBy(null);
			}
			// Interrupt thread if sleeping
			this.t.interrupt();
		}
		catch(Exception e){
			System.err.println("---------- " + this.t.getName() + " could not die");
		}
	}
	
	/**
	 * Return the cell's vital space, i.e. the squares where 
	 * the cell can potentially reproduce itself 
	 * @return Array of Square objects
	 */
	public Square [] getVitalSpace(){
		return this.world.getArea(this.placedAt, 1);
	}
	
	/**
	 * Get reference to the world object
	 * @return World
	 */
	public World getWorld(){
		return this.world;
	}
	
	/**
	 * This is the abstract method for reproducing the cell.
	 * It must be overridden in the subclass
	 * @param s The square where the cell must try to reproduce itself
	 */
	protected abstract void reproduce(Square s);
	
	/**
	 * Check a single square to see if it is empty or full and
	 * accordingly try to reproduce the cell in that square.
	 * This method is synchronized and locks the square, 
	 * which means that while a cell is checking,
	 * no other cell can check the same square.
	 * @param s	The square to be checked
	 * @throws InterruptedException
	 */
	private void checkSquare(Square s) throws InterruptedException{
		synchronized(s){
			// Square is empty or occupied by this
			if(s.getOccupiedBy() == null || s.getOccupiedBy() == this){
				if(Math.random() <= this.fitness){
				
					this.reproduce(s);
				}
			}
			// Square is occupied by a rival
			else{
				AbstractCell rival = s.getOccupiedBy();
				
				// That rival might be no more there at this point
				if(rival == null){
					this.reproduce(s);
					return;
				}
				if(Math.random() <= (this.fitness - rival.fitness)){
					rival.die();
					this.reproduce(s);
				}
			}	
		}
	}
	
	/**
	 * Check vital space square by square
	 * The isInterrupted condition means that if a cell is murderd
	 * after having checked a square, it won't continue to check
	 * the remaining squares (and will not be able to place itself in 
	 * the checked square)
	 * TODO But here isInterrupted means the opposite as synchronized in
	 * the checkSquare method...
	 */
	public void checkVitalSpace(){
		Square [] vitalSpace = this.getVitalSpace();
		// Iterate through squares in vital space
		for(Square s : vitalSpace){
			// Skip its own square
			if(!s.equals(this.placedAt)){
				try {
					this.checkSquare(s);
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		// Own square is checked as last to avoid that a cell
		// can put a child in its own square before having finished
		// with other cells
		// TODO This should check for interrupted too(?)
		try {
			this.checkSquare(this.placedAt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void run(){
		try {
			Thread.sleep(this.lifespan * 1000);
			this.checkVitalSpace();
			this.die();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
// TODO Debug
	public Square getPlacedAt(){
		return this.placedAt;
	}
	
	public String getThreadName(){
		return this.t.getName();
	}
}
