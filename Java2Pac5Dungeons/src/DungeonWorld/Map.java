package DungeonWorld;

import java.util.Arrays;

public class Map {

	private int width;
	private int height;
	private int vampires;
	private boolean vampiresMove;
	public int counter;

	public Map(int width, int height, int vampires, int counter, boolean movement) {
		this.width = width;
		this.height = height;
		this.vampires = vampires;
		this.vampiresMove = movement;
		this.counter = counter;
	}

	public void start(ElementsDB elements) {
		elements.getList().add(elements.createPlayer());
		for (int i = 0; i < this.vampires; i++) {
			elements.getList().add(elements.createVampire(this.width, this.height));
		}
	}

	public void print(ElementsDB elements) {
		elements.printList();
		System.out.println();

		String[][] gameGrid = new String[getWidth()][getHeight()];

		// fill each point checking the character's positions
		for (int wid = 0; wid < getWidth(); wid++) {
			for (int heig = 0; heig < getHeight(); heig++) {
				if (elements.isThereAnybody(wid, heig)) {
					gameGrid[wid][heig] = elements.getCharacter(elements.whoIsIt(wid, heig)) + " ";
				} else {
					gameGrid[wid][heig] = "� ";
				}
			}
		}

		// print the Array, row by row
		for (int c = 0; c < getHeight(); c++) {
			for (int r = 0; r < getWidth(); r++) {

				System.out.print(gameGrid[r][c]);
			}
			System.out.println();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getVampires() {
		return vampires;
	}

	public int getCounter() {
		return counter;
	}
	
	public void reduceCounter() {
		this.counter--;
	}
}
