/**
 * This class contains the main method
 * It creates a world object (as WrapWorld or EdgeWorld), 
 * inits the world (places some starting cells)
 * and starts the thread for the world.
 * @author Luca Bisin
 */

import world.*;

public class Main {

	public static void main(String [] args) {
		int rows = 20;
		int cols = 20;
		
		// Initialize WrapWorld
		AbstractWorld w = new WrapWorld(rows, cols);
		
		// Initialize EdgeWorld
//		AbstractWorld w = new EdgeWorld(rows, cols);
		
		w.init();
		w.startLife();
		Thread t = new Thread(w);
		t.start();
	}	
}
