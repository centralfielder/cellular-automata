/**
 * This class contains the main method
 * It creates a world object (as WrapWorld or EdgeWorld), 
 * inits the world (places some starting cells)
 * and starts the thread for the world.
 * @author Luca Bisin
 */

import java.lang.reflect.Field;
import world.*;

public class Main {

	public static void main(String [] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		World w = WorldBuilder.INSTANCE.makeWorld(10, 10, WorldType.WRAP);
		w.init();
		w.startLife();
		Thread t = new Thread(w);
		t.start();
	}	
}
