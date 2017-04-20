package world;

public final class WorldBuilder {
	private static AbstractWorld INSTANCE;
	
	public static void makeWorld(int row, int col, WorldType type) throws Exception{
		if(WorldBuilder.INSTANCE != null){
			switch(type){
			case EDGE:
				WorldBuilder.INSTANCE = new EdgeWorld(row, col);
			case WRAP:
				WorldBuilder.INSTANCE = new WrapWorld(row, col);
			}	
		}
		else{
			throw new Exception();
		}
	}
}
