package DungeonWorld;

public class Vampire extends Character {

	private String icon;

	public Vampire(int x, int y) {
		super(x, y);
		this.icon = "v";
	}

	public String getIcon() {
		return this.icon;
	}

	@Override
	public String toString() {
		return "Vampire " + super.toString();
	}

}
