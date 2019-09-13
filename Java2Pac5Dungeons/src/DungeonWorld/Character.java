package DungeonWorld;

public abstract class Character {

	private int x;
	private int y;
	private String icon;
	
	public Character (int x, int y) {
		this.x = x;
		this.y = y;
		this.icon = "c";
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getIcon() {
		return this.icon;
	}

	@Override
	public String toString() {
		return "Character [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
