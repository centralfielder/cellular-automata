package world;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
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
			throws NoSuchFieldException, SecurityException, 
			IllegalArgumentException, IllegalAccessException{
		
		// Gets squares private field
		Class<?> sc = this.w.getClass().getSuperclass();
		Field f = sc.getDeclaredField("squares");
		f.setAccessible(true);
		Square [][] squares = (Square [][]) f.get(this.w);
		
		// Checks length
		assertTrue(squares.length == this.rows);
		assertTrue(squares [0].length == this.cols);
	}
	
	
	@Test
	public void testGetRows(){
		assertTrue(this.w.getRows() == this.rows);
	}
	
	@Test
	public void testGetCols(){
		assertTrue(this.w.getCols() == this.cols);
	}
	
}
