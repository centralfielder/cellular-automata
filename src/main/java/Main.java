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
		World w = WorldBuilder.INSTANCE.makeWorld(4, 4, WorldType.EDGE);
		Class<?> c = w.getClass();
		Class<?> sc = c.getSuperclass();
		Field f = sc.getDeclaredField("squares");
		f.setAccessible(true);
		Square [][] squares = (Square[][]) f.get(w);
		System.out.println(squares.length);
		
	}	
}
