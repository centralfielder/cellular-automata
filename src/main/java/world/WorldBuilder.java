package world;

public enum WorldBuilder {
	INSTANCE;
	
	public World makeWorld(int row, int col, WorldType type){
		switch(type){
		case EDGE: default:
			return new EdgeWorld(row, col);
		case WRAP:
			return new WrapWorld(row, col);
		}
	}
}
