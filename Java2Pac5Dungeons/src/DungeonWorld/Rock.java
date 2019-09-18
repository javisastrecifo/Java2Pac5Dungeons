package DungeonWorld;

public class Rock extends Character {

	private String icon;
	private int steps;

	public Rock(int x, int y) {
		super(x, y);
		this.icon = "O";
		this.steps = 0;
	}

	@Override
	public String getIcon() {
		return this.icon;
	}

	@Override
	public int getSteps() {
		return this.steps;
	}
	
	@Override
	public String toString() {
		return "Rock    " + super.toString();
	}


}
