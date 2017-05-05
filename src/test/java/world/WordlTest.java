package world;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class WordlTest {
	private World w = null;
	private int rows = 4;
	private int cols = 4;
	
	@Before
	public void init(){
		this.w = WorldBuilder.INSTANCE.makeWorld(
				this.rows, 
				this.cols, 
				WorldType.EDGE
				);
	}
	
	@Test
	public void testRowsAreInitialized() {
		assertTrue(this.w.getRows() == this.rows);
	}
	
	@Test
	public void testColsAreInitialized() {
		assertTrue(this.w.getCols() == this.cols);
	}
	
	@Test
	public void testSquareArrayIsInitialized() 
			throws NoSuchFieldException, SecurityException{
		Class c = this.w.getClass();
		Field f = c.getDeclaredField("squares");
		f.setAccessible(true);
		
		// Checks length
		//assertTrue(f.get(this.w));
	}

}
