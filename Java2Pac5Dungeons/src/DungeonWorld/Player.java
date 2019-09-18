package DungeonWorld;

public class Player extends Character {

	private String icon;
	
	public Player (int x, int y) {
		super(x, y);
		this.icon = "@";
	}
	
	public String getIcon() {
		return this.icon;
	}

	@Override
	public String toString() {
		return "Player  " + super.toString();
	}
	
}
