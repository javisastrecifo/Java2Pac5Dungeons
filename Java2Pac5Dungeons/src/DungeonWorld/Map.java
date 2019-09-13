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
		System.out.println(elements.getList());
		printMap(elements);
	}

	public void printMap(ElementsDB elements) {
		// print each point checking the character's positions
		String[][] gameGrid = new String[getWidth()][getHeight()];
		for (int wid = 0; wid < getHeight(); wid++) {
		
			for (int heig = 0; heig < getHeight(); heig++) {
				
				for (int character = 0; character < elements.getList().size(); character++) {
					
					if ((elements.getList().get(character).getX() == wid)
							&& (elements.getList().get(character).getY() == heig)) {
						
						gameGrid[wid][heig] = elements.getList().get(character).getIcon();
						
						
					} else {
						gameGrid[wid][heig] = ".";
					}

				}
			}

		}
		System.out.print(gameGrid[0][0]);
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

}
