package DungeonWorld;

import java.util.ArrayList;
import java.util.Random;

public class ElementsDB {

	private ArrayList<Character> elements;
	
	public ElementsDB() {
		this.elements = new ArrayList<Character>();
	}
	
	public ArrayList<Character> getList(){
		return this.elements;
	}
	
	public Vampire createVampire(int widthLimit, int lengthLimit) {
		Random rand = new Random();
		
		int newX = rand.nextInt(widthLimit);
		int newY = rand.nextInt(lengthLimit);
		
		Vampire v = new Vampire (newX,newY);
		return v;
	}
	
	public Player createPlayer() {
		Player p = new Player (0,0);
		return p;
	}
}
