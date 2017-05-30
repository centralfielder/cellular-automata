package world;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import cell.*;

public class SquareTest {
	private World w;
	private AbstractCell c;
	private int cellX = 3;
	private int cellY = 3;
	private Square s = null;
	private int x = 4;
	private int y = 4;
	
	@Before
	public void setUp(){
		this.s = new Square(this.x, this.y);
		this.w = WorldBuilder.INSTANCE.makeWorld(10, 10, WorldType.WRAP);
		this.c = new Cell_1(this.cellX, this.cellY, w);
	}
	
	@Test
	public void testSquare() {
		assertNotNull(this.s);
	}

	@Test
	public void testGetOccupiedBy() {
		assertNull("Empty square: should return null", this.s.getOccupiedBy());
		this.s.setOccupiedBy(this.c);
		assertEquals(this.c, this.s.getOccupiedBy());
	}

	@Test
	public void testSetOccupiedBy() {
		this.s.setOccupiedBy(this.c);
		assertEquals(this.c, this.s.getOccupiedBy());
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
