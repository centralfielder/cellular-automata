/**
 * This class models an abstract world. 
 * The abstract method getSquareInWorld must be overriden with
 * the specific logics needed to check if some coordinates return 
 * a square in the world or not (according to the type of world)
 * @author Luca Bisin
 */

package world;

import java.util.ArrayList;
import cell.*;

public abstract class World implements Runnable{
	/* Number of rows */
	private int rows;
	/* Number of columns */
	private int cols;
	/* 2D array containing the squares */
	private Square [][] squares;
	
	private String a = "Hey";
	/**
	 * Constructor
	 * @param rows Number of rows
	 * @param cols	Number of columns
	 */
	public World(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		
		// Initialize the Square array and add Square objects
		this.squares = new Square [this.rows][this.cols];
		for(int x = 0; x < this.rows; x++){
			for(int y = 0; y < this.cols; y++){
				this.squares [x][y] = new Square(x, y);
			}
		}
	}
	
	/**
	 * Place some starting cells
	 */
	public void init(){
		new Cell_1(0, 0, this);
		new Cell_1(4, 4, this);
		new Cell_2(0, 1, this);
		new Cell_2(1, 1, this);
	}
	
	/**
	 * Start life of placed cells
	 */
	public void startLife(){
		for(int x = 0; x < this.squares.length; x++){
			for(int y = 0; y < this.squares [x].length; y++){
				if(this.squares [x][y].getOccupiedBy() != null){
					this.squares [x][y].getOccupiedBy().startLife();
				}
			}
		}
	}
	
	/**
	 * Return a single square given its coordinates
	 * @param x	Coordinate x
	 * @param y Coordinate y
	 * @return Square
	 */
	public Square getSquare(int x, int y){
		return this.squares [x][y];
	}
	
	/**
	 * Get the area around a given square.
	 * The scope param specifies the number of squares to count
	 * from the starting one 
	 * @param s			The starting square
	 * @param scope	Number of squares from the starting one
	 * @return Array of Square objects
	 */
	public Square [] getArea(Square s, int scope){
		// Find upperleft corner of the area
		int xUpperLeft = s.getX() - scope;
		int yUpperLeft = s.getY() - scope;

		// Initialize an array list for storing squares
		ArrayList<Square> squares = new ArrayList<Square>();

		// From upperleft corner iterate in a sector 
		// whose side is: (scope * 2) + 1
		// and add squares to the ArrayList
		int side = (scope * 2) + 1;
		for(int x = xUpperLeft; x < xUpperLeft + side; x++){
			for(int y = yUpperLeft; y < yUpperLeft + side; y++){
				Square squareInWorld = this.getSquareInWorld(x, y);
				
				// This condition checks if the square at the given coordinates
				// is within the world, according to the world type
				if(squareInWorld != null){
					squares.add(squareInWorld);	
				}
			}
		}
		
		// ArrayList is converted to an array with the same size
		Square [] result = new Square [squares.size()];
		return squares.toArray(result);
	}
	
	/**
	 * A method to check if some coordinates return a square within the world.
	 * Must be overriden by the subclass to implement the logics specific to 
	 * the world type. E.g., the coordinates -1,-1 could return null ("edge"
	 * case) or the square at the opposite edge ("wrap" case). 
	 * @param x Coordinate X
	 * @param y Coordinate Y
	 * @return Square object or null (if the coordinates are outside the world)
	 */
	protected abstract Square getSquareInWorld(int x, int y);
	
	/**
	 * Get the value of the rows instance variable
	 * @return Number of rows as an integer
	 */
	public int getRows(){
		return this.rows;
	}
	
	/**
	 * Get the value of the cols instance variable
	 * @return Number of columns as an integer
	 */
	public int getCols(){
		return this.cols;
	}
	
	/**
	 * Print to the console a representation of the actual world
	 */
	public void output(){
		int counter = 0;
		for(Square r [] : this.squares){
			for(Square c : r){
				String out = "";
				if(c.getOccupiedBy() == null){
					out = " - ";
				}
				else{
					out = " " + c.getOccupiedBy().getSpecies() + " " ;
					counter++;
				}
				System.out.print(out);
			}
			System.out.print("\n");
		}
		System.out.println("Pop: "+ counter);
	}
	
	/**
	 * Run method. Calls itself recursively every 0.5 s.
	 */
	@Override
	public void run(){
		try{
			this.output();
         Thread.sleep(500);
			this.run();
		}
		catch(InterruptedException e){
			e.printStackTrace();	
		}
	}
}
