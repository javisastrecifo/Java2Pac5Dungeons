package DungeonWorld;

public class Vampire extends Character {

	private String icon;
	private int steps;

	public Vampire(int x, int y) {
		super(x, y);
		this.icon = "v";
		this.steps = 1;
	}

	public String getIcon() {
		return this.icon;
	}
	
	public int getSteps() {
		return this.steps;
	}

	@Override
	public String toString() {
		return "Vampire " + super.toString();
	}

}
