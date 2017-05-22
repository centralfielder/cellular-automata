package world;

import static org.junit.Assert.*;

import java.util.AbstractMap;

import org.junit.Before;
import org.junit.Test;

public class WrapWorldTest {
	private World w = null;
	private int rows = 4;
	private int cols = 4;
	
	@Before
	public void init(){
		this.w = WorldBuilder.INSTANCE.makeWorld(
				this.rows, 
				this.cols, 
				WorldType.WRAP
				);
	}
	
	@Test
	public void testCheckCoordinates() {
		// Valid coordinates (2,3)
		AbstractMap.SimpleImmutableEntry<Integer, Integer> validCoordinates = 
				this.w.checkCoordinates(2, 3);
		AbstractMap.SimpleImmutableEntry<Integer, Integer> expected = 
				new AbstractMap.SimpleImmutableEntry<Integer, Integer>(2, 3);
		assertNotNull("Coordinates should be not null", validCoordinates);
		assertEquals("Coordinates are not as expected", expected, validCoordinates);
		
		// Wrap case (5,7). Expected is (1,3)
		AbstractMap.SimpleImmutableEntry<Integer, Integer> notValidCoordinates = 
				this.w.checkCoordinates(5, 7);
		AbstractMap.SimpleImmutableEntry<Integer, Integer> notValidExpected = 
				new AbstractMap.SimpleImmutableEntry<Integer, Integer>(1, 3);
		assertEquals("Not valid coordinates are not as expected", notValidExpected, notValidCoordinates);
	}

}
