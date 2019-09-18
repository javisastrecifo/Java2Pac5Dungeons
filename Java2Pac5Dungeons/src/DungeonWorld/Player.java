package DungeonWorld;

public class Player extends Character {

	private String icon;
	private int steps;

	public Player(int x, int y) {
		super(x, y);
		this.icon = "@";
		this.steps = 0;
	}

	public String getIcon() {
		return this.icon;
	}

	public int getSteps() {
		return this.steps;
	}

	@Override
	public String toString() {
		return "Player  " + super.toString();
	}

}
