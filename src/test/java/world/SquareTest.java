package world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import cell.*;

public class SquareTest {
	private Square s = null;
	private int x = 4;
	private int y = 4;
	
	@Before
	public void init(){
		this.s = new Square(this.x, this.y);
	}
	
	@Test
	public void testSquare() {
		assertNotNull(this.s);
	}

	@Test
	public void testGetOccupiedBy() {
		assertNull("Should return null", this.s.getOccupiedBy());
	}

	@Test
	public void testSetOccupiedBy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		assertEquals(this.x, this.s.getX());
	}

	@Test
	public void testGetY() {
		assertEquals(this.y, this.s.getY());
	}

}
