package world;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;

public class WorldBuilderTest {
	private World w = null;
	private final int ROWS = 4;
	private final int COLS = 4;
	
	@Test
	public void testInstanceOfEdgeWorld() {
		this.w = WorldBuilder.INSTANCE.makeWorld(this.ROWS, this.COLS, WorldType.EDGE);
		assertThat(this.w, instanceOf(EdgeWorld.class));
	}
	
	@Test
	public void testInstanceOfWrapWorld() {
		this.w = WorldBuilder.INSTANCE.makeWorld(this.ROWS, this.COLS, WorldType.WRAP);
		assertThat(this.w, instanceOf(WrapWorld.class));
	}
}
