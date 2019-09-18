package DungeonWorld;

import java.util.ArrayList;
import java.util.Random;

public class Characters {

	private ArrayList<Character> characterList;

	public Characters() {
		this.characterList = new ArrayList<Character>();
	}

	public Vampire createVampire(int widthLimit, int heightLimit) {
		Random rand = new Random();

		while (true) {
			int newX = rand.nextInt(widthLimit);
			int newY = rand.nextInt(heightLimit);

			if (!isThereAnybody(newX, newY)) {

				Vampire v = new Vampire(newX, newY);
				return v;
			}
		}
	}

	public void killCharacter(int listNumber) {
		this.characterList.remove(listNumber);
	}

	public Player createPlayer() {
		Player p = new Player(0, 0);
		return p;
	}

	public boolean isThereAnybody(int givenX, int givenY) {

		for (int i = 0; i < this.characterList.size(); i++) {
			if ((this.characterList.get(i).getX() == givenX) && (this.characterList.get(i).getY() == givenY)) {
				return true;
			}
		}
		return false;
	}

	public int whoIsIt(int givenX, int givenY) {

		for (int i = 0; i < this.characterList.size(); i++) {
			if ((this.characterList.get(i).getX() == givenX) && (this.characterList.get(i).getY() == givenY)) {
				return i;
			}
		}
		return -1;
	}

	public String getCharacter(int givenIndex) {
		return this.characterList.get(givenIndex).getIcon();
	}

	public void printList() {
		for (int i = 0; i < this.characterList.size(); i++) {
			System.out.println(this.characterList.get(i));
		}
	}

	public ArrayList<Character> getList() {
		return this.characterList;
	}
}
