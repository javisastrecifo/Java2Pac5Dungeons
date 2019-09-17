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
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract String getIcon();

	@Override
	public String toString() {
		return x + " " + y;
	}
	
	
	
}
